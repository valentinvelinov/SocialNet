package com.socialNet.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.socialNet.dao.MessageDAO;
import com.socialNet.exception.MessageException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Message;

@Controller
public class MessageController {

	MessageDAO messageDao = new MessageDAO();

	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public String sendMessage(@RequestBody Message message) throws MessageException {

		messageDao.sendMessage(message);
		return "message";
	}

	@RequestMapping(value = "/displayConversationBetweenUsers", method = RequestMethod.POST)
	public String getSentMessageByUser(@RequestBody Message message)
			throws ClassNotFoundException, UserException, MessageException {
		List<Message> messagesSent = messageDao.displayConversationBetweenUsers(message);
		return "messagesSent";
	}

	@RequestMapping(value = "/displayConversation", method = RequestMethod.POST)
	public String displayConversation(@RequestBody Message message)
			throws ClassNotFoundException, UserException, MessageException {
		List<Message> conversations = messageDao.displayConversation(message);
		return "conversations";
	}

}
