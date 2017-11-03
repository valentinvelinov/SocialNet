package com.socialNet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.socialNet.dbmanager.DBConnection;
import com.socialNet.exception.ConversationException;
import com.socialNet.exception.UserException;
import com.socialNet.interfaces.IConversation;
import com.socialNet.model.Conversation;
import com.socialNet.model.Post;
import com.socialNet.model.User;

@Component
public class ConversationDAO implements IConversation {
	@Autowired
	DBConnection connection;
	ArrayList<Conversation> listOfConversations = new ArrayList<Conversation>();

	private static Connection conn;
	private static final String INSERT_CONVERSATION_SQL = "INSERT INTO Conversations VALUES (null, ?)";
	private static final String DELETE_CONV_BY_ID = "SELECT * FROM conversations WHERE conversation_id=?";
	private static final String SELECT_ALL_CONV = "SELECT * FROM conversations";

	public int startConversation(Conversation conversation, User user) throws ConversationException {
		conn = connection.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(INSERT_CONVERSATION_SQL, Statement.RETURN_GENERATED_KEYS);
//			ps.setString(1, conversation.getContentConversation());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			conversation.setConversationId(rs.getInt(1));
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();

			throw new ConversationException("You cannot start a conversation now, please try again later.", e);
		}
	}

	public void deleteConversation(Integer conversationId) throws UserException, ConversationException {
		conn = connection.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(DELETE_CONV_BY_ID);
			ps.setInt(1, conversationId);
			ResultSet rs = ps.executeQuery();

			if (rs.next() == false) {
				throw new UserException("There no conversation with this id.");
			}
		} catch (SQLException e) {
			throw new ConversationException("There is no conversation with this id.", e);
		}

	}

	// Posts of all conversations
	public ArrayList<Conversation> viewAllConversations(User user)
			throws ConversationException, UserException, SQLException {
		conn = connection.getConnection();
		PreparedStatement ps = conn.prepareStatement(SELECT_ALL_CONV, Statement.RETURN_GENERATED_KEYS);
		int uid = user.getUserId();
		ps.setInt(1, uid);
		System.err.println(uid);
		ResultSet rs = ps.executeQuery();
		listOfConversations.clear();
		while (rs.next()) {
			int id = rs.getInt("conversation_id");
			String cont = rs.getString("content");

//			Conversation conversation = new Conversation(id, cont);
//			listOfConversations.add(conversation);
		}
		for (Conversation c : listOfConversations) {
			System.out.println("collection" + c);
		}
		return listOfConversations;
	}

}
