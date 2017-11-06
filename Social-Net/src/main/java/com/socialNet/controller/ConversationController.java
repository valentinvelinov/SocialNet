package com.socialNet.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.socialNet.dao.ConversationDAO;
import com.socialNet.dao.MessageDAO;
import com.socialNet.dao.UserDAO;
import com.socialNet.exception.CommentException;
import com.socialNet.exception.ConversationException;
import com.socialNet.exception.MessageException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Comment;
import com.socialNet.model.Conversation;
import com.socialNet.model.Message;
import com.socialNet.model.User;

@Controller
public class ConversationController {

	@Autowired
	ConversationDAO conversationDAO;

	@Autowired
	MessageDAO messeageDAO;

	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/showAllMyConversations", method = RequestMethod.GET)
	public String showConversations(HttpServletRequest request, HttpSession session, Model viewModel) {
		User user = (User) session.getAttribute("user");
		ArrayList<Conversation> myconverastions = null;
		try {
			myconverastions = conversationDAO.getUserConversations(user.getUserId());
		} catch (ConversationException e) {
			e.printStackTrace();
			return "error";
		}
		Collection<User> friends = null;
		try {
			friends = userDAO.getFriends(user);
		} catch (UserException e) {
			e.printStackTrace();
			return "error";
		}
		if (myconverastions == null || friends == null) {
			return "error";
		} else {
			viewModel.addAttribute("list", myconverastions);
			viewModel.addAttribute("friends", friends);
			return "showAllMyConversations";
		}
	}

	@RequestMapping(value = "/openConversation", method = RequestMethod.GET)
	public String openConversation(@ModelAttribute Message message, HttpServletRequest request, Model viewModel,
			HttpSession session) {
		int conversationId = Integer.parseInt(request.getParameter("conversationId"));
		ArrayList<Message> messages = null;
		try {
			messages = messeageDAO.getMessages(conversationId);
		} catch (MessageException e) {
			e.printStackTrace();
			return "error";
		}
		if (messages == null) {
			return "error";
		} else {
			viewModel.addAttribute("listMSG", messages);
			return "openConversation";
		}
	}

	@RequestMapping(value = "/newMessage", method = RequestMethod.GET)
	public synchronized String sendMessage(@ModelAttribute Message message, HttpServletRequest request,
			HttpSession session, Model viewModel) {
		User user = (User) session.getAttribute("user");
		message.setUserId(user.getUserId());
		try {
			messeageDAO.postMessage(message);
		} catch (MessageException e) {
			e.printStackTrace();
			return "error";
		}
		return "forward:openConversation";
	}

	@RequestMapping(value = "/createConversation", method = RequestMethod.GET)
	public synchronized String createConversation(@ModelAttribute Message message, HttpServletRequest request,
			HttpSession session, Model viewModel) {
		User user = (User) session.getAttribute("user");
		int friendId = Integer.parseInt(request.getParameter("friendId"));
		int conversationId;
		try {
			conversationId = conversationDAO.createConversation(friendId);
		} catch (UserException | ConversationException e) {
			e.printStackTrace();
			return "error";
		}
		try {
			conversationDAO.setConversationToUsers(user.getUserId(), conversationId);
		} catch (ConversationException e) {
			e.printStackTrace();
			return "error";
		}
		try {
			conversationDAO.setConversationToUsers(friendId, conversationId);
		} catch (ConversationException e) {
			e.printStackTrace();
			return "error";
		}
		return "forward:showAllMyConversations";
	}

}
