package com.socialNet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.socialNet.dbmanager.DBConnection;
import com.socialNet.exceptions.FriendException;
import com.socialNet.exceptions.UserException;
import com.socialNet.pojo.Friend;

public class FriendDAO {

	private static final String INSERT_FRIEND_SQL = "INSERT INTO friends VALUES (null, ?)";

	public int addFriend(Friend friend) throws FriendException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_FRIEND_SQL, Statement.RETURN_GENERATED_KEYS);
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
