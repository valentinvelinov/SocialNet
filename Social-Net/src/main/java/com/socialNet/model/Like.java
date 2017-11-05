package com.socialNet.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
@Component
public class Like {
	@NotBlank
	private int likeId;
	@NotBlank
	private int postId;
	@NotBlank
	private int userId;

	public Like(int likeId, int postId, int userId) {
		super();
		setLikeId(likeId);
		setPostId(postId);
		setUserId(userId);
	}

	public Like(int postId, int userId) {
		super();
		setPostId(postId);
		setUserId(userId);
	}

	public Like() {

	}

	// Getters and Setters
	public int getLikeId() {
		return likeId;
	}

	public int getPostId() {
		return postId;
	}

	public int getUserId() {
		return userId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Like [likeId=" + likeId + ", postId=" + postId + ", userId=" + userId + "]";
	}

}
