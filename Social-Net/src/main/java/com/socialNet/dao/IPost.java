package com.socialNet.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.socialNet.exception.PostException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Post;
import com.socialNet.model.User;

public interface IPost {
	public ArrayList<Post> viewAllPosts(User user) throws PostException, UserException, SQLException;

	public int makePost(Post post, User user) throws PostException;

	public Post getPostById(int id) throws UserException, PostException;

	public void deletePost(int postId) throws UserException, PostException;
}
