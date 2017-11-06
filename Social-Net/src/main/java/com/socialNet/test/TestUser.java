package com.socialNet.test;

import java.text.SimpleDateFormat;

import com.socialNet.dao.UserDAO;
import com.socialNet.exception.UserException;
import com.socialNet.model.User;
import com.sun.el.parser.ParseException;

public class TestUser {

	private UserDAO userDao = new UserDAO();
	private User testUser;

	public void testRegisterUser() throws UserException, ParseException, java.text.ParseException {
		String date = "2014-01-28";
		java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		testUser = new User("Pesho1", "Testa");

		int id = userDao.registerUser(testUser);

	}
}
