package com.socialNet.model;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotBlank;

import com.socialNet.exception.MessageException;

public class Message {
	private int messageId;
	private int conversationId;
	@NotBlank
	private String content;
	@NotBlank
	private Date date;
	private User userOne;
	private User userTwo;
	private User sent;

	public Message(int conversationId, String content, Date date) {
		this.conversationId = conversationId;
		this.content = content;
		this.date = date;
	}

	public Message(int messageId, int conversationId, String content, Date date) {
		this(conversationId, content, date);
		this.messageId = messageId;
	}

	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date timestamp) {
		this.date = timestamp;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) throws MessageException {
		if (messageId > 0) {
			this.messageId = messageId;
		} else {
			throw new MessageException("The message cannot be write right now, please try again later!");
		}
	}

	public int getConversationId() {
		return conversationId;
	}

	public void setConversationId(int conversationId) throws MessageException {
		if (conversationId > 0) {
			this.conversationId = conversationId;
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

	public User getUserOne() {
		return userOne;
	}

	public void setUserOne(User userOne) {
		this.userOne = userOne;
	}

	public User getUserTwo() {
		return userTwo;
	}

	public void setUserTwo(User userTwo) {
		this.userTwo = userTwo;
	}

	public User getSent() {
		return sent;
	}

	public void setSent(User sent) {
		this.sent = sent;
	}

	private boolean isValidText(String text) {
		return text != null && !text.isEmpty();
	}
}
