package com.socialNet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.socialNet.dbmanager.DBConnection;
import com.socialNet.exceptions.PictureException;
import com.socialNet.pojo.Picture;

public class PictureDAO {
	private static final String INSERT_COMMENT_SQL = "INSERT INTO pictures VALUES (null,?,?)";

	public int postPicture(Picture picture) throws PictureException {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(INSERT_COMMENT_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, picture.getName());
			ps.setInt(2, picture.getUser_id());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new PictureException("Picture cannot be commented right now, please try again later.", e);
		}
	}
}
