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
import com.socialNet.exception.ConversationException;
import com.socialNet.exception.MessageException;
import com.socialNet.interfaces.IMessage;
import com.socialNet.model.Conversation;
import com.socialNet.model.Message;

@Component
public class MessageDAO implements IMessage {

	@Autowired
	DBConnection connection;
	private static Connection conn;
	private static final String SELECT_MESSAGES_BY_CONVERSATION = "SELECT * FROM messages WHERE conversation_id=?";

	public ArrayList<Message> getMessages(int conversationId) throws MessageException {
		conn = connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_MESSAGES_BY_CONVERSATION);
			ps.setInt(1, conversationId);
			ArrayList<Message> messages = new ArrayList<Message>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Message message = new Message();
				message.setMessageId(rs.getInt(1));
				message.setConversationId(rs.getInt(2));
				message.setContent(rs.getString(3));
				message.setDate(rs.getDate(4));
				messages.add(message);
			}
			return messages;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MessageException("Your message cannot be received right now, please try again later.");
		}
	}
	

}
