package com.socialNet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.socialNet.dbmanager.DBConnection;
import com.socialNet.exception.CommentException;
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

	private static Connection conn;
	private static final String SELECT_ALL_CONVERSATIONS = "SELECT * FROM chat_user WHERE user_id=?";
	private static final String SELECT_CONVERSATION_BY_ID = "SELECT * FROM conversations WHERE conversation_id=?";

	public ArrayList<Conversation> getUserConversations(int userId) throws ConversationException {
		conn = connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_ALL_CONVERSATIONS);
			ps.setInt(1, userId);
			ArrayList<Conversation> myConversations = new ArrayList<Conversation>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int conversationId = rs.getInt(1);
				Conversation conversation = this.getConversationById(conversationId);
				myConversations.add(conversation);
			}
			return myConversations;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ConversationException("Your converastions cannot be received right now, please try again later.");
		}
	}

	public Conversation getConversationById(int conversationId) throws ConversationException {
		conn = connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_CONVERSATION_BY_ID);
			ps.setInt(1, conversationId);

			ResultSet rs = ps.executeQuery();
			Conversation conversation = new Conversation();
			while (rs.next()) {
				conversation.setConversationId(rs.getInt(1));
				conversation.setTitle(rs.getString(2));
			}
			if (conversation.getTitle() == null) {
				throw new ConversationException("Conversation cannot be received right now, please try again later.");
			} else {
				return conversation;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ConversationException("Conversation cannot be received right now, please try again later.");
		}

	}

}
