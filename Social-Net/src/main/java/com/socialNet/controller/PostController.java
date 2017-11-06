package com.socialNet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.socialNet.dao.UserDAO;
import com.socialNet.exception.PostException;
import com.socialNet.exception.UserException;
import com.socialNet.interfaces.IPost;
import com.socialNet.model.Post;
import com.socialNet.model.User;

@MultipartConfig
@SessionAttributes("user")
@Controller
public class PostController extends HttpServlet

{

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
	public String getPost(@ModelAttribute User user, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		String content = "";
		MultipartFile file = null;
		String name = null;
		request.setAttribute("content", content);
		request.setAttribute("file", file);
		request.setAttribute("pictureName", name);
		session.setAttribute("user", session.getAttribute("user"));
		Post post = new Post();
		// model.addAttribute("post", post);
		return "newPost";
	}

	@RequestMapping(value = "/newPost", method = RequestMethod.POST)
	public String setPost(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws PostException {
		User user = (User) session.getAttribute("user");

		if (user.getEmail() != null) {
			String content = (String) request.getParameter("content");
			String file = (String) request.getParameter("file");
			String pictureName = request.getParameter("pictureName");

			System.err.println(content + "content");
			System.err.println(file + "file");
			System.err.println(pictureName + "pictureName");
			System.err.println("aaaaaaaaaaaaaaa");

			// System.err.println(user);
			// post.setPictureName(post.getFile().getName());
			// postDAO.makePost(post, user);

			if (user != null || user.getUserId() != 0) {
				session.setAttribute("user", user);
			}
			return "upload";
		}
		return "error";
	}

	@RequestMapping(value = "/editPost", method = RequestMethod.GET)
	public String editPost(HttpServletRequest request, Model viewModel) throws PostException, UserException {
		Post post = new Post();
		viewModel.addAttribute(post);
		return "editPost";
	}

	@RequestMapping(value = "/editPost", method = RequestMethod.POST)
	public String editPostPost(@ModelAttribute User user, HttpSession session, HttpServletRequest request,
			Model viewModel, @ModelAttribute("post") Post post) throws PostException, UserException {
		if (user.getEmail() != null) {
			try {
				int postId = post.getPostId();
				String content = post.getContent();

				postDAO.updatePost(postId, content);
				if (user != null || user.getUserId() != 0) {
					session.setAttribute("user", user);

				}
				return "showAllMyPosts";
			} catch (PostException e) {
				return "error";
			}
		}
		return "showAllMyPosts";
	}
	//
	// @RequestMapping(value = "/editPost", method = RequestMethod.GET)
	// public String editComment(HttpServletRequest request, Model viewModel) throws
	// CommentException, UserException, PostException {
	// int postId = Integer.parseInt(request.getParameter("postId"));
	// String content = request.getParameter("content");
	// postDAO.updatePost(postId, content);
	// return "forward:showPostComments";
	// }

	@RequestMapping(value = "/deletePost", method = RequestMethod.GET)
	public String deletePost(HttpServletRequest request, Model viewModel) throws PostException, UserException {
		int postId = Integer.parseInt(request.getParameter("postId"));
		postDAO.deletePost(postId);
		return "forward:showAllMyPosts";
	}

}