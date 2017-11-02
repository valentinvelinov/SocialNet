package com.socialNet.interfaces;

import java.util.List;

import com.socialNet.exception.UserException;
import com.socialNet.model.User;

public interface IUser {
	public int registerUser(User user) throws UserException;

	public void loginUser(User user) throws UserException;

	public User getUserById(int id) throws UserException;

	public List<User> friendsSortedByPlace(String first_name, boolean order);

	public List<User> friendsSortedByDateOfBirth(java.util.Date birth_date, boolean order);

	public List<User> friendsSortedByName(String first_name, boolean order);

	public List<User> nonFriendsFor(Integer personId);

}
