package com.socialNet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.socialNet.dbmanager.DBConnection;
import com.socialNet.exceptions.LikeException;
import com.socialNet.exceptions.PostException;
import com.socialNet.exceptions.UserException;
import com.socialNet.pojo.Like;
import com.socialNet.pojo.Post;
import com.socialNet.pojo.User;

public class LikeDAO {
	private static final String INSERT_LIKE_SQL = "INSERT INTO likes VALUES (null,?,?)";
	private static final String SELECT_LIKE_BY_ID = "SELECT * FROM likes WHERE like_id=?";
	
	public int likePost (Like like) throws LikeException {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(INSERT_LIKE_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, like.getPost_id());
			ps.setInt(2, like.getUser_id());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new LikeException("Post cannot be liked right now, please try again later.", e);
		}
	}
	}

