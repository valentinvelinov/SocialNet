package com.socialNet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

	
	ArrayList<Post> listOfPosts = new ArrayList<Post>(); 
	
	private static Connection conn;
	private static final String INSERT_POST_SQL = "INSERT INTO posts VALUES (null,?,?)";
	private static final String SELECT_POST_BY_ID = "SELECT * FROM posts WHERE post_id=?";
	private static final String SELECT_ALL_POSTS = "SELECT * FROM posts";

	public ArrayList<Post> viewAllPosts() throws PostException, UserException, SQLException {
		conn = connection.getConnection();
		// List<Post> posts = new ArrayList<Post>();
		// posts.add(getPostById(7));
		// posts.add(getPostById(8));
		// return Collections.unmodifiableList(posts);

		PreparedStatement ps = conn.prepareStatement(SELECT_ALL_POSTS, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = ps.executeQuery();
		
		
		// Fetch each row from the result set
		while (rs.next()) {
			int i = rs.getInt("post_id");
			String str = rs.getString("content");
			int i2 = rs.getInt("user_id");

			Post post = new Post(i, str, i2);
			listOfPosts.add(post);
		}
		return listOfPosts;
	}

	public int makePost(Post post, User user) throws PostException {
		conn = connection.getConnection();

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
		conn = connection.getConnection();

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
