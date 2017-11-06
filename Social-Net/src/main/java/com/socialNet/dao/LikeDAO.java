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
	private static final String VERIFY_LIKE = "SELECT * FROM likes WHERE post_id=? and user_id =?";
	private static final String DELETE_LIKE_SQL = "DELETE FROM likes WHERE post_id=? and user_id=?";
	private static final String SELECT_LIKE_BY_POST = "SELECT * FROM likes WHERE post_id=?";

	@Override
	public void like(Like like) throws LikeException {
		conn = connection.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM likes WHERE post_id=? and user_id= ? ");
			ps.setInt(1, like.getPostId());
			ps.setInt(2, like.getUserId());
			ResultSet result = ps.executeQuery();
			// result.next();
			int id;
			if (!result.next())
				id = 0;
			else
				id = result.getInt(1);
			if (id == 0) {
				PreparedStatement psInsert = conn.prepareStatement(INSERT_LIKE_SQL, Statement.RETURN_GENERATED_KEYS);
				psInsert.setInt(1, like.getPostId());
				psInsert.setInt(2, like.getUserId());
				psInsert.executeUpdate();
				ResultSet rs = psInsert.getGeneratedKeys();
				rs.next();
			} else {
				PreparedStatement psDelete = conn.prepareStatement(DELETE_LIKE_SQL, Statement.RETURN_GENERATED_KEYS);

				psDelete.setInt(1, like.getPostId());
				psDelete.setInt(2, like.getUserId());
				psDelete.executeUpdate();
				ResultSet rs1 = psDelete.getGeneratedKeys();
				rs1.next();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new LikeException("Like cannot be selected");
		}
	}

	@Override
	public List<Like> showLikesByPost(int myPost) throws LikeException {
		conn = connection.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_LIKE_BY_POST, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, myPost);
			ResultSet rs = ps.executeQuery();
			listOfLikes.clear();

			while (rs.next()) {
				int idLike = rs.getInt("like_id");
				int idUser = rs.getInt("user_id");

				Like like = new Like(idLike, myPost, idUser);
				listOfLikes.add(like);
			}
			for (Like l : listOfLikes) {
				System.out.println("collection" + l);
			}
			return listOfLikes;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new LikeException("Like cannot be selected");
		}

	}
}
