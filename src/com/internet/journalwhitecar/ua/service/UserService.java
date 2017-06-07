package com.internet.journalwhitecar.ua.service;

import java.util.List;

import com.internet.journalwhitecar.ua.dao.UserDao;
import com.internet.journalwhitecar.ua.model.User;

public class UserService {

	private UserDao userDao;

	public UserService() {
		userDao = new UserDao();
	}

	public Integer insertUser(User user) {
		return userDao.insertUser(user);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	public User getUser(Integer userId) {
		User user = userDao.getUser(userId);
		return user;
	}

	public boolean checkDoesLoginAreadyUsed(String login) {
		List<User> listOfUser = getAllUsers();
		for (User user : listOfUser) {
			if (user.getEmail().equalsIgnoreCase(login))
				return true;
		}
		return false;
	}
}
