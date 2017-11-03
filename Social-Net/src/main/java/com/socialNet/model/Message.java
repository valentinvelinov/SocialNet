package com.socialNet.model;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.socialNet.exception.MessageException;

public class Message {
	@NotBlank
	private int messageId;
	@NotBlank
	private int conversationId;
	@NotBlank
	@Length(min = 1, max = 2000)
	private String content;
	@NotBlank
	private Date date;
	@NotBlank
	private int userId;

	public Message(int messageId, int conversationId, String content, Date date, int userId) {
		this(conversationId, content, date, userId);
		setMessageId(messageId);
	}

	public Message(int conversationId, String content, Date date, int userId) {
		setConversationId(conversationId);
		setContent(content);
		setDate(date);
		setUserId(userId);
	}

	public Message() {

	}

	// Getters and Setters
	public int getMessageId() {
		return messageId;
	}

	public int getConversationId() {
		return conversationId;
	}

	public String getContent() {
		return content;
	}

	public Date getDate() {
		return date;
	}

	public int getUserId() {
		return userId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public void setConversationId(int conversationId) {
		this.conversationId = conversationId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
