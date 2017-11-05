package com.socialNet.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.socialNet.dao.UserDAO;


import com.socialNet.model.User;

@Controller
public class FriendController {

	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	public String showFriends(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		Collection<User> friends = user.getUserFriends();
		model.addAttribute(friends);
		return "showMyFriends";
	}

}
