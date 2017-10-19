package com.socialNet.testPostContents;

import java.util.Date;

import org.junit.Test;

import com.socialNet.dao.PostDAO;
import com.socialNet.dao.UserDAO;
import com.socialNet.exceptions.PostException;
import com.socialNet.exceptions.UserException;
import com.socialNet.pojo.Post;
import com.socialNet.pojo.User;
import static org.junit.Assert.assertEquals;

public class TestPost {
	private PostDAO postDao = new PostDAO();
	private Post post;
	
//	String first_name, String last_name, String email, Date birth_date, Gender gender, String password
	
	@Test
	public void testPost() throws UserException, PostException {
		User user=new UserDAO().getUserById(5);
		
		System.out.println(user.getUser_id());
		
		Post post = new Post("SomeText",user.getUser_id());
		
		int post_id = postDao.makePost(post, user);
		
		
		assertEquals(4, post_id);
	}
}
