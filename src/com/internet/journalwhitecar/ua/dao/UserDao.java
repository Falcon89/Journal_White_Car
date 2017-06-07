package com.internet.journalwhitecar.ua.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.internet.journalwhitecar.ua.model.User;
import com.internet.journalwhitecar.ua.util.ConnectionManager;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserDao {

	private final String CREATE_USER_SQL = "insert into user(`first_name`, `last_name`,`email`,`password`,`user_image`,`last_modified`,`role`,`is_deleted`) values(?,?,?,?,?,?,?,?) ";
	private final String UPDATE_USER_SQL = "update user set  first_name=?, last_name=?, email=?, password=? , user_image=? , user_last_modified=?  where user_id=? ";
	private final String READ_USER_BY_Id = "select * from user where user_id=?";
	private final String DELETE_USER_BY_Id = "update user set  isdelete=? where user_id=?";
	private final String READ_ALL_FROM_USER_SQL = "select * from user";
	private final String GET_BUCKET_NUMEROUS = "select order_number from user where user_id=?";
	private final String SET_BUCKET_NUMEROUS = "update user set order_number=?  where user_id=?";

	private PreparedStatement preparedStatement;
	private Connection connectionManager;

	public UserDao() {
		connectionManager = (Connection) ConnectionManager.makeConnection();
	}

	public void setOrdersNumerous(Integer userId, Integer orderNumerous) {
		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(SET_BUCKET_NUMEROUS);
			preparedStatement.setInt(1, orderNumerous);
			preparedStatement.setInt(2, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public Integer getOrdersNumerous(Integer userId) {
		Integer numerous = 0;
		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(GET_BUCKET_NUMEROUS);
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			numerous = rs.getInt("order_number");

		} catch (SQLException e) {
			System.out.println(e);
		}

		return numerous;
	}

	public Integer insertUser(User user) {
		Integer generatedKey = 0;
		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(CREATE_USER_SQL,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getUserImage());
			long time = System.currentTimeMillis();
			Timestamp timestamp = new Timestamp(time);
			preparedStatement.setTimestamp(6, timestamp);
			preparedStatement.setString(7, "USER");
			preparedStatement.setBoolean(8, false);

			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();

			if (rs.next()) {
				generatedKey = rs.getInt(1);
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
		return generatedKey;
	}

	public void updateUser(int userId, User user) {

		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(UPDATE_USER_SQL);

			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getUserImage());
			long time = System.currentTimeMillis();
			Timestamp timestamp = new Timestamp(time);
			preparedStatement.setTimestamp(6, timestamp);
			preparedStatement.setInt(7, userId);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void deleteUser(int userId) {
		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(DELETE_USER_BY_Id);
			preparedStatement.setInt(1, 1);
			preparedStatement.setInt(2, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public User getUser(int userId) {
		User user = null;
		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(READ_USER_BY_Id);
			preparedStatement.setInt(1, userId);

			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			user = new User();
			user.setId(rs.getInt(1));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setUserImage(rs.getString("user_image"));
			user.setRole(rs.getString("role"));
			user.setLastModified(rs.getTimestamp("user_last_modified"));

			if (rs.getInt("isdelete") == 1) {
				user.setIsDeleted(true);
			} else {
				user.setIsDeleted(false);
			}
			if (user.getIsDeleted()) {
				user = null;
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

		return user;

	}

	public List<User> getAllUsers() {
		List<User> listOfUsers = new ArrayList<User>();
		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(READ_ALL_FROM_USER_SQL);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				if (!rs.getBoolean("is_deleted")) {
					User user = new User();
					user = new User();
					user.setId(rs.getInt(1));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					user.setUserImage(rs.getString("user_image"));
					user.setRole(rs.getString("role"));
					user.setLastModified(rs.getTimestamp("last_modified"));
					user.setIsDeleted(rs.getBoolean("is_deleted"));

					listOfUsers.add(user);
				}

			}
		} catch (SQLException e) {
			System.out.println(e);

		}

		return listOfUsers;
	}
}
