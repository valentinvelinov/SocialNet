package com.socialNet.test;

import com.socialNet.dao.CommentDAO;
import com.socialNet.dao.PostDAO;
import com.socialNet.dao.UserDAO;
import com.socialNet.exception.CommentException;
import com.socialNet.exception.PostException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Comment;
import com.socialNet.model.Post;
import com.socialNet.model.User;

public class TestComment {
	private PostDAO postDao = new PostDAO();
	private Post post;
	private Comment comment;
	private CommentDAO commentDAO = new CommentDAO();

	public void testComment() throws UserException, PostException, CommentException {
		User user = new UserDAO().getUserById(5);

		System.out.println(user.getUserId());

		Post post = postDao.getPostById(1);

		comment = new Comment(post.getUserId(), "Insert some funny comment here", user.getUserId(),
				comment.getDateComment());
		int comment_id = commentDAO.postComment(comment);

		assertEquals(1, comment_id);
	}

	private void assertEquals(int i, int comment_id) {

	}
}
