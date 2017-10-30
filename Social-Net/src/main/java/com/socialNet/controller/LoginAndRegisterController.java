package com.socialNet.controller;

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
	public String userLogin(@ModelAttribute User user,HttpSession session) {
		if(user.getEmail()!=null) {
			try {
				userDAO.loginUser(user);
				
			} catch (UserException e) {
				return "error";
			}
		} else {
			return "error";
		}
		
		return "test";
	}
//	@RequestMapping( value = "/index", method = RequestMethod.GET)
//    public String welcome(@ModelAttribute User user,Model model) {
//        model.addAttribute("user",new User());
//        return "index";
//    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET) 
	 public String loginTest(@ModelAttribute User user,Model model) {
		
		return "login";
	}
}
		
		
	
