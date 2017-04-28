package com.internet.journalwhitecar.ua.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.internet.journalwhitecar.ua.service.UserService;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session = request.getSession(false);
			UserService userService=new UserService();
    		Integer userId = (Integer) session.getAttribute("userId");
    		System.out.println("UserId = "+userId);
    		
//    		int numerous=userService.getOrderNumerous(userId);    		
//    		userService.setOrderNumerous(userId, numerous);
    		
    		
	        if(session != null){
	            session.invalidate();
	        }
//	        PeriodicalsService periodicalsService=new PeriodicalsService();
//    		List <Periodicals> list=periodicalsService.getAllPeriodicals();
    		
//    		request.setAttribute("allPeriodicals",list);
//	        LocaleSingleton.getInstance().setLocale(request);
	    	request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}