package Social.communications;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Social.user.DBConnection;
import Social.user.User;
import Social.user.UserException;

public class ConversationsDAO {

	private static final String INSERT_USER_SQL = "INSERT INTO users VALUES (null, ?)";
	private static final String SELECT_USER_SQL = "SELECT user_id FROM users WHERE email = ? AND password = md5(?)";

	public int startConversation(User user) throws UserException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, user.getUser_id());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			user.setUser_id(rs.getInt(1));
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new UserException("User cannot start a conversationS now, please try again later.", e);
		}
	}

}
