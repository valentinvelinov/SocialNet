package com.socialNet.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return "posts";
	}

	@RequestMapping(value = "/showAllPosts", method = RequestMethod.GET)
	public String viewAllPosts(Model viewModel, HttpServletRequest request)
			throws UserException, PostException, SQLException, ClassNotFoundException {
		ArrayList<Post> listOfPosts = postDAO.viewAllPosts();
		viewModel.addAllAttributes(listOfPosts);

		return "showAllPosts";
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

	@RequestMapping("/newPost")
	public String newProduct(Model model) {
		model.addAttribute("post", new Post());
		return "newPost";
	}
	
	
	// @RequestMapping("post/delete/{id}")
	// public String delete(@PathVariable Integer id) {
	// postService.deletePost(id);
	// return "redirect:/post";
	// }
}