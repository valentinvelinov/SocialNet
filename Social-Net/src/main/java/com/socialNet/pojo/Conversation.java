package com.socialNet.pojo;

import java.util.Date;

import com.socialNet.exceptions.ConversationException;

public class Conversation {

	private int conversation_id;
	private String text;
	private Date date;

	public Conversation(String text, Date date) {
		this.text = text;
		this.date = date;
	}

	public Conversation(int conversation_id, String text, Date date) {
		this(text, date);
		this.conversation_id = conversation_id;

	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getConversation_id() {
		return conversation_id;
	}

	public void setConversation_id(int conversation_id) throws ConversationException {
		if (conversation_id > 0) {
			this.conversation_id = conversation_id;
		} else {
			throw new ConversationException("Conversation cannot be commented right now, please try again later!");
		}
	}

	public String getText() {
		return text;
	}

	public void setText(String text) throws ConversationException {
		if (isValidText(text)) {
			this.text = text;
		} else {
			throw new ConversationException("Invalid comment text!");
		}
	}

	private boolean isValidText(String text) {
		return text != null && !text.isEmpty();
	}

}
