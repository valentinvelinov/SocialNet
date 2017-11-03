package com.socialNet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.socialNet.dao.CommentDAO;
import com.socialNet.exception.CommentException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Comment;

@Controller
public class CommentControler {

	@Autowired
	CommentDAO commentDAO;

	@RequestMapping(value = "/newComment", method = RequestMethod.POST)
	public String createComment(@RequestBody Comment comment) throws CommentException {
		commentDAO.postComment(comment);
		return "newComment";
	}

	@RequestMapping(value = "/showCommetsByPost", method = RequestMethod.GET)
	public String showComments(int idpost) throws CommentException, UserException {
		List<Comment> comments = commentDAO.showCommetsByPost(idpost);
		return "comments";
	}

}