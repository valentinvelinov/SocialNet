package com.socialnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.socialnet.dbmanager.DBConnection;
import com.socialnet.exception.FriendException;
import com.socialnet.model.Friend;
@Component
public class FriendDAO {
	@Autowired
    DBConnection connection;

    private static Connection conn;
	private static final String INSERT_FRIEND_SQL = "INSERT INTO friends VALUES (null, ?)";

	public int addFriend(Friend friend) throws FriendException {
		conn=connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(INSERT_FRIEND_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, friend.getFriend_id());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			friend.setFriend_id(rs.getInt(1));
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new FriendException("You cannot add this person as friend now, please try again later.", e);
		}
	}

}
