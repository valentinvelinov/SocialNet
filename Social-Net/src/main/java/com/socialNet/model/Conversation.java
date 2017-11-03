package com.socialNet.model;

import org.hibernate.validator.constraints.NotBlank;

import com.socialNet.exception.ConversationException;

public class Conversation {

	private int conversationId;
	@NotBlank
	private String contentConversation;

	public Conversation(String contentConversation) {
		this.contentConversation = contentConversation;
	}

	public Conversation(int conversationId, String contentConversation) {
		this.conversationId = conversationId;
		this.contentConversation = contentConversation;

	}

	public Conversation() {
		// TODO Auto-generated constructor stub
	}

	public int getConversationId() {
		return conversationId;
	}

	public void setConversationId(int conversationId) throws ConversationException {
		if (conversationId > 0) {
			this.conversationId = conversationId;
		} else {
			throw new ConversationException("Conversation cannot be commented right now, please try again later!");
		}
	}

	public String getContentConversation() {
		return contentConversation;
	}

	public void setContentConversation(String contentConversation) throws ConversationException {
		if (isValidText(contentConversation)) {
			this.contentConversation = contentConversation;
		} else {
			throw new ConversationException("Invalid comment text!");
		}
	}

	private boolean isValidText(String text) {
		return text != null && !text.isEmpty();
	}

}
