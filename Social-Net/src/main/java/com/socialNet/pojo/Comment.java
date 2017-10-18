package com.socialNet.pojo;

public class Comment {
	private int post_id;
	private String text;
	private int user_id;

	public Comment(String text, int user_id) {
		super();
		setText(text);
		setUser_id(user_id);
	}

	public Comment(int post_id, String text, int user_id) {
		super();
		setPost_id(post_id);
		setText(text);
		setUser_id(user_id);
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		if (post_id > 0) {
			this.post_id = post_id;
		}
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		if (isValidText(text)) {
			this.text = text;
		}
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		if (user_id > 0) {
			this.user_id = user_id;
		}
	}

	private boolean isValidText(String text) {
		return text != null && !text.isEmpty();
	}

}
