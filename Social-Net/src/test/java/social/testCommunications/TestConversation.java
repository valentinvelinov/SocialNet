package social.testCommunications;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.junit.Test;

import Social.communications.Conversation;
import Social.communications.ConversationDAO;
import Social.user.User;
import Social.user.UserDAO;
import Social.user.UserException;
import Social.user.User.Gender;

public class TestConversation {

	private ConversationDAO conversationDao = new ConversationDAO();
	private Conversation testConversation;

	@Test
	public void startConversation() throws UserException, ParseException {
		String date = "2014-01-28";
		java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		Date sqlDate = new java.sql.Date(utilDate.getTime());

		testConversation = new Conversation( "Some text", sqlDate);

		int id = conversationDao.startConversation(testConversation);

		System.out.println("ID after start a conversation " + id);

	}
}
