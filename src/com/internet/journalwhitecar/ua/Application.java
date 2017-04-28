package com.internet.journalwhitecar.ua;

import com.internet.journalwhitecar.ua.dao.UserDao;
import com.internet.journalwhitecar.ua.model.User;

public class Application {
	public static void main(String[] args) {


		UserDao u=new UserDao();
		User user =new User();
		/*		user.setFirstName("Nick");
		user.setLastName("Troyan");
		user.setEmail("vasyl.kachala@gmail.com");
		user.setPassword("12345");
		user.setUserImage("D://image.jpeg");
		u.insertUser(user);*/
System.out.println(u.getAllUsers());
//System.out.println(u.getUserByEmail("vasyl.kachala@gmail.com"));
//System.out.println(u.getUserByEmail2());
//System.out.println(u.getUserlogin());
	}
}
