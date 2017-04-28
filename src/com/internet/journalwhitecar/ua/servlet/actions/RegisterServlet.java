package com.internet.journalwhitecar.ua.servlet.actions;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.internet.journalwhitecar.ua.dao.UserDao;
import com.internet.journalwhitecar.ua.model.User;
import com.internet.journalwhitecar.ua.service.UserService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		UserDao dao = new UserDao();
		String firstName = request.getParameter("register-firstname");
		String lastName = request.getParameter("register-lastname");
		String login = request.getParameter("register-email");
		String password = request.getParameter("register-password");

		if (validate(firstName) && validate(lastName) && validate(login) && validate(password)) {
			if (!userService.checkDoesLoginAreadyUsed(login)) {
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmail(login);
				user.setPassword(password);
				user.setUserImage("D://default.jpeg");
//				user.setRole("user");
				userService.insertUser(user);
				System.out.println("Registration successful : " + login);
				System.out.println("User is heve :" + login);
				System.out.println(user.getEmail());
				System.out.println(dao.getAllUsers());
			}
		} else {
			System.out.println("Registration failded : " + login);
		}
		request.getRequestDispatcher("/login").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private boolean validate(String value) {
		if (value.equals("") || value == null)
			return false;
		return true;

	}

}
