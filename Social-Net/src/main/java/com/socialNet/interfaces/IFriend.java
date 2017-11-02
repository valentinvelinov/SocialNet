package com.socialNet.interfaces;

import com.socialNet.exception.FriendException;
import com.socialNet.model.Friend;

public interface IFriend {
	public int addFriend(Friend friend) throws FriendException;
}
