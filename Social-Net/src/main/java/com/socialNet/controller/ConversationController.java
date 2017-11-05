package com.socialNet.controller;

import java.util.ArrayList;

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
import com.socialNet.exception.ConversationException;
import com.socialNet.model.Comment;
import com.socialNet.model.Conversation;
import com.socialNet.model.User;

@Controller
public class ConversationController {

	@Autowired
	ConversationDAO conversationDAO;

	@Autowired
	MessageDAO messeageDAO;

	@RequestMapping(value = "/showAllMyConversations", method = RequestMethod.GET)
	public String showConversations(HttpSession session, Model viewModel) throws ConversationException {
		User user = (User) session.getAttribute("user");
		ArrayList<Conversation> myconverastions = conversationDAO.getUserConversations(user.getUserId());
		viewModel.addAttribute("list", myconverastions);
		return "showAllMyConversations";
	}
}