package com.internet.journalwhitecar.ua.servlet.actions;

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

@WebServlet("/cabinet")
public class CabinetServlet extends HttpServlet {
	private UserService userService = new UserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login-email");
		String password = request.getParameter("login-password");

		List<User> listOfUsers=userService.getAllUsers();
		for (User user : listOfUsers) {
			if(user.getEmail().equals(login) && user.getPassword().equals(password)){
				
			HttpSession session=request.getSession();
			
			session.setAttribute("userLogin", user.getEmail());
			session.setAttribute("userRole", user.getRole());
			
				request.getRequestDispatcher("/services").forward(request, response);
				System.out.println("Login Success : "+login);
			}
		}
		
		System.out.println("Login Denied for : "+login);
		request.getRequestDispatcher("pages/errorpage.jsp").forward(request, response);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
