package com.socialNet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.socialNet.dbmanager.DBConnection;
import com.socialNet.exceptions.CommentException;
import com.socialNet.pojo.Comment;


public class CommentDao {
	private static final String INSERT_COMMENT_SQL = "INSERT INTO comments VALUES (null,?,?,?)";
	
	public void postComment (Comment comment) throws CommentException {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(INSERT_COMMENT_SQL);
			ps.setInt(1, comment.getPost_id());
			ps.setString(2, comment.getText());
			ps.setInt(3, comment.getUser_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new CommentException("Post cannot be commented right now, please try again later.", e);
		
	}
}
}
