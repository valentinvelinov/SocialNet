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
import com.socialNet.exception.CommentException;
import com.socialNet.exception.UserException;
import com.socialNet.interfaces.IComment;
import com.socialNet.model.Comment;

@Component
public class CommentDAO implements IComment {
	@Autowired
	DBConnection connection;

	private static Connection conn;
	private static final String INSERT_COMMENT_SQL = "INSERT INTO comments VALUES (null,?,?,?,?)";
	private static final String SHOW_COMMENTS_BY_POST = "SELECT * FROM comments WHERE post_id=?";

	public int postComment(Comment comment) throws CommentException {
		conn = connection.getConnection();
		try {
			java.sql.Date sqlStartDate = new java.sql.Date(comment.getDateComment().getTime());
			PreparedStatement ps = conn.prepareStatement(INSERT_COMMENT_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, comment.getPostId());
			ps.setString(2, comment.getText());
			ps.setInt(3, comment.getUserId());
			ps.setDate(4, sqlStartDate);

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new CommentException("Post cannot be commented right now, please try again later.", e);
		}
	}

	public List<Comment> showCommetsByPost(int postId) throws CommentException, UserException {
		try {
			conn = connection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SHOW_COMMENTS_BY_POST, Statement.RETURN_GENERATED_KEYS);
			List<Comment> comments = new ArrayList<Comment>();

			ps.setInt(1, postId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Comment comment = new Comment();

				comment.setCommentId(rs.getInt("comment_id"));
				comment.setText(rs.getString("text"));
				comment.setDateComment(rs.getTimestamp("datecomment"));
				comment.getUser().setFirstName(rs.getString("first_name"));
				comment.getUser().setLastName(rs.getString("last_name"));
				comment.getPost().setPostId(rs.getInt("post_id"));
				comments.add(comment);
			}
			rs.close();
			ps.close();
			return comments;
		} catch (SQLException sql) {
			System.out.println(sql);
		}
		return null;
	}
}
