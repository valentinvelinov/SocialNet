package com.socialnet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.socialnet.dbmanager.DBConnection;
import com.socialnet.exception.ConversationException;
import com.socialnet.model.Conversation;
@Component
public class ConversationDAO {
	@Autowired
    DBConnection connection;

    private static Connection conn;
	private static final String INSERT_CONVERSATION_SQL = "INSERT INTO Conversations VALUES (null, ?, ?)";

	public int startConversation(Conversation conversation) throws ConversationException {
		conn=connection.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(INSERT_CONVERSATION_SQL,
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
