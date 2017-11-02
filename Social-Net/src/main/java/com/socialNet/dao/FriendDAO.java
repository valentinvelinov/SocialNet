package com.socialNet.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.socialNet.dbmanager.DBConnection;
import com.socialNet.exception.FriendException;
import com.socialNet.exception.UserException;
import com.socialNet.interfaces.IFriend;
import com.socialNet.model.Friend;

@Component
public class FriendDAO implements IFriend {
	@Autowired
	DBConnection connection;

	private static Connection conn;
	private static final String INSERT_FRIEND_SQL = "INSERT INTO friends VALUES (null, ?)";
	private static final String SELECT_ALL_FRIENDS = "SELECT * FROM friends WHERE user_id=?";
	private static final String REMOVE_FRIEND = "DELETE FROM `friends` WHERE id IN (SELECT * FROM friends WHERE frien_id = )\\n";
	private static final String CHECK_FRIEND = "";

	public int addFriend(Friend friend) throws FriendException {
		conn = connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(INSERT_FRIEND_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, friend.getFriendId());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			friend.setFriendId(rs.getInt(1));
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new FriendException("You cannot add this person as friend now, please try again later.", e);
		}
	}

	@Override
	public List<Friend> getFriends(Friend friend) throws UserException {
		conn = connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_ALL_FRIENDS, Statement.RETURN_GENERATED_KEYS);
			List<Friend> friends = new ArrayList<Friend>();

			ps.setInt(1, friend.getUserOneId().getUserId());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				friend = new Friend();

				friend.getUserOneId().setUserId(rs.getInt("user_id1"));
				friend.getUserTwoId().setUserId(rs.getInt("user_id2"));
				friend.getUserTwoId().setFirstName(rs.getString("first_name"));
				friend.getUserTwoId().setLastName(rs.getString("last_name"));

				friends.add(friend);
			}
			rs.close();
			ps.close();
			conn.close();
			return friends;
		} catch (SQLException sql) {
			System.out.println(sql);
		}
		return null;
	}

	@Override
	public boolean removeFriend(Friend friend) {
		conn = connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(REMOVE_FRIEND, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, friend.getUserOneId().getUserId());
			ps.setInt(2, friend.getUserTwoId().getUserId());
			ps.execute();
			ps.close();
			conn.close();
			return true;
		} catch (SQLException sql) {
			System.out.println(sql);
		}
		return false;
	}

	@Override
	public boolean verifiesIfTheresAlreadyThisFriend(Friend friendship) {
		conn = connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(CHECK_FRIEND, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, friendship.getUserOneId().getUserId());
			ps.setInt(2, friendship.getUserTwoId().getUserId());

			ResultSet rs = ps.executeQuery();
			boolean check = false;

			while (rs.next()) {
				check = true;
				System.out.println("YOU ARE ALREADY FRIENDS WITH THIS DUDE");
				friendship = null;
			}
			rs.close();
			ps.close();
			conn.close();
			return check;

		} catch (SQLException sql) {
			System.out.println(sql);
		}
		return false;
	}
}
