package social.testCommunications;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import Social.communications.Conversation;
import Social.communications.ConversationDAO;
import Social.communications.ConversationException;
import Social.communications.Message;
import Social.communications.MessageDAO;
import Social.communications.MessageException;
import Social.user.UserException;

public class TestMessage {
	private MessageDAO messageDao = new MessageDAO();
	private Message testMessage;

	@Test
	public void startConversation() throws UserException, ParseException, MessageException {
		String date = "2014-01-28";
		java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		Date sqlDate = new java.sql.Date(utilDate.getTime());

		testMessage = new Message(1, "Some content", sqlDate);

		int id = 0;
		try {
			id = messageDao.sendMessage(testMessage);
		} catch (MessageException e) {
			e.printStackTrace();
		}

		System.out.println("ID after start a conversation " + id);

	}
}
