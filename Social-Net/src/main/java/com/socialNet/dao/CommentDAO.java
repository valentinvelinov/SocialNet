package com.socialNet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
	private static final String DELETE_COMMENT_BY_ID_SQL = "DELETE FROM comments WHERE comment_id=?";
	private static final String UPDATE_COMMENT_BY_ID_SQL = "UPDATE comments SET text=? WHERE comment_id=?";
	private static final String SELECT_COMMENT_BY_ID_SQL = "SELECT * FROM comments WHERE comment_id=?";
	private static final String INSERT_COMMENT_SQL = "INSERT INTO comments VALUES (null,?,?,?,?)";
	private static final String SHOW_COMMENTS_BY_POST = "SELECT * FROM comments WHERE post_id=?";

	public void postComment(int postId, int userId, String content) throws CommentException {
		conn = connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(INSERT_COMMENT_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, postId);
			ps.setString(2, content);
			ps.setInt(3, userId);
			ps.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
		} catch (SQLException e) {
			throw new CommentException("Comment cannot be created right now, please try again later.", e);
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
				comment.setPostId(postId);
				comment.setCommentId(rs.getInt("comment_id"));
				comment.setText(rs.getString("text"));
				comment.setDateComment(rs.getTimestamp("date_comment"));
				comment.setUserId(rs.getInt("user_id"));
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

	public Comment getCommentById(int id) throws UserException {
		conn = connection.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_COMMENT_BY_ID_SQL);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next() == false) {
				throw new UserException("Comment not available!");
			}
			return new Comment(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getDate(5));
		} catch (SQLException e) {
			throw new UserException("Please try to login again", e);
		}

	}

	public void updateComment(int id, String content) throws CommentException {
		conn = connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(UPDATE_COMMENT_BY_ID_SQL);
			ps.setString(1, content);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new CommentException("Comment can't be edited right now, please try again later.", e);
		}
	}

	public void deleteComment(int commentId) throws CommentException {
		conn = connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(DELETE_COMMENT_BY_ID_SQL);
			ps.setInt(1, commentId);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new CommentException("Comment can't be deleted right now, please try again later.", e);
		}

	}
}
