package com.socialNet.pojo;

import com.socialNet.exceptions.CommentException;

public class Comment {
	private int comment_id;
	private int post_id;
	private String text;
	private int user_id;

	public Comment(int post_id, String text, int user_id) throws CommentException {
		super();
		setPost_id(post_id);
		setText(text);
		setUser_id(user_id);
	}
	

	public Comment(int comment_id, int post_id, String text, int user_id) throws CommentException {
		super();
		setComment_id(comment_id);
		setPost_id(post_id);
		setText(text);
		setUser_id(user_id);
	}


	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) throws CommentException {
		if (comment_id > 0) {
			this.comment_id = comment_id;
		} else {
			throw new CommentException("Post cannot be commented right now, please try again later!");
		}
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) throws CommentException {
		if (post_id > 0) {
			this.post_id = post_id;
		} else {
			throw new CommentException("Invalid post_id!");
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

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) throws CommentException {
		if (user_id > 0) {
			this.user_id = user_id;
		} else {
			throw new CommentException("Invalid user_id!");
		}
	}

	private boolean isValidText(String text) {
		return text != null && !text.isEmpty();
	}

}
