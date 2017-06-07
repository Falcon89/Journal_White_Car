package com.internet.journalwhitecar.ua.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.internet.journalwhitecar.ua.model.Periodicals;
import com.internet.journalwhitecar.ua.util.ConnectionManager;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PeriodicalsDao {
	private final String CREATE_PERIODICALS_SQL = "insert into periodicals(`name`, `description`,`image`,`priceForPublishment`,`lastModified`,`periodicity`,`isDeleted`) values(?,?,?,?,?,?,0) ";
	private final String UPDATE_PERIODICALS_SQL = "update periodicals set  name=?, description=?, image=?, priceForPublishment=? , lastModified=? , periodicity=? , isDeleted=?  where id=? ";
	private final String READ_PERIODICALS_BY_Id = "select * from periodicals where id=? ";
	private final String DELETE_FROM_BY_Id = "update periodicals set  isDeleted=1, lastModified=? where id=?";
	private final String READ_ALL_FROM_PERIODICALS_SQL = "select * from periodicals";
	private final String RESTORE_PERIODICAL = "update periodicals set  isdelete=0 where id=?";

	private PreparedStatement preparedStatement;
	private Connection connectionManager;

	public PeriodicalsDao() {

		connectionManager = (Connection) ConnectionManager.makeConnection();

	}

	public void restorePeriodical(Integer periodicalId) {
		try {
			preparedStatement = (PreparedStatement) connectionManager.prepareStatement(RESTORE_PERIODICAL);
			preparedStatement.setInt(1, periodicalId);
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

			/*
			 * if (periodicals.getImage() != null) {
			 * preparedStatement.setString(3, periodicals.getImage());} if
			 * (periodicals.getImage() == null) {
			 * periodicals.setImage("pages/images/car/not-image.jpg"); }
			 */

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
			if (periodicals.getImage() != null) {
				preparedStatement.setString(3, periodicals.getImage());
			}
			preparedStatement.setInt(4, periodicals.getPriceForPublishment());
			long time = System.currentTimeMillis();
			Timestamp timestamp = new Timestamp(time);
			preparedStatement.setTimestamp(5, timestamp);
			preparedStatement.setInt(6, periodicals.getPeriodicity());
			//
			preparedStatement.setBoolean(7, periodicals.getIsDeleted());

			//
			preparedStatement.setInt(8, periodicalsId);
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
			periodicals.setId(rs.getInt("id"));
			periodicals.setName(rs.getString("name"));
			periodicals.setDescription(rs.getString("description"));
			periodicals.setImage(rs.getString("image"));
			periodicals.setPriceForPublishment(rs.getInt("priceForPublishment"));
			periodicals.setLastModified(rs.getTimestamp("lastModified"));

			periodicals.setIsDeleted(rs.getBoolean("isDeleted"));

			periodicals.setPeriodicity(rs.getInt("periodicity"));

			/*
			 * if (periodicals.getIsDeleted() == true) { return null; }
			 */

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
				periodicals.setId(rs.getInt("id"));
				periodicals.setName(rs.getString("name"));
				periodicals.setDescription(rs.getString("description"));
				periodicals.setImage(rs.getString("image"));
				periodicals.setPriceForPublishment(rs.getInt("priceForPublishment"));
				periodicals.setLastModified(rs.getTimestamp("lastModified"));
				periodicals.setPeriodicity(rs.getInt("periodicity"));
				periodicals.setIsDeleted(rs.getBoolean("isDeleted"));

				if (!periodicals.getIsDeleted()) {
					listOfPeriodicals.add(periodicals);
				}
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
				periodicals.setId(rs.getInt("id"));
				periodicals.setName(rs.getString("name"));
				periodicals.setDescription(rs.getString("description"));
				periodicals.setImage(rs.getString("image"));
				periodicals.setPriceForPublishment(rs.getInt("priceForPublishment"));
				periodicals.setLastModified(rs.getTimestamp("lastModified"));
				periodicals.setPeriodicity(rs.getInt("periodicity"));

				if (rs.getInt("isDeleted") == 1) {
					periodicals.setIsDeleted(true);
				} else {
					periodicals.setIsDeleted(false);
				}

				listOfPeriodicals.add(periodicals);

			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return listOfPeriodicals;
	}

}
