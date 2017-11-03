package com.socialNet.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.socialNet.dao.FriendDAO;
import com.socialNet.dao.UserDAO;
import com.socialNet.exception.FriendException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Friend;

@Controller
public class FriendController {

	FriendDAO friendDAO = new FriendDAO();
	UserDAO userDAO = new UserDAO();

	@RequestMapping(value = "/makeFriend", method = RequestMethod.POST)
	public String createFriendship(@RequestBody Friend friend) throws FriendException {
		if (!friendDAO.verifiesIfTheresAlreadyThisFriend(friend)) {
			friendDAO.addFriend(friend);
			return "friendship";
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/getFriends", method = RequestMethod.POST)
	public String getFriends(@RequestBody Friend friend) throws UserException {
		List<Friend> friends = friendDAO.getFriends(friend);
		return "friends";
	}

	@RequestMapping(value = "/removeFriend", method = RequestMethod.POST)
	public String removeFriend(@RequestBody Friend friend) {
		friendDAO.removeFriend(friend);
		return "friend";
	}

}
