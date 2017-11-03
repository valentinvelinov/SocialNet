package com.socialNet.test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.socialNet.dao.MessageDAO;
import com.socialNet.exception.MessageException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Message;

public class TestMessage {
	private MessageDAO messageDao = new MessageDAO();
	private Message testMessage;

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
