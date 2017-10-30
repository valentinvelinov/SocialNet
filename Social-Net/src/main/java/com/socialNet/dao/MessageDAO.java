package com.socialNet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.socialNet.dbmanager.DBConnection;
import com.socialNet.exception.MessageException;
import com.socialNet.model.Message;
@Component
public class MessageDAO {

	@Autowired
    DBConnection connection;
    private static Connection conn;
	private static final String INSERT_MESSAGE_SQL = "INSERT INTO messages VALUES (null, ?, ?, ?)";

	public int sendMessage(Message message) throws MessageException {
		conn=connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(INSERT_MESSAGE_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, message.getConversation_id());
			ps.setString(2, message.getContent());
			ps.setDate(3, message.getDate());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			message.setMessage_id(rs.getInt(1));
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new MessageException("You cannot send a message now, please try again later.", e);
		}
	}

}
