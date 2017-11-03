package com.socialNet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.socialNet.dbmanager.DBConnection;
import com.socialNet.exception.UserException;
import com.socialNet.interfaces.IUser;
import com.socialNet.model.User;

@Component
public class UserDAO implements IUser {
	@Autowired
	DBConnection connection;

	private static Connection conn;
	private static final String INSERT_USER_SQL = "INSERT INTO users VALUES (null, ?, ?, ?, ?, ?, md5(?))";
	private static final String SELECT_USER_SQL = "SELECT user_id FROM users WHERE email = ? AND password = md5(?)";
	private static final String SELECT_USER_BY_ID_SQL = "SELECT * FROM users WHERE user_id = ?";

	public int registerUser(User user) throws UserException {
		conn = connection.getConnection();

		try {

			java.sql.Date sqlStartDate = new java.sql.Date(user.getBirthDate().getTime());
			PreparedStatement ps = conn.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setDate(4, sqlStartDate);
			ps.setString(5, user.getGender());
			ps.setString(6, user.getPassword());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			user.setUserId(rs.getInt(1));
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new UserException("User cannot be registered now, please try again later.", e);
		}
	}

	public void loginUser(User user) throws UserException {
		conn = connection.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_USER_SQL);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());

			ResultSet rs = ps.executeQuery();
			if (rs.next() == false) {
				throw new UserException("Wrong password or email! Please, try again!.");
			}
			user.setUserId(rs.getInt(1));
		} catch (SQLException e) {
			throw new UserException("User cannot be logged right now.", e);
		}
	}

	public User getUserById(int id) throws UserException {
		conn = connection.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID_SQL);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next() == false) {
				throw new UserException("User not available!");
			}
			return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
					rs.getString(6), rs.getString(7));
		} catch (SQLException e) {
			throw new UserException("Please try to login again", e);
		}

	}

	
}
