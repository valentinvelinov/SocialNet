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
		User user = (User) session.getAttribute("user");
		System.err.println(user.getUserId());
		System.err.println("USERAAA" + user.getUserId());
		// if (!likeDao.verifiesIfItIsLiked(user.getUserId())) {
		Like like = new Like(postid, user.getUserId());
		likeDao.likePost(like);
		return "userPosts";
		// } else {
		// likeDao.dislikePost(like);
		// }
		// return "newLike";
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
