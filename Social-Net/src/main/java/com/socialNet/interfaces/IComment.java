package com.socialNet.interfaces;

import java.util.List;

import com.socialNet.exception.CommentException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Comment;

public interface IComment {
	public int postComment (Comment comment) throws CommentException;
	public List<Comment> showCommetsByPost(int postId) throws CommentException, UserException;
	
}
