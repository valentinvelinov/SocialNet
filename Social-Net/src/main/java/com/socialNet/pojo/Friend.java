package com.socialNet.pojo;

import com.socialNet.exceptions.FriendException;

public class Friend {

	private int user_id;
	private int friend_id;

	public Friend() {
	}

	public Friend(int user_id, int friend_id) {
		this();
		this.user_id = user_id;
		this.friend_id = friend_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) throws FriendException {
		if (user_id > 0) {
			this.user_id = user_id;
		} else {
			throw new FriendException("Invalid user_id!");
		}
	}

	public int getFriend_id() {
		return friend_id;
	}

	public void setFriend_id(int friend_id) throws FriendException {
		if (friend_id > 0) {
			this.friend_id = friend_id;
		} else {
			throw new FriendException("Invalid user_id!");
		}
	}

}
