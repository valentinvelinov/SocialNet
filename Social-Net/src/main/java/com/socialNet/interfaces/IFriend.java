package com.socialNet.interfaces;

import java.util.List;

import com.socialNet.exception.FriendException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Friend;

public interface IFriend {
	public int addFriend(Friend friend) throws FriendException;

	public List<Friend> getFriends(Friend friend) throws UserException;

	boolean removeFriend(Friend friend);

	boolean verifiesIfTheresAlreadyThisFriend(Friend friendship);
}
