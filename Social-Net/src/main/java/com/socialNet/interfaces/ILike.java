package com.socialNet.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.socialNet.exception.LikeException;
import com.socialNet.model.Like;
import com.socialNet.model.User;

public interface ILike {
	public void like(Like like) throws LikeException;

	//public boolean verifiesIfItIsLiked(int postId, int userId) throws SQLException;

	//boolean dislikePost(Like like);

	public List<Like> showLikesByPost(int myPost) throws SQLException;

}
