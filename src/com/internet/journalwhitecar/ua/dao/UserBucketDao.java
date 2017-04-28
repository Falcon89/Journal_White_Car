package com.internet.journalwhitecar.ua.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.internet.journalwhitecar.ua.model.Periodicals;
import com.internet.journalwhitecar.ua.model.User;
import com.internet.journalwhitecar.ua.model.UserBucket;
import com.internet.journalwhitecar.ua.util.ConnectionManager;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserBucketDao {

	private final String ADD_ORDER_SQL = "insert into user_bucket(`user_id`,`periodicals_id`,`date_in`,`date_out`,`paid_price`) values(?,?,?,?,?) ";
	private final String READ_ORDER_BY_Id_SQL = "SELECT * FROM user_bucket ub INNER JOIN periodicals p ON ub.periodicals_id = p.periodicals_id INNER JOIN user u ON ub.user_id = u.user_id INNER JOIN address a ON u.user_id = a.user_id where periodicals_id=? ";
		private final String READ_ALL_FROM_BUCKET_SQL = "SELECT * FROM user_bucket ub INNER JOIN periodicals p ON ub.periodicals_id = p.periodicals_id INNER JOIN user u ON ub.user_id = u.user_id";
	private final String READ_USERS_ORDER_USERS_Id_SQL = "SELECT * FROM user_bucket ub INNER JOIN periodicals p ON ub.periodicals_id = p.periodicals_id INNER JOIN user u ON ub.user_id = u.user_id INNER JOIN address a ON u.user_id = a.user_id where users_id=? ";
	private final String CANCELL_STATUS = "update user_bucket set status=\"cancelled\" where bucket_id=?";
	private final String PAY_STATUS = "update user_bucket set status=\"payed\" where bucket_id=?";
	private final String CHECK_ON_ISCANCELED = "SELECT  status FROM user_bucket WHERE bucket_id =?";
	private final String DELETE_ORDER = "DELETE FROM user_bucket WHERE bucket_id =?";
	
	
	
	private PreparedStatement preparedStatement;
	private Connection connectionManager;
	
	
	
	public UserBucketDao() {
		connectionManager = (Connection) ConnectionManager.makeConnection();
		
	}

	public void deleteOrder(Integer userBucketId){
		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(DELETE_ORDER);
			preparedStatement.setInt(1, userBucketId);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	
	
	public Integer addOrderToBucket(Integer userId, Integer periodicalsId, Date dateIn, Date dateOut, 
			Integer paidPrice) {
		
		Integer generatedKey = 0;
		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(ADD_ORDER_SQL,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, periodicalsId);
			preparedStatement.setDate(3, dateIn);
			preparedStatement.setDate(4, dateOut);
			preparedStatement.setInt(5, paidPrice);
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

	public UserBucket getPeriodicalById(int periodicalId) {
		UserBucket userBucket = null;
		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(READ_ORDER_BY_Id_SQL);
			preparedStatement.setInt(1, periodicalId);

			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			userBucket = new UserBucket();

			User user = new User();
			user.setId(rs.getInt(1));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setUserImage(rs.getString("user_image"));
			user.setRole(rs.getString("role"));
			user.setLastModified(rs.getTimestamp("user_last_modified"));

//			if (rs.getInt("isdelete") == 1) {
//				user.setIsDeleted(true);
//			} else {
//				user.setIsDeleted(false);
//			}
//			if (user.getIsDeleted()) {
//				user = null;
//				userBucket = null;
//				return userBucket;
//			}

			Periodicals periodicals = new Periodicals();
			periodicals.setId(rs.getInt("periodicals_id"));
			periodicals.setName(rs.getString("periodicals_name"));
			periodicals.setDescription(rs.getString("periodicals_description"));
			periodicals.setImage(rs.getString("periodicals_image"));
			periodicals.setPriceForPublishment(rs.getInt("price_for_month"));
			periodicals.setLastModified(rs.getTimestamp("periodicals_last_modified"));
			periodicals.setPeriodicity(rs.getInt("periodicity"));

//			if (rs.getInt("isdelete") == 1) {
//				periodicals.setIsDeleted(true);
//			} else {
//				periodicals.setIsDeleted(false);
//			}
//
//			if (periodicals.getIsDeleted()) {
//				periodicals = null;
//				userBucket = null;
//				return userBucket;
//			}

			Date dateIn = rs.getDate("date_in");
			Date dateOut = rs.getDate("date_out");

			userBucket.setUserId(user);
			userBucket.setPeriodicalId(periodicals);
			userBucket.setDateIn(dateIn);
			userBucket.setDateOut(dateOut);
			userBucket.setStatus(rs.getString("status"));
			userBucket.setPaidPrice(rs.getInt("paidPrice"));

		} catch (SQLException e) {
			System.out.println(e);
		}

		return userBucket;
	}

	public UserBucket getPeriodicalByUserId(int userId) {
		UserBucket userBucket = null;
		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(READ_USERS_ORDER_USERS_Id_SQL);
			preparedStatement.setInt(1, userId);

			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			userBucket = new UserBucket();

			User user = new User();
			user.setId(rs.getInt(1));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setUserImage(rs.getString("user_image"));
			user.setRole(rs.getString("role"));
			user.setLastModified(rs.getTimestamp("user_last_modified"));

//			if (rs.getInt("isdelete") == 1) {
//				user.setIsDeleted(true);
//			} else {
//				user.setIsDeleted(false);
//			}
//			if (user.getIsDeleted()) {
//				user = null;
//				userBucket = null;
//				return userBucket;
//			}

			Periodicals periodicals = new Periodicals();
			periodicals.setId(rs.getInt("periodicals_id"));
			periodicals.setName(rs.getString("periodicals_name"));
			periodicals.setDescription(rs.getString("periodicals_description"));
			periodicals.setImage(rs.getString("periodicals_image"));
			periodicals.setPriceForPublishment(rs.getInt("price_for_month"));
			periodicals.setLastModified(rs.getTimestamp("periodicals_last_modified"));
			periodicals.setPeriodicity(rs.getInt("periodicity"));

//			if (rs.getInt("isdelete") == 1) {
//				periodicals.setIsDeleted(true);
//			} else {
//				periodicals.setIsDeleted(false);
//			}
//
//			if (periodicals.getIsDeleted()) {
//				periodicals = null;
//				userBucket = null;
//				return userBucket;
//			}

			Date dateIn = rs.getDate("date_in");
			Date dateOut = rs.getDate("date_out");

			userBucket.setUserId(user);
			userBucket.setPeriodicalId(periodicals);
			userBucket.setDateIn(dateIn);
			userBucket.setDateOut(dateOut);
			userBucket.setStatus(rs.getString("status"));
			userBucket.setPaidPrice(rs.getInt("paidPrice"));

		} catch (SQLException e) {
			System.out.println(e);
		}

		return userBucket;
	}

	public List<UserBucket> getAllBucket() {
		List<UserBucket> bucket = new ArrayList<UserBucket>();

		UserBucket userBucket = null;
		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(READ_ALL_FROM_BUCKET_SQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				userBucket = new UserBucket();
				userBucket.setId(rs.getInt(1));
				User user = new User();
				user.setId(rs.getInt(2));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUserImage(rs.getString("user_image"));
				user.setRole(rs.getString("role"));
				user.setLastModified(rs.getTimestamp("user_last_modified"));

//				if (rs.getInt("isdelete") == 1) {
//					user.setIsDeleted(true);
//				} else {
//					user.setIsDeleted(false);
//				}
//				if (user.getIsDeleted()) {
//					user = null;
//					userBucket = null;
//
//				} else {
//					userBucket.setUserId(user);
//
//				}

				Periodicals periodicals = new Periodicals();
				periodicals.setId(rs.getInt("periodicals_id"));
				periodicals.setName(rs.getString("periodicals_name"));
				periodicals.setDescription(rs.getString("periodicals_description"));
				periodicals.setImage(rs.getString("periodicals_image"));
				periodicals.setPriceForPublishment(rs.getInt("price_for_month"));
				periodicals.setLastModified(rs.getTimestamp("periodicals_last_modified"));
				periodicals.setPeriodicity(rs.getInt("periodicity"));

//				if (rs.getInt("isdelete") == 1) {
//					periodicals.setIsDelete(true);
//				} else {
//					periodicals.setIsDelete(false);
//				}
//
//				if (periodicals.getIsDelete()) {
//					periodicals = null;
//					userBucket = null;
//
//				} else {
//					userBucket.setPeriodicalsId(periodicals);
//				}

				Date dateIn = rs.getDate("date_in");
				Date dateOut = rs.getDate("date_out");
				if (userBucket != null) {
					userBucket.setUserId(user);
					userBucket.setPeriodicalId(periodicals);
					userBucket.setDateIn(dateIn);
					userBucket.setDateOut(dateOut);
					userBucket.setStatus(rs.getString("status"));
					userBucket.setPaidPrice(rs.getInt("paid_price"));

					bucket.add(userBucket);
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return bucket;
	}

	public void cancelSubscribe(int userBucketId) {
		try {	
				preparedStatement = (PreparedStatement) connectionManager.prepareStatement(CANCELL_STATUS);
				preparedStatement.setInt(1, userBucketId);
				preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}

	
	}

	public Boolean payForSubscribe(int userBucketId) {
		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(CHECK_ON_ISCANCELED);
			preparedStatement.setInt(1, userBucketId);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			if (rs.getString("status").equals("added")) {
				preparedStatement = (PreparedStatement) connectionManager.prepareStatement(PAY_STATUS);
				preparedStatement.setInt(1, userBucketId);
				preparedStatement.executeUpdate();
				return true;
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

		return false;
	}

	

	
	
	
}
