package com.socialNet.pojo;

public class Comment {
	private int post_id;
	private String text;
	private int user_id;
	
	
	public Comment(String text, int user_id) {
		super();
		this.text = text;
		this.user_id = user_id;
	}
	
	public Comment(int post_id, String text, int user_id) {
		super();
		this.post_id = post_id;
		this.text = text;
		this.user_id = user_id;
	}
	
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
