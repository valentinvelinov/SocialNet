package com.socialNet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.socialNet.dbmanager.DBConnection;
import com.socialNet.exceptions.CommentException;
import com.socialNet.pojo.Comment;


public class CommentDao {
	private static final String INSERT_COMMENT_SQL = "INSERT INTO comments VALUES (null,?,?,?)";
	
	public int postComment (Comment comment) throws CommentException {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(INSERT_COMMENT_SQL, Statement.RETURN_GENERATED_KEYS);
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
