package com.socialNet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.socialNet.model.User;

@Controller
public class WelcomeController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String welcome(@ModelAttribute User user, Model model) {
		return "index";
	}
}
