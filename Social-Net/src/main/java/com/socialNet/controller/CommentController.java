package com.socialNet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.socialNet.dao.CommentDAO;
import com.socialNet.exception.CommentException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Comment;

@Controller
public class CommentController {

	@Autowired
	CommentDAO commentDAO;

	@RequestMapping(value = "/newComment", method = RequestMethod.POST)
	public String createComment(@RequestBody Comment comment) throws CommentException {
		commentDAO.postComment(comment);
		return "newComment";
	}

	@RequestMapping(value = "/showPostComments", method = RequestMethod.GET)
	public String showComments(HttpServletRequest request,Model viewModel) throws CommentException, UserException {
		String postId=request.getParameter("postId");
		int myPost=Integer.parseInt(postId);
		List<Comment> comments = commentDAO.showCommetsByPost(myPost);
		for(Comment c:comments) {
			System.err.println(c.getText());
		}
		Comment comment= comments.get(0);
		viewModel.addAttribute(comments);
		return "showAllMyComments";
	}

}