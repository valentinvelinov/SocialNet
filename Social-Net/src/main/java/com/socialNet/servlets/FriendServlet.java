package com.socialNet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.socialNet.dao.UserDAO;
import com.socialNet.pojo.User;

@WebServlet("/Friends")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDAO userDao;
	private User user;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		ServletContext ctx = getServletConfig().getServletContext();
		HttpSession session = request.getSession(true);
		Integer personId = (Integer) session.getAttribute("user_id");
		if (request.getParameter("user_id") != null) {
			personId = Integer.parseInt(request.getParameter("user_id"));
		}
		PrintWriter out = response.getWriter();
		try {

			List<User> friends = null;
			String orderParam = request.getParameter("order");
			boolean order = (orderParam == null || !orderParam.equals("DESC"));
			String orderBy = request.getParameter("orderBy");
			if (orderBy != null && orderBy.equals("place")) {
				friends = userDao.friendsSortedByPlace(user.getPlace(), order);
			} else if (orderBy != null && orderBy.equals("dateOfBirth")) {
				friends = userDao.friendsSortedByDateOfBirth(user.getBirth_date(), order);
			} else {
				friends = userDao.friendsSortedByName(user.getFirst_name(), order);
			}

			List<User> nonFriends = userDao.nonFriendsFor(personId);
			// request.setAttribute("friends", friends);
			// request.setAttribute("nonFriends", nonFriends);
			// ctx.getRequestDispatcher("/friends.jsp").forward(request, response);

			request.setAttribute("people", friends);
			ctx.getRequestDispatcher("/friends.jsp").forward(request, response);

			/*
			 * TODO output your page here out.println("<html>"); out.println("<head>");
			 * out.println("<title>Servlet FriendServlet</title>"); out.println("</head>");
			 * out.println("<body>"); out.println("<h1>Servlet FriendServlet at " +
			 * request.getContextPath () + "</h1>"); out.println("</body>");
			 * out.println("</html>");
			 */

		} finally {
			out.close();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
