package com.socialNet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.socialNet.dao.PostDAO;
import com.socialNet.exception.PostException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Post;
import com.socialNet.model.User;

@Controller
public class PostController {

	@Autowired
	PostDAO postDAO;

	@RequestMapping(value = "post/posts/{id}", method = RequestMethod.GET)
	public String showPostByID(Model viewModel) throws UserException, PostException {
		int id = 7;
		Post post = postDAO.getPostById(id);
		viewModel.addAttribute(post);
		return "posts";
	}

	@RequestMapping(value = "/showAllMyPosts", method = RequestMethod.GET)
	public String viewAllPosts(HttpSession session, Model viewModel)
			throws UserException, PostException, SQLException, ClassNotFoundException {
		if ((User) session.getAttribute("user") == null) {
			return "error";
		}
		ArrayList<Post> listOfPosts = postDAO.viewAllMyPosts((User) session.getAttribute("user"));
		viewModel.addAttribute(listOfPosts);
		System.out.println(listOfPosts);

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

	// @RequestMapping("post/{id}")
	// public String showProduct(@PathVariable Integer id, Model model) {
	// model.addAttribute("post", postService.getPostById(id));
	// return "postshow";
	// }
	//
	// @RequestMapping("post/edit/{id}")
	// public String edit(@PathVariable Integer id, Model model) {
	// model.addAttribute("post", postService.getPostById(id));
	// return "postform";
	// }

	@RequestMapping(value = "/newPost", method = RequestMethod.GET)
	public String newPost(HttpSession session, Model model) throws PostException {
		if ((User) session.getAttribute("user") == null) {
			return "error";
		}

		Post post = new Post();
		model.addAttribute("post", post);
		return "newPost";
	}

	@RequestMapping(value = "/newPost", method = RequestMethod.POST)
	public String newPost2(@ModelAttribute HttpSession session, Post post) throws PostException {
		System.out.println(post);
		// validate
		postDAO.makePost(post, (User) session.getAttribute("user"));
		return "showAllMyPosts";
	}

	// @RequestMapping(value = "/gallery", method = RequestMethod.GET)
	// public String viewGallery(HttpSession session, Model model) throws
	// PostException {
	// if ((User) session.getAttribute("user") == null) {
	// return "error";
	// }
	//
	// Post post = new Post();
	// model.addAttribute("post", post);
	// return "gallery";
	// }

	// @RequestMapping("post/delete/{id}")
	// public String delete(@PathVariable Integer id) throws UserException,
	// PostException {
	// postDAO.deletePost(id);
	// return "redirect:/deletePost";
	// }
}