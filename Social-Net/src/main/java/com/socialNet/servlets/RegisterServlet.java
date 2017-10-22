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
		String gender=request.getParameter("gender");
		String password=request.getParameter("password");
		
		//TO DO FIX GENDER AND DATE CASTING!
		Gender myGender=Gender.MALE;
		String date = "2014-01-28";
		java.util.Date utilDate = null;
		try {
			utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		try {
			User user= new User(firstname,lastName,email,sqlDate,myGender,password);
			UserDAO daO= new UserDAO();
			int id=daO.registerUser(user);
			if(id!=0) {
				response.sendRedirect("./Home.jsp");
			} else {
				response.sendRedirect("./Error.html");
			}
		} catch (UserException e) {
			response.sendRedirect("./Error.html");
		}
	}

}
