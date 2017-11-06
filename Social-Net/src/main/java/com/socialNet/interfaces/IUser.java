package com.socialNet.interfaces;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.socialNet.exception.UserException;
import com.socialNet.model.User;
@Component
public interface IUser {

	public int registerUser(User user) throws UserException;

	public void loginUser(User user) throws UserException;

	public User getUserById(int id) throws UserException;

	public Collection<User> getFriends(User user) throws UserException;

}
