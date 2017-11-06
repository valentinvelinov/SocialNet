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
	public String showConversations(HttpServletRequest request, HttpSession session, Model viewModel)
			throws ConversationException, UserException {
		User user = (User) session.getAttribute("user");
		ArrayList<Conversation> myconverastions = conversationDAO.getUserConversations(user.getUserId());
		Collection<User> friends = userDAO.getFriends(user);
		viewModel.addAttribute("list", myconverastions);
		viewModel.addAttribute("friends", friends);
		return "showAllMyConversations";
	}

	@RequestMapping(value = "/openConversation", method = RequestMethod.GET)
	public String openConversation(@ModelAttribute Message message, HttpServletRequest request, Model viewModel,
			HttpSession session) throws CommentException, UserException, MessageException {
		int conversationId = Integer.parseInt(request.getParameter("conversationId"));
		ArrayList<Message> messages = messeageDAO.getMessages(conversationId);
		viewModel.addAttribute("listMSG", messages);
		return "openConversation";
	}

	@RequestMapping(value = "/newMessage", method = RequestMethod.GET)
	public synchronized String sendMessage(@ModelAttribute Message message, HttpServletRequest request,
			HttpSession session, Model viewModel) throws CommentException, MessageException {
		User user = (User) session.getAttribute("user");
		message.setUserId(user.getUserId());
		messeageDAO.postMessage(message);
		return "forward:openConversation";
	}

	@RequestMapping(value = "/createConversation", method = RequestMethod.GET)
	public synchronized String createConversation(@ModelAttribute Message message, HttpServletRequest request,
			HttpSession session, Model viewModel)
			throws CommentException, MessageException, UserException, ConversationException {
		User user = (User) session.getAttribute("user");
		int friendId = Integer.parseInt(request.getParameter("friendId"));
		System.err.println("FRIEND_ID" + friendId);
		int conversationId = conversationDAO.createConversation(friendId);
		conversationDAO.setConversationToUsers(user.getUserId(), conversationId);
		conversationDAO.setConversationToUsers(friendId, conversationId);
		return "forward:showAllMyConversations";
	}

}
