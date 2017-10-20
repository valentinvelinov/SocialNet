package com.socialNet.pojo;

import com.socialNet.exceptions.LikeException;

public class Like {
	private int like_id;
	private int post_id;
	private int user_id;
	
	public Like(int like_id, int post_id, int user_id) throws LikeException {
		super();
		setLike_id(like_id);
		setPost_id(post_id);
		setUser_id(user_id);
	}

	public Like(int post_id, int user_id) throws LikeException {
		super();
		setPost_id(post_id);
		setUser_id(user_id);
	}

	public int getLike_id() {
		return like_id;
	}

	public void setLike_id(int like_id) throws LikeException {
		if (like_id > 0) {
			this.like_id = like_id;
		} else {
			throw new LikeException("You can't like this post right now, please try again later!");
		}
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) throws LikeException {
		if (post_id > 0) {
			this.post_id = post_id;
		} else {
			throw new LikeException("You can't like this post right now, please try again later!");
		}
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) throws LikeException {
		if (user_id > 0) {
			this.user_id = user_id;
		} else {
			throw new LikeException("You can't like this post right now, please try again later!");
		}
	}

}
