package com.socialNet.testPostContents;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.socialNet.dao.CommentDao;
import com.socialNet.dao.PostDAO;
import com.socialNet.dao.UserDAO;
import com.socialNet.exceptions.CommentException;
import com.socialNet.exceptions.PostException;
import com.socialNet.exceptions.UserException;
import com.socialNet.pojo.Comment;
import com.socialNet.pojo.Post;
import com.socialNet.pojo.User;


public class TestComment {
	private PostDAO postDao = new PostDAO();
	private Post post;
	private Comment comment;
	private CommentDao commentDAO = new CommentDao();
	
	//int comment_id, int post_id, String text, int user_id
	@Test
	public void testComment() throws UserException, PostException, CommentException {
		User user=new UserDAO().getUserById(5);
		
		System.out.println(user.getUser_id());
		
		Post post = postDao.getPostById(1);
		
		comment=new Comment(post.getPost_id(),"Insert some funny comment here", user.getUser_id());
		int comment_id=commentDAO.postComment(comment);
		
		
		assertEquals(1,comment_id);
	}
}
