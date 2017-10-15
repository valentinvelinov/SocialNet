package Social.post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Social.user.DBConnection;
import Social.user.User;

public class LikeDAO {
	private static final String INSERT_LIKE_SQL = "INSERT INTO likes VALUES (?,?)";
	
	public int likePost (User user,Post post) throws LikeException {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(INSERT_LIKE_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, post.getPost_id());
			ps.setInt(2, user.getUser_id());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new LikeException("Post cannot be liked right now, please try again later.", e);
		}
	}
	}

