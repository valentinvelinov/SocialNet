package com.socialNet.model;

import com.socialNet.exception.LikeException;

public class Like {
	private int likeId;
	private int postId;
	private int userId;

	public Like(int postId, int userId) throws LikeException {
		setPostId(postId);
		setUserId(userId);
	}

	public Like(int likeId, int postId, int userId) throws LikeException {
		this(postId, userId);
		setLikeId(likeId);

	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) throws LikeException {
		if (likeId > 0) {
			this.likeId = likeId;
		} else {
			throw new LikeException("You can't like this post right now, please try again later!");
		}
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) throws LikeException {
		if (postId > 0) {
			this.postId = postId;
		} else {
			throw new LikeException("You can't like this post right now, please try again later!");
		}
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) throws LikeException {
		if (userId > 0) {
			this.userId = userId;
		} else {
			throw new LikeException("You can't like this post right now, please try again later!");
		}
	}

}
