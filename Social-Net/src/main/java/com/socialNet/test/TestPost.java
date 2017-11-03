package com.socialNet.test;

import com.socialNet.dao.PostDAO;
import com.socialNet.dao.UserDAO;
import com.socialNet.exception.PostException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Post;
import com.socialNet.model.User;

public class TestPost {
	private PostDAO postDao = new PostDAO();
	private Post post;

	public void testPost() throws UserException, PostException {
		User user = new UserDAO().getUserById(5);

		System.out.println(user.getUserId());

		Post post = new Post(0, "SomeText", user.getUserId(), "something.jpg");

		int post_id = postDao.makePost(post, user);

		assertEquals(4, post_id);
	}

	private void assertEquals(int i, int post_id) {
		// TODO Auto-generated method stub

	}
}
