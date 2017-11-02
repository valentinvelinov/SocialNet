package com.socialNet.interfaces;

import java.util.List;

import com.socialNet.exception.MessageException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Message;

public interface IMessage {
	public int sendMessage(Message message) throws MessageException;

	public List<Message> displayConversationBetweenUsers(Message message)
			throws ClassNotFoundException, UserException, MessageException;

	public List<Message> displayConversation(Message message)
			throws ClassNotFoundException, UserException, MessageException;
}
