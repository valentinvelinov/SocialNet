package com.socialNet.testPostContents;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.socialNet.dao.LikeDAO;
import com.socialNet.dao.PostDAO;
import com.socialNet.dao.UserDAO;
import com.socialNet.exceptions.LikeException;
import com.socialNet.exceptions.PostException;
import com.socialNet.exceptions.UserException;
import com.socialNet.pojo.Like;
import com.socialNet.pojo.Post;
import com.socialNet.pojo.User;

public class TestLike {

	private PostDAO postDao = new PostDAO();
	private Post post;
	private User user;
	private UserDAO userDAO;
	private Like like;
	private LikeDAO likedao= new LikeDAO();
	
	//int like_id, int post_id, int user_id
	@Test
	public void testLike() throws UserException, PostException, LikeException {
		User user=new UserDAO().getUserById(5);
		
		Post post = postDao.getPostById(1);
		
		like=new Like(post.getPost_id(), user.getUser_id());
		
		
		int id=likedao.likePost(like);
		
		System.out.println(id);
		
		
		assertEquals(2,id);
	}
}
