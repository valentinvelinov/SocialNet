package com.socialNet.testCommunications;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.junit.Test;

import com.socialNet.dao.ConversationDAO;
import com.socialNet.dao.UserDAO;
import com.socialNet.exceptions.ConversationException;
import com.socialNet.exceptions.FriendException;
import com.socialNet.exceptions.UserException;
import com.socialNet.pojo.Conversation;
import com.socialNet.pojo.User;
import com.socialNet.pojo.User.Gender;

public class TestConversation {

	private ConversationDAO conversationDao = new ConversationDAO();
	private Conversation testConversation;

	@Test
	public void startConversation() throws UserException, ParseException, FriendException {
		String date = "2014-01-28";
		java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		Date sqlDate = new java.sql.Date(utilDate.getTime());

		testConversation = new Conversation("Some text", sqlDate);

		int id = 0;
		try {
			id = conversationDao.startConversation(testConversation);
		} catch (ConversationException e) {
			e.printStackTrace();
		}

		System.out.println("ID after start a conversation " + id);

	}
}
