package com.socialNet.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.socialNet.exception.CommentException;

public class Comment {
	@NotBlank
	private int commentId;
	@NotBlank
	private int postId;
	@NotBlank
	private String text;
	@NotBlank
	private int userId;
	@NotBlank
	private Date dateComment;

	public Comment(int commentId, int postId, String text, int userId, Date dateComment) {
		this(postId, text, userId, dateComment);
		setCommentId(commentId);
	}

	public Comment(int postId, String text, int userId, Date dateComment) {
		setPostId(postId);
		setText(text);
		setUserId(userId);
		setDateComment(dateComment);
	}

	public Comment() {

	}

	// Getters and Setters
	public int getCommentId() {
		return commentId;
	}

	public int getPostId() {
		return postId;
	}

	public String getText() {
		return text;
	}

	public int getUserId() {
		return userId;
	}

	public Date getDateComment() {
		return dateComment;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setDateComment(Date dateComment) {
		this.dateComment = dateComment;
	}

}
