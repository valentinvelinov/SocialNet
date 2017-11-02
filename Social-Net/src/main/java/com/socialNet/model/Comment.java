package com.socialNet.model;

import java.util.Date;

import com.socialNet.exception.CommentException;

public class Comment {
	private int commentId;
	private int postId;
	private String text;
	private int userId;
	private Date dateComment;

	public Comment(int postId, String text, int userId, Date dateComment) throws CommentException {
		setPostId(postId);
		setText(text);
		setUserId(userId);
		setDateComment(dateComment);
	}

	public Comment(int commentId, int postId, String text, int userId, Date dateComment) throws CommentException {
		this(postId, text, userId, dateComment);
		setCommentId(commentId);

	}

	public Date getDateComment() {
		return dateComment;
	}

	public void setDateComment(Date dateComment) {
		this.dateComment = dateComment;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) throws CommentException {
		if (commentId > 0) {
			this.commentId = commentId;
		} else {
			throw new CommentException("Post cannot be commented right now, please try again later!");
		}
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) throws CommentException {
		if (postId > 0) {
			this.postId = postId;
		} else {
			throw new CommentException("Invalid post id!");
		}
	}

	public String getText() {
		return text;
	}

	public void setText(String text) throws CommentException {
		if (isValidText(text)) {
			this.text = text;
		} else {
			throw new CommentException("Invalid comment text!");
		}
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) throws CommentException {
		if (userId > 0) {
			this.userId = userId;
		} else {
			throw new CommentException("Invalid user id!");
		}
	}

	private boolean isValidText(String text) {
		return text != null && !text.isEmpty();
	}

}
