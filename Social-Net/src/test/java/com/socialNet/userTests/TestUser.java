package com.socialNet.userTests;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.socialNet.dao.UserDAO;
import com.socialNet.exceptions.UserException;
import com.socialNet.pojo.User;
import com.socialNet.pojo.User.Gender;

public class TestUser {

	private UserDAO userDao = new UserDAO();
	private User testUser;

	@Test
	public void testRegisterUser() throws UserException, ParseException {
		String date = "2014-01-28";
		java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		testUser = new User("Pesho1", "Testa", "text@email.bg", sqlDate, Gender.MALE, "12345678");

		int id = userDao.registerUser(testUser);

		int id2 = userDao.loginUser(testUser);
		System.out.println("ID after login " + id2);

		assertEquals(id, id2);

		testUser.setUser_id(id2);
	}
}
