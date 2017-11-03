package com.socialNet.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.socialNet.exception.ConversationException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Conversation;
import com.socialNet.model.User;

public interface IConversation {

	public int startConversation(Conversation conversation, User user) throws ConversationException;

	public void deleteConversation(Integer conversationId) throws UserException, ConversationException;

	public ArrayList<Conversation> viewAllConversations(User user)
			throws ConversationException, UserException, SQLException;

}