package com.socialNet.model;

import java.sql.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.socialNet.exception.MessageException;

public class Message {
	private int messageId;
	private int conversationId;
	@NotBlank
	private String content;
	@NotBlank
	private Date date;

	public Message(int conversationId, String content, Date date) {
		this.conversationId = conversationId;
		this.content = content;
		this.date = date;
	}

	public Message(int messageId, int conversationId, String content, Date date) {
		this(conversationId, content, date);
		this.messageId = messageId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	private boolean isValidText(String text) {
		return text != null && !text.isEmpty();
	}
}
