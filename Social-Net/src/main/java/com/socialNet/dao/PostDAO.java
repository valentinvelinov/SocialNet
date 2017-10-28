package com.socialnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.socialnet.dbmanager.DBConnection;
import com.socialnet.exception.PostException;
import com.socialnet.exception.UserException;
import com.socialnet.model.Post;
import com.socialnet.model.User;
@Component
public class PostDAO {
	private static final String INSERT_POST_SQL = "INSERT INTO posts VALUES (null,?,?)";
	private static final String SELECT_POST_BY_ID = "SELECT * FROM posts WHERE post_id=?";

	public int makePost(Post post, User user) throws PostException {
		Connection con = DBConnection.getInstance().getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(INSERT_POST_SQL, Statement.RETURN_GENERATED_KEYS);
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
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_POST_BY_ID);
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
