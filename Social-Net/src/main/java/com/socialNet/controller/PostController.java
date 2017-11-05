package com.socialNet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.SessionAttributes;

import com.socialNet.dao.UserDAO;
import com.socialNet.exception.CommentException;
import com.socialNet.exception.PostException;
import com.socialNet.exception.UserException;
import com.socialNet.interfaces.IPost;
import com.socialNet.model.Post;
import com.socialNet.model.User;

@SessionAttributes("user")
@Controller
public class PostController {

	@Autowired
	IPost postDAO;

	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/userPosts", method = RequestMethod.GET)
	public String viewUserPosts(HttpSession session, Model viewModel, HttpServletRequest request)
			throws UserException, PostException, SQLException, ClassNotFoundException {
		if ((User) session.getAttribute("user") == null) {
			return "error";
		}
		ArrayList<Post> listOfUserPosts = postDAO.viewAllPosts((User) session.getAttribute("user"));
		viewModel.addAttribute(listOfUserPosts);
		System.out.println(listOfUserPosts);
		session.setAttribute("user", session.getAttribute("user"));

		return "userPosts";
	}

	@RequestMapping(value = "/showAllMyPosts", method = RequestMethod.GET)
	public String viewMyPosts(HttpSession session, Model viewModel, HttpServletRequest request)
			throws UserException, PostException, SQLException, ClassNotFoundException {
		if ((User) session.getAttribute("user") == null) {
			return "error";
		}
		ArrayList<Post> listOfPosts = postDAO.viewAllMyPosts((User) session.getAttribute("user"));
		viewModel.addAttribute(listOfPosts);

		System.out.println(listOfPosts);
		session.setAttribute("user", session.getAttribute("user"));
		return "showAllMyPosts";
	}

	@RequestMapping(value = "/showAllMyPhotos", method = RequestMethod.GET)
	public String viewAllMyPhotos(HttpSession session, Model viewModel)
			throws UserException, PostException, SQLException, ClassNotFoundException {
		if ((User) session.getAttribute("user") == null) {
			return "error";
		}
		ArrayList<Post> listOfPosts = postDAO.viewAllMyPosts((User) session.getAttribute("user"));
		viewModel.addAttribute(listOfPosts);
		System.out.println(listOfPosts);

		return "showAllMyPhotos";
	}

	@RequestMapping(value = "/newPost", method = RequestMethod.GET)
	public String getPost(@ModelAttribute User user, Post post, Model model) {
		return "newPost";
	}

	@RequestMapping(value = "/newPost", method = RequestMethod.POST)
	public String setPost(@ModelAttribute User user, Post post, Model model, HttpSession session) throws PostException {
		if (user.getEmail() != null) {
			try {
				postDAO.makePost(post, user);
				if (user != null || user.getUserId() != 0) {
					session.setAttribute("user", user);
				}
				return "userPosts";
			} catch (PostException e) {
				return "error";
			}
		}
		return "error";
	}

	@RequestMapping(value = "/editPosts", method = RequestMethod.GET)
	public String editPost(HttpServletRequest request, Model viewModel) throws PostException, UserException {
		int postId = Integer.parseInt(request.getParameter("postId"));
		String content = request.getParameter("content");
		postDAO.updatePost(postId, content);
		return "forward:showAllMyPosts";
	}
	
	@RequestMapping(value = "/deletePost", method = RequestMethod.GET)
	public String deletePost(HttpServletRequest request, Model viewModel) throws PostException, UserException {
		int postId = Integer.parseInt(request.getParameter("postId"));
		postDAO.deletePost(postId);
		return "forward:showAllMyPosts";
	}


}