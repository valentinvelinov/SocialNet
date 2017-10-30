package com.socialNet.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.socialNet.dbmanager.DBConnection;
import com.socialNet.exception.CommentException;
import com.socialNet.model.Comment;

@Component
public class CommentDao {
	@Autowired
    DBConnection connection;

    private static Connection conn;
	private static final String INSERT_COMMENT_SQL = "INSERT INTO comments VALUES (null,?,?,?)";
	
	public int postComment (Comment comment) throws CommentException {
		conn=connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(INSERT_COMMENT_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, comment.getPost_id());
			ps.setString(2, comment.getText());
			ps.setInt(3, comment.getUser_id());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new CommentException("Post cannot be commented right now, please try again later.", e);
	}
}
}
