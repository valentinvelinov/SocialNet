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

	// @RequestMapping(value = "/newPost", method = RequestMethod.GET)
	// public String newPost(@ModelAttribute HttpSession session, Model model)
	// throws PostException {
	// if ((User) session.getAttribute("user") == null) {
	// return "error";
	// }
	// System.out.println(session.getAttribute("user"));
	// session.setAttribute("user", session.getAttribute("user"));
	// Post post = new Post();
	// model.addAttribute("post", post);
	// System.out.println("SessionUser" + session.getAttribute("user"));
	// return "newPost";
	// }
	//
	// @RequestMapping(value = "/newPost", method = RequestMethod.POST)
	// public String newPost2(@ModelAttribute HttpSession session, Model modelView,
	// HttpServletRequest request)
	// throws PostException {
	// // System.out.println(post);
	// // validate
	// System.out.println((User) session.getAttribute("user"));
	// postDAO.makePost((Post) request.getAttribute("post"), (User)
	// session.getAttribute("user"));
	// return "showAllMyPosts";
	// }

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

	// @RequestMapping(value="/addStudent",method=RequestMethod.POST)
	// public String saveStudent(@RequestParam("images") MultipartFile
	// files,@ModelAttribute("addstd") StudentInfo theStudent,Model model){
	// String fileName=null;
	//
	// if(!files.isEmpty()){
	//
	// try {
	// String path=
	// session.getServletContext().getRealPath("/WEB-INF/resources/images");
	// String newName=String.valueOf(new java.util.Date().getTime());
	// fileName=files.getOriginalFilename();
	// String ext=FilenameUtils.getExtension(fileName);
	// File imageFile=new File(path,newName+"."+ext);
	// files.transferTo(imageFile);
	// theStudent.setImages(newName+"."+ext);
	//
	// } catch (Exception e) {
	//
	// }
	// }
	// studentService.saveStudent(theStudent);
	// return "redirect:/login";
	// }

	// @RequestMapping("post/delete/{id}")
	// public String delete(@PathVariable Integer id) throws UserException,
	// PostException {
	// postDAO.deletePost(id);
	// return "redirect:/deletePost";
	// }

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

	// @RequestMapping(value = "post/posts/{id}", method = RequestMethod.GET)
	// public String showPostByID(Model viewModel) throws UserException,
	// PostException {
	// int id = 7;
	// Post post = postDAO.getPostById(id);
	// viewModel.addAttribute(post);
	// return "posts";
	// }

}