package com.socialnet.model;

import java.sql.Date;

import com.socialnet.exception.MessageException;

public class Message {
	private int message_id;
	private int conversation_id;
	private String content;
	private Date date;

	public Message(int conversation_id, String content, Date date) {
		this.conversation_id = conversation_id;
		this.content = content;
		this.date = date;
	}

	public Message(int message_id, int conversation_id, String content, Date date) {
		this(conversation_id, content, date);
		this.message_id = message_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) throws MessageException {
		if (message_id > 0) {
			this.message_id = message_id;
		} else {
			throw new MessageException("The message cannot be write right now, please try again later!");
		}
	}

	public int getConversation_id() {
		return conversation_id;
	}

	public void setConversation_id(int conversation_id) throws MessageException {
		if (conversation_id > 0) {
			this.conversation_id = conversation_id;
		} else {
			throw new MessageException("The message cannot be write right now, please try again later!");
		}
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) throws MessageException {
		if (isValidText(content)) {
			this.content = content;
		} else {
			throw new MessageException("Invalid message text!");
		}
	}

	private boolean isValidText(String text) {
		return text != null && !text.isEmpty();
	}
}
