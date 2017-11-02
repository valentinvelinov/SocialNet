package com.socialNet.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class Post {
	private int postId;
	@NotBlank
	private String content;
	private int userId;
	private User user;
	private String pictureName;
	@NotBlank
	private Date datePost;
	List<Comment> commentsForPost = new ArrayList<Comment>();
	private int likeCount;
	private int commentCount;

	public Post(String content, int userId, String pictureName, Date datePost) {
		setContent(content);
		setUserId(userId);
		setPictureName(pictureName);
		setDatePost(datePost);

	}

	public Post(int postId, String content, int userId, String pictureName, Date datePost) {
		this(content, userId, pictureName, datePost);
		setPostId(postId);

	}

	public Post() {
		super();
	}

	public List<Comment> getCommentsForPost() {
		return commentsForPost;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public void setCommentsForPost(List<Comment> commentsForPost) {
		this.commentsForPost = commentsForPost;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public Date getDatePost() {
		return datePost;
	}

	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getPostId() {
		return postId;
	}

	public String getContent() {
		return content;
	}

	public int getUserId() {
		return userId;
	}

	public void setPostId(int postId) {
		if (postId > 0) {
			this.postId = postId;
		}
	}

	public void setContent(String content) {
		if (content != null && !content.isEmpty()) {
			this.content = content;
		}
	}

	public void setUserId(int userId) {
		if (userId > 0) {
			this.userId = userId;
		}
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", content=" + content + ", userId=" + userId + ", user=" + user
				+ ", pictureName=" + pictureName + ", datePost=" + datePost + ", commentsForPost=" + commentsForPost
				+ "]";
	}

}
