package Social.communications;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Social.user.DBConnection;
import Social.user.User;
import Social.user.UserException;

public class MessageDAO {

	private static final String INSERT_MESSAGE_SQL = "INSERT INTO messages VALUES (null, ?, ?, ?)";

	public int sendMessage(Message message) throws UserException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_MESSAGE_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, message.getConversation_id());
			ps.setString(2, message.getContent());
			ps.setDate(3, message.getDate());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			message.setMessage_id(rs.getInt(1));
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new UserException("You cannot send a message now, please try again later.", e);
		}
	}

}
