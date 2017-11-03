package com.socialNet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class Conversation {
	@NotBlank
	private int conversationId;
	@NotBlank
	private String title;
	@NotBlank
	private List<User> usersInConversation = Collections.synchronizedList(new ArrayList<User>());
	private List<Message> massages = Collections.synchronizedList(new ArrayList<Message>());

	public Conversation(int conversationId, String title, List<User> usersInConversation, List<Message> massages) {
		this(title, usersInConversation, massages);
		setConversationId(conversationId);
	}

	public Conversation(String title, List<User> usersInConversation, List<Message> massages) {
		super();
		setTitle(title);
		setUsersInConversation(usersInConversation);
		setMassages(massages);
	}

	// Getters and Setters

	public int getConversationId() {
		return conversationId;
	}

	public String getTitle() {
		return title;
	}

	public List<User> getUsersInConversation() {
		return usersInConversation;
	}

	public List<Message> getMassages() {
		return massages;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUsersInConversation(List<User> usersInConversation) {
		this.usersInConversation = usersInConversation;
	}

	public void setMassages(List<Message> massages) {
		this.massages = massages;
	}

	public void setConversationId(int conversationId) {
		this.conversationId = conversationId;
	}

}
