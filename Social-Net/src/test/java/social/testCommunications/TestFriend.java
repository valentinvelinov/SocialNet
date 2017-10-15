package social.testCommunications;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.junit.Test;

import Social.communications.Friend;
import Social.communications.FriendDAO;
import Social.communications.FriendException;

public class TestFriend {

	private FriendDAO friendDao = new FriendDAO();
	private Friend testFriend;

	@Test
	public void startConversation() throws FriendException, ParseException {
		String date = "2014-01-28";
		java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		Date sqlDate = new java.sql.Date(utilDate.getTime());

		testFriend = new Friend();

		int id = 0;
		try {
			id = friendDao.addFriend(testFriend);
		} catch (FriendException e) {
			e.printStackTrace();
		}

		System.out.println("ID after start a conversation " + id);

	}

}
