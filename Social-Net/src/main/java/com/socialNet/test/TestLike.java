package com.socialNet.test;

import com.socialNet.dao.LikeDAO;
import com.socialNet.dao.PostDAO;
import com.socialNet.dao.UserDAO;
import com.socialNet.exception.LikeException;
import com.socialNet.exception.PostException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Like;
import com.socialNet.model.Post;
import com.socialNet.model.User;

public class TestLike {

	private PostDAO postDao = new PostDAO();
	private Post post;
	private User user;
	private UserDAO userDAO;
	private Like like;
	private LikeDAO likedao = new LikeDAO();

	public void testLike() throws UserException, PostException, LikeException {
		User user = new UserDAO().getUserById(5);

		Post post = postDao.getPostById(1);

		like = new Like(post.getPostId(), user.getUserId());

		int id = likedao.likePost(like);

		System.out.println(id);

		assertEquals(2, id);
	}

	private void assertEquals(int i, int id) {
		// TODO Auto-generated method stub

	}
}
