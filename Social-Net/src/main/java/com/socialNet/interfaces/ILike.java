package com.socialNet.interfaces;

import com.socialNet.exception.LikeException;
import com.socialNet.model.Like;

public interface ILike {
	public int likePost (Like like) throws LikeException;
}
