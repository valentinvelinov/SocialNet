package com.socialNet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.socialNet.dao.UserDAO;
import com.socialNet.exception.UserException;
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
	

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public void searchUsers(HttpServletRequest request, HttpServletResponse response)
			throws IOException, UserException {
		String query = request.getParameter("query");
		if (query == null) {
			response.setContentType("text/json");
			ArrayList<User> users = userDAO.getAllUsers();
			Gson gson = new GsonBuilder().create();
			response.getWriter().println(gson.toJson(users));
		} else {
			response.setContentType("text/json");
			ArrayList<User> users = userDAO.getAllUsers();
			users.removeIf((a) -> !a.getFirstName().startsWith(query));
			Gson gson = new GsonBuilder().create();
			response.getWriter().println(gson.toJson(users));
		}

	}
}
