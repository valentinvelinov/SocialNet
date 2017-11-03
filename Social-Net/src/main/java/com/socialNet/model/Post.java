package com.socialNet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class Post {
	@NotBlank
	private int postId;
	@NotBlank
	private String content;
	@NotBlank
	private int userId;
	private String pictureName;
	@NotBlank
	private Date datePost;
	@NotBlank
	private int likeCount;
	@NotBlank
	private int commentCount;

	List<Comment> commentsForPost = Collections.synchronizedList(new ArrayList<Comment>());
	List<Like> likesForPost = Collections.synchronizedList(new ArrayList<Like>());

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

	public Post(int postId, String content, int userId) {
		setContent(content);
		setUserId(userId);
		setPostId(postId);

	}

	public Post() {
		super();
	}

	// Getters and Setters

	public int getPostId() {
		return postId;
	}

	public String getContent() {
		return content;
	}

	public int getUserId() {
		return userId;
	}

	public String getPictureName() {
		return pictureName;
	}

	public Date getDatePost() {
		return datePost;
	}

	public List<Comment> getCommentsForPost() {
		return Collections.unmodifiableList(commentsForPost);
	}

	public List<Like> getLikesForPost() {
		return Collections.unmodifiableList(likesForPost);
	}

	public int getLikeCount() {
		return likeCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}

	public void setCommentsForPost(List<Comment> commentsForPost) {
		this.commentsForPost = commentsForPost;
	}

	public void setLikesForPost(List<Like> likesForPost) {
		this.likesForPost = likesForPost;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

}
