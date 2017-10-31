package com.socialNet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.socialNet.dao.PostDAO;
import com.socialNet.exception.PostException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Post;

@Controller
public class PostController {

	@Autowired
	PostDAO postDAO;

	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public String showPostByID(Model viewModel) throws UserException, PostException {
		int id = 7;
		Post post = postDAO.getPostById(id);
		viewModel.addAttribute(post);
		// model.addAttribute("post", postDao.showPosts());
		// System.out.println("Returning posts:");
		return "posts";
	}

	@RequestMapping(value = "/allPosts", method = RequestMethod.GET)
	public String viewAllPosts(Model viewModel) throws UserException, PostException, SQLException {
		ArrayList<Post> listOfPosts = postDAO.viewAllPosts();
		for(Post p : listOfPosts) {
			System.out.println(p.getContent());
		}
		viewModel.addAttribute(listOfPosts);
		return "allPosts";
	}

	/**
	 * View a specific post by its id.
	 *
	 * @param id
	 * @param model
	 * @return
	 */
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
	//
	// /**
	// * New product.
	// *
	// * @param model
	// * @return
	// */
	// @RequestMapping("post/new")
	// public String newProduct(Model model) {
	// model.addAttribute("post", new Post());
	// return "postform";
	// }
	//
	// /**
	// * Save post to database.
	// *
	// * @param post
	// * @return
	// */
	// @RequestMapping(value = "post", method = RequestMethod.POST)
	// public String saveProduct(Post post) {
	// postService.savePost(post);
	// return "redirect:/post/" + post.getId();
	// }
	//
	// /**
	// * Delete post by its id.
	// *
	// * @param id
	// * @return
	// */
	// @RequestMapping("post/delete/{id}")
	// public String delete(@PathVariable Integer id) {
	// postService.deletePost(id);
	// return "redirect:/post";
	// }
}