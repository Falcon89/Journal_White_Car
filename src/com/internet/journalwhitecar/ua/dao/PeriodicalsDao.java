package com.internet.journalwhitecar.ua.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.internet.journalwhitecar.ua.model.Periodicals;
import com.internet.journalwhitecar.ua.util.ConnectionManager;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PeriodicalsDao {
	private final String CREATE_PERIODICALS_SQL = "insert into periodicals(`periodicals_name`, `periodicals_description`,`periodicals_image`,`price_for_month`,`periodicals_last_modified`,`periodicity`,`isdelete`) values(?,?,?,?,?,?,0) ";
	private final String UPDATE_PERIODICALS_SQL = "update periodicals set  periodicals_name=?, periodicals_description=?, periodicals_image=?, price_for_month=? , periodicals_last_modified=? , periodicity=?  where periodicals_id=? ";
	private final String READ_PERIODICALS_BY_Id = "select * from periodicals where periodicals_id=? ";
	private final String DELETE_FROM_BY_Id = "update periodicals set  isdelete=1, periodicals_last_modified=? where periodicals_id=?";
	private final String READ_ALL_FROM_PERIODICALS_SQL = "select * from periodicals ";
	private final String RESTORE_PERIODICAL="update periodicals set  isdelete=0 where periodicals_id=?";
	
	
	private PreparedStatement preparedStatement;
	private Connection connectionManager;
	
	
	public PeriodicalsDao() {
		
		connectionManager = (Connection) ConnectionManager.makeConnection();

	}

	
	
	public void restorePeriodical(Integer periodicalId){
		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(RESTORE_PERIODICAL);
			preparedStatement.setInt(1,periodicalId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			
		}

		
	}
	
	
	
	public Integer insertPeriodicals(Periodicals periodicals) {

		Integer generatedKey = 0;
		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(CREATE_PERIODICALS_SQL,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, periodicals.getName());
			preparedStatement.setString(2, periodicals.getDescription());
			preparedStatement.setString(3, periodicals.getImage());
			preparedStatement.setInt(4, periodicals.getPriceForPublishment());
			long time = System.currentTimeMillis();
			Timestamp timestamp = new Timestamp(time);
			preparedStatement.setTimestamp(5, timestamp);
			preparedStatement.setInt(6, periodicals.getPeriodicity());
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

	public void updatePeriodical(int periodicalsId, Periodicals periodicals) {

		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(UPDATE_PERIODICALS_SQL);

			preparedStatement.setString(1, periodicals.getName());
			preparedStatement.setString(2, periodicals.getDescription());
			preparedStatement.setString(3, periodicals.getImage());
			preparedStatement.setInt(4, periodicals.getPriceForPublishment());
			long time = System.currentTimeMillis();
			Timestamp timestamp = new Timestamp(time);
			preparedStatement.setTimestamp(5, timestamp);
			preparedStatement.setInt(6, periodicals.getPeriodicity());
			preparedStatement.setInt(7, periodicalsId);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void deletePeriodicals(int periodicalsId) {
		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(DELETE_FROM_BY_Id);
			long time = System.currentTimeMillis();
			Timestamp timestamp = new Timestamp(time);
			preparedStatement.setTimestamp(1, timestamp);
			preparedStatement.setInt(2, periodicalsId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public Periodicals getPeriodicals(int periodicalsId) {
		Periodicals periodicals = null;
		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(READ_PERIODICALS_BY_Id);
			preparedStatement.setInt(1, periodicalsId);

			ResultSet rs = preparedStatement.executeQuery();
			rs.next();

			periodicals = new Periodicals();
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
//			}

		} catch (SQLException e) {
			System.out.println(e);
		}

		return periodicals;

	}

	public List<Periodicals> getAllPeriodicals() {
		List<Periodicals> listOfPeriodicals = new ArrayList<Periodicals>();
		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(READ_ALL_FROM_PERIODICALS_SQL);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {

				Periodicals periodicals = new Periodicals();
				periodicals = new Periodicals();
				periodicals.setId(rs.getInt("periodicals_id"));
				periodicals.setName(rs.getString("periodicals_name"));
				periodicals.setDescription(rs.getString("periodicals_description"));
				periodicals.setImage(rs.getString("periodicals_image"));
				periodicals.setPriceForPublishment(rs.getInt("price_for_month"));
				periodicals.setLastModified(rs.getTimestamp("periodicals_last_modified"));
				periodicals.setPeriodicity(rs.getInt("periodicity"));

//				if (rs.getInt("isdelete") == 1) {
//					periodicals.setIsDeleted(true);
//				} else {
//					periodicals.setIsDeleted(false);
//				}
//
//				if (periodicals.getIsDeleted()) {
//					periodicals = null;
//				} else {
//					listOfPeriodicals.add(periodicals);
//				}

			}
		} catch (SQLException  e) {
			System.out.println(e);
		}

		return listOfPeriodicals;
	}

	
	public List<Periodicals> getAllDeletedPeriodicals() {
		List<Periodicals> listOfPeriodicals = new ArrayList<Periodicals>();
		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(READ_ALL_FROM_PERIODICALS_SQL);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {

				Periodicals periodicals = new Periodicals();
				periodicals = new Periodicals();
				periodicals.setId(rs.getInt("periodicals_id"));
				periodicals.setName(rs.getString("periodicals_name"));
				periodicals.setDescription(rs.getString("periodicals_description"));
				periodicals.setImage(rs.getString("periodicals_image"));
				periodicals.setPriceForPublishment(rs.getInt("price_for_month"));
				periodicals.setLastModified(rs.getTimestamp("periodicals_last_modified"));
				periodicals.setPeriodicity(rs.getInt("periodicity"));

//				if (rs.getInt("isdelete") == 1) {
//					periodicals.setIsDeleted(true);
//				} else {
//					periodicals.setIsDeleted(false);
//				}
//
//				if (periodicals.getIsDeleted()) {
//					listOfPeriodicals.add(periodicals);
//				} 

			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return listOfPeriodicals;
	}
	
	
	public List<Periodicals> getAllPeriodicalsWithDeleted() {
		List<Periodicals> listOfPeriodicals = new ArrayList<Periodicals>();
		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(READ_ALL_FROM_PERIODICALS_SQL);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {

				Periodicals periodicals = new Periodicals();
				periodicals = new Periodicals();
				periodicals.setId(rs.getInt("periodicals_id"));
				periodicals.setName(rs.getString("periodicals_name"));
				periodicals.setDescription(rs.getString("periodicals_description"));
				periodicals.setImage(rs.getString("periodicals_image"));
				periodicals.setPriceForPublishment(rs.getInt("price_for_month"));
				periodicals.setLastModified(rs.getTimestamp("periodicals_last_modified"));
				periodicals.setPeriodicity(rs.getInt("periodicity"));

//				if (rs.getInt("isdelete") == 1) {
//					periodicals.setIsDeleted(true);
//				} else {
//					periodicals.setIsDeleted(false);
//				}

				
					listOfPeriodicals.add(periodicals);
				

			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return listOfPeriodicals;
	}
	
}
