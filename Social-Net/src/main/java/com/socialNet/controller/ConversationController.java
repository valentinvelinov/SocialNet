package com.socialNet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.socialNet.dao.ConversationDAO;
import com.socialNet.exception.ConversationException;
import com.socialNet.exception.PostException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Conversation;
import com.socialNet.model.Post;
import com.socialNet.model.User;

@Controller
public class ConversationController {

	@Autowired
	ConversationDAO conversationDAO;

	// @RequestMapping(value = "conversation/conversation/{id}", method =
	// RequestMethod.GET)
	// public String showConversationByID(Model viewModel) throws UserException,
	// ConversationException {
	// int id = 7;
	// Conversation conversation = onversationDAO.getCoversationById(id);
	// viewModel.addAttribute(conversation);
	// return "conversation";
	// }

	@RequestMapping(value = "/showAllConversations", method = RequestMethod.GET)
	public String viewAllConversations(HttpSession session, Model viewModel)
			throws UserException, ConversationException, SQLException, ClassNotFoundException {
		if ((User) session.getAttribute("user") == null) {
			return "error";
		}
		ArrayList<Conversation> listOfConversations = conversationDAO
				.viewAllConversations((User) session.getAttribute("user"));
		viewModel.addAttribute(listOfConversations);
		System.out.println(listOfConversations);

		return "showAllConversations";
	}

	@RequestMapping(value = "/newConversation", method = RequestMethod.GET)
	public String newPost(HttpSession session, Model model) throws ConversationException {
		if ((User) session.getAttribute("user") == null) {
			return "error";
		}

		Conversation conversation = new Conversation();
		model.addAttribute("conversation", conversation);
		return "newConversation";
	}

	@RequestMapping(value = "/newConversation", method = RequestMethod.POST)
	public String newPost2(@ModelAttribute HttpSession session, Conversation conversation)
			throws ConversationException {
		System.out.println(conversation);
		// validate
		conversationDAO.startConversation(conversation, (User) session.getAttribute("user"));
		return "showAllConversations";
	}

	@RequestMapping("conversation/delete/{id}")
	public String delete(@PathVariable Integer id) throws UserException, ConversationException {
		conversationDAO.deleteConversation(id);
		return "redirect:/deleteConversation";
	}
}