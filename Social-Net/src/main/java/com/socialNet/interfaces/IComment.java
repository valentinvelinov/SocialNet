package com.socialNet.interfaces;

import java.util.List;

import com.socialNet.exception.CommentException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Comment;

public interface IComment {
	public void postComment (int postId, int userId, String content) throws CommentException;
	public List<Comment> showCommetsByPost(int postId) throws CommentException, UserException;
	
}
