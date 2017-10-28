package com.socialnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.socialnet.dbmanager.DBConnection;
import com.socialnet.exception.LikeException;
import com.socialnet.model.Like;
@Component
public class LikeDAO {
	private static final String INSERT_LIKE_SQL = "INSERT INTO likes VALUES (null,?,?)";
	private static final String SELECT_LIKE_BY_ID = "SELECT * FROM likes WHERE like_id=?";
	
	public int likePost (Like like) throws LikeException {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(INSERT_LIKE_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, like.getPost_id());
			ps.setInt(2,like.getUser_id());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new LikeException("Post cannot be liked right now, please try again later.", e);
		}
	}
	}

