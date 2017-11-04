package com.socialNet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.socialNet.dao.UserDAO;
import com.socialNet.exception.UserException;
import com.socialNet.interfaces.IUser;
import com.socialNet.model.User;

@Controller
//@SessionAttributes("user")
public class LoginAndRegisterController {
	@Autowired
	IUser userDAO;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogin(@Valid @ModelAttribute User user, HttpSession session, Model model, BindingResult result) {
		try {
			if (!result.hasErrors()) {
				try {
					userDAO.loginUser(user);
				} catch (UserException e) {
					return "error";
				}
				user = userDAO.getUserById(user.getUserId());
				if (user != null || user.getUserId() != 0) {
					session.setAttribute("user", user);
				}
				return "showAllMyPosts";
			} else {
				String errorName = result.getFieldError().getDefaultMessage().toString();
				String problemField = result.getFieldError().getField().toString();
				String problemName = problemField + " " + errorName;
				model.addAttribute("error", problemName);
				return "index";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String getError(Model model) {
		return "error";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister(@ModelAttribute User user, Model model) {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(@ModelAttribute User user, Model model, HttpSession session) {
		if (user.getEmail() != null) {
			try {
				userDAO.registerUser(user);
				if (user != null || user.getUserId() != 0) {
					session.setAttribute("user", user);
				}
				return "showAllMyPosts";
			} catch (UserException e) {
				return "error";
			}
		}
		return "error";
	}

	@RequestMapping(value = "/logout")
	public String logout(User user, HttpSession session, HttpServletResponse response, HttpServletRequest request,
			Model model) throws ServletException, IOException {
		session.invalidate();
		response.setHeader("Pragma", "No-cache");
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/html");
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies) {
				cookie.setValue("");
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		return "index";
	}

}
