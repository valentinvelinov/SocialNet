package com.socialNet.model;

import com.socialNet.exception.FriendException;

public class Friend {

	private int userId;
	private int friendId;

	public Friend() {
	}

	public Friend(int userId, int friendId) {
		this.userId = userId;
		this.friendId = friendId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) throws FriendException {
		if (userId > 0) {
			this.userId = userId;
		} else {
			throw new FriendException("Invalid user id!");
		}
	}

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) throws FriendException {
		if (friendId > 0) {
			this.friendId = friendId;
		} else {
			throw new FriendException("Invalid user id!");
		}
	}

}
