package com.socialNet.test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.socialNet.dao.FriendDAO;
import com.socialNet.exception.FriendException;
import com.socialNet.model.Friend;

public class TestFriend {

	private FriendDAO friendDao = new FriendDAO();
	private Friend testFriend;

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
