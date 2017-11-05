package com.socialNet.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
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
import com.socialNet.exception.CommentException;
import com.socialNet.exception.PostException;
import com.socialNet.exception.UserException;
import com.socialNet.interfaces.IPost;
import com.socialNet.model.Post;
import com.socialNet.model.User;

@Component
public class PostDAO implements IPost {
	@Autowired
	DBConnection connection;

	ArrayList<Post> listOfPosts = new ArrayList<Post>();
	ArrayList<Post> listOfUserPosts = new ArrayList<Post>();

	private static Connection conn;
	private static final String INSERT_POST_SQL = "INSERT INTO posts VALUES (null,?,?,?,?,?,?)";
	private static final String SELECT_POST_BY_ID = "SELECT * FROM posts WHERE post_id=?";
	private static final String SELECT_ALL_POSTS = "SELECT * FROM posts WHERE user_id=?";
	private static final String DELETE_POST_BY_ID = "DELETE FROM `posts-db` WHERE id IN (SELECT * FROM posts WHERE post_id = )\n"
			+ "";
	private static final String SELECT_USER_POSTS = "SELECT * FROM posts ";
	private static final String ADD_LIKE = "INSERT INTO likes VALUES (null,?,?)";
	private static final String SELECT_NUM_LIKES = "SELECT like_count COUNT(*) FROM posts";
	private static final String SELECT_NUM_COMMENTS = "SELECT like_comment COUNT(*) FROM posts";
	private static final String UPDATE_POST_BY_ID_SQL = "UPDATE posts SET content=? WHERE post_id=?";
	private static final String DELETE_POST_BY_ID_SQL = "DELETE FROM posts WHERE post_id=?";

	public ArrayList<Post> viewAllMyPosts(User user) throws PostException, UserException, SQLException {
		conn = connection.getConnection();
		PreparedStatement ps = conn.prepareStatement(SELECT_ALL_POSTS, Statement.RETURN_GENERATED_KEYS);
		int uid = user.getUserId();
		ps.setInt(1, uid);
		System.err.println(uid);
		ResultSet rs = ps.executeQuery();
		listOfPosts.clear();
		while (rs.next()) {
			int id = rs.getInt("post_id");
			String cont = rs.getString("content");
			String pic = rs.getString("picture_name");
			Date d = rs.getDate("date_post");

			Post post = new Post(id, cont, uid, pic, d);
			listOfPosts.add(post);
		}
		for (Post p : listOfPosts) {
			System.out.println("collection" + p);
		}
		return listOfPosts;
	}

	// Posts of all people
	public ArrayList<Post> viewAllPosts(User user) throws PostException, UserException, SQLException {
		conn = connection.getConnection();
		PreparedStatement ps = conn.prepareStatement(SELECT_USER_POSTS, Statement.RETURN_GENERATED_KEYS);

		ResultSet rs = ps.executeQuery();
		listOfUserPosts.clear();
		while (rs.next()) {
			int id = rs.getInt("post_id");
			String cont = rs.getString("content");
			int uid = rs.getInt("user_id");
			String pic = rs.getString("picture_name");
			Date d = rs.getDate("date_post");
			Post post = new Post(id, cont, uid, pic, d);
			listOfUserPosts.add(post);
		}
		for (Post p : listOfUserPosts) {
			System.out.println("collection" + p);
		}
		return listOfUserPosts;
	}

	public int makePost(Post post, User user) throws PostException {
		conn = connection.getConnection();

		try {
			java.sql.Date sqlStartDate = new java.sql.Date(post.getDatePost().getTime());
			PreparedStatement ps = conn.prepareStatement(INSERT_POST_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, post.getContent());
			ps.setInt(2, user.getUserId());
			ps.setString(3, post.getPictureName());
			ps.setDate(4, sqlStartDate);

			PreparedStatement ps2 = conn.prepareStatement(SELECT_NUM_LIKES, Statement.RETURN_GENERATED_KEYS);
			int cLikes = ps2.executeUpdate();
			ps2.setInt(5, cLikes);
			System.err.println(cLikes);
			PreparedStatement ps3 = conn.prepareStatement(SELECT_NUM_COMMENTS, Statement.RETURN_GENERATED_KEYS);
			int cComments = ps3.executeUpdate();
			System.err.println(cComments);
			ps2.setInt(6, cComments);

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
			return new Post(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getDate(5));
		} catch (SQLException e) {
			throw new PostException("There no post with this id.", e);
		}
	}

	public void updatePost(int id, String content) throws PostException {
		conn = connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(UPDATE_POST_BY_ID_SQL);
			ps.setString(1, content);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new PostException("Post can't be edited right now, please try again later.", e);
		}
	}
	public void deletePost(int postId) throws PostException {
		conn = connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(DELETE_POST_BY_ID_SQL);
			ps.setInt(1, postId);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new PostException("Post can't be deleted right now, please try again later.", e);
		}

	}


}
