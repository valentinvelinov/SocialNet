package com.socialNet.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.socialNet.exception.LikeException;
import com.socialNet.interfaces.ILike;
import com.socialNet.model.Like;
import com.socialNet.model.User;

@Controller
public class LikeController {

	@Autowired
	ILike likeDao;

	@RequestMapping(value = "/newLike", method = RequestMethod.GET)
	public String likePost(HttpServletRequest request, HttpSession session, Model model) throws LikeException {
		String id = request.getParameter("postId");
		int postid = Integer.parseInt(id);
		User u = (User) session.getAttribute("user");
		System.err.println("USER E TUAK VE" + session.getAttribute("user"));
		System.err.println(u);
		Like like = new Like(postid, u.getUserId());
		likeDao.like(like);
		return "forward:userPosts";
	}

	@RequestMapping(value = "/showAllLikes", method = RequestMethod.GET)
	public String showLikes(HttpServletRequest request, Model viewModel) throws LikeException, SQLException {
		String postId = request.getParameter("postId");
		int myPost = Integer.parseInt(postId);
		List<Like> likes = likeDao.showLikesByPost(myPost);
		viewModel.addAttribute(likes);
		return "showLikes";
	}

}
