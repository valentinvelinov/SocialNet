package com.socialNet.test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.socialNet.dao.ConversationDAO;
import com.socialNet.exception.ConversationException;
import com.socialNet.exception.FriendException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Conversation;

public class TestConversation {

	private ConversationDAO conversationDao = new ConversationDAO();
	private Conversation testConversation;

	public void startConversation() throws UserException, ParseException, FriendException {
		String date = "2014-01-28";
		java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		Date sqlDate = new java.sql.Date(utilDate.getTime());

		testConversation = new Conversation("Some text");

		int id = 0;
		try {
			id = conversationDao.startConversation(testConversation);
		} catch (ConversationException e) {
			e.printStackTrace();
		}

		System.out.println("ID after start a conversation " + id);

	}
}
