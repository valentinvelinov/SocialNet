package com.socialNet.interfaces;

import com.socialNet.exception.CommentException;
import com.socialNet.model.Comment;

public interface IComment {
	public int postComment (Comment comment) throws CommentException;
	
}
