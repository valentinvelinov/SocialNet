package com.socialNet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.socialNet.dbmanager.DBConnection;
import com.socialNet.exceptions.ConversationException;
import com.socialNet.exceptions.UserException;
import com.socialNet.pojo.Conversation;
import com.socialNet.pojo.User;

public class ConversationDAO {

	private static final String INSERT_CONVERSATION_SQL = "INSERT INTO Conversations VALUES (null, ?, ?)";

	public int startConversation(Conversation conversation) throws ConversationException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_CONVERSATION_SQL,
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, conversation.getText());
			ps.setDate(2,  (Date) conversation.getDate());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			conversation.setConversation_id(rs.getInt(1));
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();

			throw new ConversationException("You cannot start a conversation now, please try again later.", e);
		}
	}

}