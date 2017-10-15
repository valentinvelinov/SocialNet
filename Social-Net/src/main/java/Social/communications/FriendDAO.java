package Social.communications;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Social.user.DBConnection;
import Social.user.UserException;

public class FriendDAO {

	private static final String INSERT_FRIEND_SQL = "INSERT INTO friends VALUES (null, ?)";

	public int startConversation(Friend friend) throws UserException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_FRIEND_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, friend.getFriend_id());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			friend.setFriend_id(rs.getInt(1));
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new UserException("You cannot add this person as friend now, please try again later.", e);
		}
	}

}
