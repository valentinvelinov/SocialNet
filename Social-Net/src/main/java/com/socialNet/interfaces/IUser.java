package com.socialNet.interfaces;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.socialNet.exception.UserException;
import com.socialNet.model.User;

@Component
public interface IUser {
	
	public void changeLastName(int userId,String lastName) throws UserException;

	public void changeFirstName(int userId,String firstName) throws UserException;

	public int registerUser(User user) throws UserException;

	public void loginUser(User user) throws UserException;

	public User getUserById(int id) throws UserException;

	public Collection<User> getFriends(User user) throws UserException;

}
