package com.socialNet.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.socialNet.exception.PostException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Post;
import com.socialNet.model.User;
@Component
public interface IPost {
	@Autowired
	public ArrayList<Post> viewAllMyPosts(User user) throws PostException, UserException, SQLException;

	public ArrayList<Post> viewAllPosts(User user) throws PostException, UserException, SQLException;

	public int makePost(Post post, User user) throws PostException;

	public Post getPostById(int id) throws UserException, PostException;

	public void deletePost(int postId) throws UserException, PostException;
}
