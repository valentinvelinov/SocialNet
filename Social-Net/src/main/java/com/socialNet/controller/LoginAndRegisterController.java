package com.socialNet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.socialNet.dao.UserDAO;
import com.socialNet.exception.UserException;
import com.socialNet.model.User;

@Controller
public class LoginAndRegisterController {
	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogin(@ModelAttribute User user, HttpSession session,Model model) {
		if (user.isValidEmailAddress(user.getEmail())) {
			try {
				userDAO.loginUser(user);
				user=userDAO.getUserById(user.getUser_id());
				System.err.println(user.getUser_id());
				 if ( user != null || user.getUser_id() != 0 ) {
			            session.setAttribute("user", user);
			        }
				 return "redirect:showAllPosts";
			} catch (UserException e) {
				return "error";
			}
		}
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
				 if ( user != null || user.getUser_id() != 0 ) {
			            session.setAttribute("user", user);
			        }
				return "redirect:showAllPosts";
			} catch (UserException e) {
				return "error";
			}
		}
		return "error";
	}
	
	@RequestMapping( value = "/logout") 
    public String logout(User user,HttpSession session, HttpServletResponse response, HttpServletRequest request, Model model) throws ServletException, IOException {
        session.invalidate();
        response.setHeader("Pragma", "No-cache");
        response.setDateHeader("Expires", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/html");
        Cookie[] cookies = request.getCookies();
        if ( cookies != null ) for ( Cookie cookie : cookies ) {
            cookie.setValue("");
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        return "index";
    }
	
}
