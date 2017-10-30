package com.socialNet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.socialNet.dbmanager.DBConnection;
import com.socialNet.exception.PostException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Post;
import com.socialNet.model.User;
@Component
public class PostDAO {
	@Autowired
    DBConnection connection;

    private static Connection conn;
	private static final String INSERT_POST_SQL = "INSERT INTO posts VALUES (null,?,?)";
	private static final String SELECT_POST_BY_ID = "SELECT * FROM posts WHERE post_id=?";

	public int makePost(Post post, User user) throws PostException {
		conn=connection.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(INSERT_POST_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, post.getContent());
			ps.setInt(2, user.getUser_id());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new PostException("Post cannot be posted right now, please try again later.", e);
		}
	}

	public Post getPostById(int id) throws UserException, PostException {
		conn=connection.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_POST_BY_ID);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next() == false) {
				throw new UserException("There no post with this id.");
			}
			return new Post(rs.getInt(1), rs.getString(2), rs.getInt(3));
		} catch (SQLException e) {
			throw new PostException("There no post with this id.", e);
		}
	}
}
