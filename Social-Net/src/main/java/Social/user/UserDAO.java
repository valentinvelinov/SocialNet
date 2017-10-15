package Social.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// data access object
public class UserDAO {

	private static final String INSERT_USER_SQL = "INSERT INTO users VALUES (null, ?, ?, ?, ?, ?, md5(?))";
	private static final String SELECT_USER_SQL = "SELECT user_id FROM users WHERE email = ? AND password = md5(?)";

	public int registerUser(User user) throws UserException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getFirst_name());
			ps.setString(2, user.getLast_name());
			ps.setString(3, user.getEmail());
			ps.setDate(4, (Date) user.getBirth_date());
			ps.setString(5, user.getGender().toString());
			ps.setString(6, user.getPassword());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			user.setUser_id(rs.getInt(1));
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new UserException("User cannot be registered now, please try again later.", e);
		}
	}

	public int loginUser(User user) throws UserException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_USER_SQL);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());

			ResultSet rs = ps.executeQuery();
			if (rs.next() == false) {
				throw new UserException("Wrong password or email! Please, try again!.");
			}
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new UserException("User cannot be logged right now.", e);
		}
	}

}
