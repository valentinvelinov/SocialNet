package com.socialNet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.socialNet.dbmanager.DBConnection;
import com.socialNet.exceptions.PostException;
import com.socialNet.pojo.Post;
import com.socialNet.pojo.User;

public class PostDAO {
	private static final String INSERT_POST_SQL = "INSERT INTO posts VALUES (null,?,?)";

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
}
