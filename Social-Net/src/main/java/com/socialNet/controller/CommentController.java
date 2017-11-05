package com.socialNet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.socialNet.dao.CommentDAO;
import com.socialNet.exception.CommentException;
import com.socialNet.exception.UserException;
import com.socialNet.model.Comment;
import com.socialNet.model.User;

@Controller
public class CommentController {

	@Autowired
	CommentDAO commentDAO;

	@RequestMapping(value = "/newComment", method = RequestMethod.GET)
	public String createComment(@ModelAttribute Comment comment,HttpServletRequest request,HttpSession session) throws CommentException {
		int postId=Integer.parseInt(request.getParameter("postId"));
		User user=(User) session.getAttribute("user");
		commentDAO.postComment(postId,user.getUserId(),comment.getText());
		return "forward:showPostComments";
	} 

	@RequestMapping(value = "/showPostComments", method = RequestMethod.GET)
	public String showComments(@ModelAttribute Comment comment,HttpServletRequest request, Model viewModel) throws CommentException, UserException {
		String postId = request.getParameter("postId");
		int myPost = Integer.parseInt(postId);
		List<Comment> comments = commentDAO.showCommetsByPost(myPost);
		viewModel.addAttribute(comments);
		return "showAllMyComments";
	}

	@RequestMapping(value = "/editcomment", method = RequestMethod.GET)
	public String editComment(HttpServletRequest request, Model viewModel) throws CommentException, UserException {
		int postId = Integer.parseInt(request.getParameter("postId"));
		int commentId = Integer.parseInt(request.getParameter("commentId"));
		String content = request.getParameter("content");
		commentDAO.updateComment(commentId, content);
		return "forward:showPostComments";
	}
	
	@RequestMapping(value = "/deletecomment", method = RequestMethod.GET)
	public String deleteComment(HttpServletRequest request, Model viewModel) throws CommentException, UserException {
		int postId = Integer.parseInt(request.getParameter("postId"));
		int commentId = Integer.parseInt(request.getParameter("commentId"));
		commentDAO.deleteComment(commentId);
		return "forward:showPostComments";
	}

}