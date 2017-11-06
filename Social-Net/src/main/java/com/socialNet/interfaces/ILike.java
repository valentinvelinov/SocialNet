package com.socialNet.interfaces;

import java.util.List;

import org.springframework.stereotype.Component;

import com.socialNet.exception.LikeException;
import com.socialNet.model.Like;

@Component
public interface ILike {
	public void like(Like like) throws LikeException;

	//public boolean verifiesIfItIsLiked(int postId, int userId) throws SQLException;

	//boolean dislikePost(Like like);

	public List<Like> showLikesByPost(int myPost) throws LikeException;

}
