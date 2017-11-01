package com.socialNet.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	private int post_id;
	private String content;
	private int user_id;
	private User user;
	private String picture_name;
	private Date date_post;
	List<Comment> commentsForPost = new ArrayList<Comment>();
	private int like_count;
	private int comment_count;

	public Post(String content, int user_id, String picture_name, Date date_post) {
		setContent(content);
		setUser_id(user_id);
		setPicture_name(picture_name);
		setDate_post(date_post);

	}

	public Post(int post_id, String content, int user_id, String picture_name, Date date_post) {
		this(content, user_id, picture_name, date_post);
		setPost_id(post_id);

	}

	public Post() {
		super();
	}

	public List<Comment> getCommentsForPost() {
		return commentsForPost;
	}

	public int getLike_count() {
		return like_count;
	}

	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}

	public void setCommentsForPost(List<Comment> commentsForPost) {
		this.commentsForPost = commentsForPost;
	}

	public String getPicture_name() {
		return picture_name;
	}

	public void setPicture_name(String picture_name) {
		this.picture_name = picture_name;
	}

	public Date getDate_post() {
		return date_post;
	}

	public void setDate_post(Date date_post) {
		this.date_post = date_post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getPost_id() {
		return post_id;
	}

	public String getContent() {
		return content;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setPost_id(int post_id) {
		if (post_id > 0) {
			this.post_id = post_id;
		}
	}

	public void setContent(String content) {
		if (content != null && !content.isEmpty()) {
			this.content = content;
		}
	}

	public void setUser_id(int user_id) {
		if (user_id > 0) {
			this.user_id = user_id;
		}
	}

	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", content=" + content + ", user_id=" + user_id + ", user=" + user
				+ ", picture_name=" + picture_name + ", date_post=" + date_post + ", commentsForPost=" + commentsForPost
				+ "]";
	}

}
