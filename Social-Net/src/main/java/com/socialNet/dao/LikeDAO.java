package com.socialNet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.socialNet.dbmanager.DBConnection;
import com.socialNet.exception.LikeException;
import com.socialNet.interfaces.ILike;
import com.socialNet.model.Like;
import com.socialNet.model.Post;
import com.socialNet.model.User;

@Component
public class LikeDAO implements ILike {
	@Autowired
	DBConnection connection;
	ArrayList<Like> listOfLikes = new ArrayList<Like>();

	private static Connection conn;
	private static final String INSERT_LIKE_SQL = "INSERT INTO likes VALUES (null,?,?)";
	// private static final String SELECT_LIKE_BY_ID = "SELECT * FROM likes WHERE
	// like_id=?";
	private static final String VERIFY_LIKE = "SELECT * FROM likes WHERE post_id=? and user_id = ?";
	private static final String DELETE_LIKE_SQL = "DELETE * FROM likes WHERE user_id=?";
	private static final String SELECT_LIKE_BY_POST = "SELECT * FROM likes WHERE post_id=?";

	public int likePost(Like like) throws LikeException {
		conn = connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(INSERT_LIKE_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, like.getPostId());
			ps.setInt(2, like.getUserId());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new LikeException("Post cannot be liked right now, please try again later.", e);
		}
	}

	@Override
	public boolean dislikePost(Like like) {
		conn = connection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(DELETE_LIKE_SQL, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, like.getPostId());
			ps.setInt(2, like.getUserId());

			ps.execute();
			conn.close();
			return true;
		} catch (SQLException sql) {
			sql.getErrorCode();
		}
		return false;
	}

	@Override
	public boolean verifiesIfItIsLiked(Like like) {
		conn = connection.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(VERIFY_LIKE, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, like.getUserId());
			ps.setInt(2, like.getUserId());

			ResultSet rs = ps.executeQuery();
			boolean check = false;

			while (rs.next()) {
				check = true;
				System.out.println("YOU CAN'T LIKE TWICE THE SAME POST");
			}
			rs.close();
			ps.close();
			conn.close();
			return check;

		} catch (SQLException sql) {
			sql.getErrorCode();
			return false;
		}
	}

	@Override
	public List<Like> showLikesByPost(int myPost) throws SQLException {
		conn = connection.getConnection();
		PreparedStatement ps = conn.prepareStatement(SELECT_LIKE_BY_POST, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, myPost);
		ResultSet rs = ps.executeQuery();
		listOfLikes.clear();

		while (rs.next()) {
			int idLike = rs.getInt("like_id");
			// int idPost = rs.getInt("post_id");
			int idUser = rs.getInt("user_id");

			Like like = new Like(idLike, myPost, idUser);
			listOfLikes.add(like);
		}
		for (Like l : listOfLikes) {
			System.out.println("collection" + l);
		}
		return listOfLikes;
	}

}
