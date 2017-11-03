package com.socialNet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.socialNet.dao.LikeDAO;
import com.socialNet.exception.LikeException;
import com.socialNet.model.Like;

@Controller
public class LikeController {

	@Autowired
	LikeDAO likeDao = new LikeDAO();

	@RequestMapping(value = "/likePost", method = RequestMethod.POST)
	public String likePost(@RequestBody Like like) throws LikeException {
		likeDao.likePost(like);
		return "like";
	}

}
