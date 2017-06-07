package com.internet.journalwhitecar.ua;

import com.internet.journalwhitecar.ua.dao.UserDao;
import com.internet.journalwhitecar.ua.model.User;
import com.internet.journalwhitecar.ua.service.ProductsService;

public class Application {
	public static void main(String[] args) {


//		UserDao u=new UserDao();
//		User user =new User();
		ProductsService productsService= new ProductsService();
		/*		user.setFirstName("Nick");
		user.setLastName("Troyan");
		user.setEmail("vasyl.kachala@gmail.com");
		user.setPassword("12345");
		user.setUserImage("D://image.jpeg");
		u.insertUser(user);*/
//System.out.println(u.getAllUsers());
//System.out.println(u.getUserByEmail("vasyl.kachala@gmail.com"));
//System.out.println(u.getUserByEmail2());
//System.out.println(u.getUserlogin());
//loginServlet  loginServlet = new loginServlet();
//System.out.println(loginServlet);
//System.out.println(productsService.getAllPeriodicals());
//System.out.println(productsService.getAllPeriodicalsDeleted());
//System.out.println(productsService.getAllPeriodicalsWithDeleted());
System.out.println(productsService.getAllPeriodicals());

	}
}
