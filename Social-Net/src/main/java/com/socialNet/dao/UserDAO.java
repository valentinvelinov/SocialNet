package com.socialNet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.socialNet.dbmanager.DBConnection;
import com.socialNet.exceptions.UserException;
import com.socialNet.pojo.User;
import com.socialNet.pojo.User.Gender;

// data access object
public class UserDAO {

	private static final String INSERT_USER_SQL = "INSERT INTO users VALUES (null, ?, ?, ?, ?, ?, md5(?))";
	private static final String SELECT_USER_SQL = "SELECT user_id FROM users WHERE email = ? AND password = md5(?)";
	private static final String SELECT_USER_BY_ID_SQL = "SELECT * FROM users WHERE user_id = ?";

	public int registerUser(User user) throws UserException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getFirst_name());
			ps.setString(2, user.getLast_name());
			ps.setString(3, user.getEmail());
			ps.setDate(4, (Date) user.getBirth_date());
			ps.setString(5, user.getGender().toString());
			ps.setString(6, user.getPassword());
//			ps.setString(8, user.getProfile_pic_url());
//			ps.setString(9, user.getCover_pic_url());
//			ps.setString(10, user.getJob());
//			ps.setString(11, user.getPlace());
//			ps.setString(12, user.getEducation());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			user.setUser_id(rs.getInt(1));
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new UserException("User cannot be registered now, please try again later.", e);
		}
	}

	public int loginUser(User user) throws UserException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_USER_SQL);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());

			ResultSet rs = ps.executeQuery();
			if (rs.next() == false) {
				throw new UserException("Wrong password or email! Please, try again!.");
			}
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new UserException("User cannot be logged right now.", e);
		}
	}

	public User getUserById(int id) throws UserException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_ID_SQL);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next() == false) {
				throw new UserException("There no user with this id.");
			}
			Gender gender = null;
			if (rs.getString(6).equals(Gender.FEMALE.toString())) {
				gender = gender.FEMALE;
			} else {
				gender = gender.MALE;

			}
			return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), gender,
					rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
					rs.getString(12));
			// return rs.getInt(1);
		} catch (SQLException e) {
			throw new UserException("There no user with this id.", e);
		}

	}

	public List<User> friendsSortedByPlace(String first_name, boolean order) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> friendsSortedByDateOfBirth(java.util.Date birth_date, boolean order) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> friendsSortedByName(String first_name, boolean order) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> nonFriendsFor(Integer personId) {
		// TODO Auto-generated method stub
		return null;
	}

}
