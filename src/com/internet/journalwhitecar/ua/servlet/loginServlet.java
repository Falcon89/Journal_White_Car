package com.internet.journalwhitecar.ua.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.internet.journalwhitecar.ua.model.User;
import com.internet.journalwhitecar.ua.service.UserService;


@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();		

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		add session
HttpSession session = request.getSession(true);
Integer userId = (Integer) session.getAttribute("userId");
		if(userId !=null){
			User user = userService.getUser(userId);
			session.setAttribute("first_name", user.getFirstName());
			session.setAttribute("last_name", user.getLastName());
			session.setAttribute("userId", user.getId());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("role", user.getRole());
			session.setAttribute("data_modifide", user.getLastModified());
			session.setAttribute("userimage", user.getUserImage());
			
//			session.setAttribute("enter", user);
		}
//	end add session
		 
		request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	}
