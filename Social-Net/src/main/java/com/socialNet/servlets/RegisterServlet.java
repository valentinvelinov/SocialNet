package com.socialNet.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.socialNet.dao.UserDAO;
import com.socialNet.exceptions.UserException;
import com.socialNet.pojo.User;
import com.socialNet.pojo.User.Gender;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname=request.getParameter("firstname");
		String lastName=request.getParameter("lastname");
		String email=request.getParameter("email");
		String birthdate=request.getParameter("date");
		String gender=request.getParameter("Gender");
		String password=request.getParameter("password");
		String profilePic=request.getParameter("profilePic");
		String coverPic=request.getParameter("coverPiic");
		String job=request.getParameter("job");
		String place=request.getParameter("place");
		String education=request.getParameter("education");


		Gender myGender=null;
		if(gender.equalsIgnoreCase("Male")) {
			myGender=Gender.MALE;
		} else {
			myGender=Gender.FEMALE;
		}
		java.util.Date utilDate = null;
		try {
			utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthdate);
		} catch (ParseException e1) {
			System.out.println("KUR");
		}
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		try {
			User user= new User(0, firstname,lastName,email,sqlDate,myGender,password, profilePic, coverPic, job, place, education);
			UserDAO daO= new UserDAO();
			int id=daO.registerUser(user);
			if(id!=0) {
				HttpSession session = request.getSession();
				session.setAttribute("user", id);
				response.sendRedirect("./Home");
			} else {
				response.sendRedirect("./Error.html");
			}
		} catch (UserException e) {
			response.sendRedirect("./Error.html");
		}
	}

}
