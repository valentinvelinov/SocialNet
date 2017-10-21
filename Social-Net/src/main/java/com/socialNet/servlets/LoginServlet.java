package com.socialNet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.socialNet.dao.UserDAO;
import com.socialNet.exceptions.UserException;
import com.socialNet.pojo.User;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("./Error.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String email = request.getParameter("user");
		String password = request.getParameter("password");
		try {
			User user = new User(email,password);
			UserDAO userDAO= new UserDAO();
			user.setUser_id(userDAO.loginUser(user));
			if(user.getUser_id()!= 0) {
				response.sendRedirect("./Home.jsp");
			} else {
				response.sendRedirect("./Error.html");
			}
		} catch (UserException e) {
			response.sendRedirect("./Error.html");
		}
	}

}
