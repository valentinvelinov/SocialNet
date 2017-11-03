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
import com.socialNet.exception.MessageException;
import com.socialNet.exception.UserException;
import com.socialNet.interfaces.IMessage;
import com.socialNet.model.Message;

@Component
public class MessageDAO implements IMessage {

	@Autowired
	DBConnection connection;
	private static Connection conn;
	private static final String INSERT_MESSAGE_SQL = "INSERT INTO messages VALUES (null, ?, ?, ?)";
	private static final String DISPLAY_CONVERSATION_BETWEEN_TWO_USERS = "";
	private static final String DISPLAY_CONVERSATION = "";

	public int sendMessage(Message message) throws MessageException {
		conn = connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(INSERT_MESSAGE_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, message.getConversationId());
			ps.setString(2, message.getContent());
			ps.setDate(3, message.getDate());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			message.setMessageId(rs.getInt(1));
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new MessageException("You cannot send a message now, please try again later.", e);
		}
	}

	public List<Message> displayConversationBetweenUsers(Message message)
			throws ClassNotFoundException, UserException, MessageException {
		conn = connection.getConnection();
		try {
			// String query = "{CALL message__displayConversationBetweenUsers(?,?)}";
			PreparedStatement ps = conn.prepareStatement(DISPLAY_CONVERSATION_BETWEEN_TWO_USERS,
					Statement.RETURN_GENERATED_KEYS);
			List<Message> messages = new ArrayList<Message>();

//			ps.setInt(1, message.getUserOne().getUserId());
//			ps.setInt(2, message.getUserTwo().getUserId());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				message = new Message();

//				message.getUserOne().setUserId(rs.getInt("user_id"));
//				message.getUserTwo().setUserId(rs.getInt("user_id2"));
//				message.getUserOne().setFirstName(rs.getString("first_name"));
//				message.getUserOne().setLastName(rs.getString("last_name"));
//				message.getSent().setUserId(rs.getInt("user_idSenter"));
				message.setContent(rs.getString("message"));
				message.setDate(rs.getDate("date"));

				messages.add(message);
			}
			rs.close();
			ps.close();
			conn.close();
			return messages;
		} catch (SQLException sql) {
			System.out.println(sql);
		}
		return null;
	}

	public List<Message> displayConversation(Message message)
			throws ClassNotFoundException, UserException, MessageException {
		conn = connection.getConnection();
		try {
			// String query = "{CALL message__displayConversations(?)}";
			PreparedStatement ps = conn.prepareStatement(DISPLAY_CONVERSATION, Statement.RETURN_GENERATED_KEYS);
			List<Message> messages = new ArrayList<Message>();

//			ps.setInt(1, message.getUserOne().getUserId());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				message = new Message();

//				message.getUserOne().setUserId(rs.getInt("user_id1"));
//				message.getUserTwo().setUserId(rs.getInt("user_id2"));
//				message.getUserOne().setFirstName(rs.getString("first_name"));
//				message.getUserOne().setLastName(rs.getString("last_name"));
//				message.setContent(rs.getString("message"));
//				message.setDate(rs.getDate("date"));
//				message.getUserTwo().setProfilePicUrl(rs.getString("profile_pic_url"));

				messages.add(message);
			}
			rs.close();
			conn.close();
			ps.close();
			return messages;
		} catch (SQLException sql) {
			System.out.println(sql);
		}
		return null;
	}

}
