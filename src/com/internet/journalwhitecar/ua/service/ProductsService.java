package com.internet.journalwhitecar.ua.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.internet.journalwhitecar.ua.dao.PeriodicalsDao;
import com.internet.journalwhitecar.ua.model.Periodicals;
import com.internet.journalwhitecar.ua.util.ConnectionManager;
import com.mysql.jdbc.Connection;

public class ProductsService {
	private PeriodicalsDao periodicalsDao;
	private Connection connectionManager;

	public ProductsService() {
		periodicalsDao = new PeriodicalsDao();
		connectionManager = (Connection) ConnectionManager.makeConnection();
	}

	public void deletePeriodical(Integer periodicalsId) {
		periodicalsDao.deletePeriodicals(periodicalsId);
	}

	public void updatePerioical(Integer periodicalsId, Periodicals periodicals) {
		periodicalsDao.updatePeriodical(periodicalsId, periodicals);
	}

	public void restorePeriodical(Integer periodicalId) {
		periodicalsDao.restorePeriodical(periodicalId);
	}

	public Integer addNewPeriodical(Periodicals periodicalsDto) {

		Periodicals periodicals = new Periodicals();
		periodicals.setName(periodicalsDto.getName());
		periodicals.setDescription(periodicalsDto.getDescription());
		periodicals.setImage(periodicalsDto.getImage());
/*		if (periodicalsDto.getImage() != null) {
			periodicals.setImage(periodicalsDto.getImage());
		} else {
			periodicals.setImage("pages/images/car/not-image.jpg");
		}*/
		periodicals.setPriceForPublishment(periodicalsDto.getPriceForPublishment());
		periodicals.setPeriodicity(periodicalsDto.getPeriodicity());
		int periodicalId = periodicalsDao.insertPeriodicals(periodicals);

		return periodicalId;

	}

	public void deletePeriodical(Periodicals periodicalsDto) {
		try {
			connectionManager.setAutoCommit(false);
			periodicalsDao.deletePeriodicals(periodicalsDto.getId());
			connectionManager.commit();
		} catch (SQLException e) {
			System.out.println(e);

			try {
				connectionManager.rollback();
			} catch (SQLException e1) {
				System.out.println(e);

			}
		}
	}

	public Periodicals getPeriodicalsById(Integer periodicalsId) {
		return periodicalsDao.getPeriodicals(periodicalsId);
	}

	public List<Periodicals> sortPeriodicalsByPrice() {
		List<Periodicals> periodicalsList = null;

		try {
			periodicalsList = periodicalsDao.getAllPeriodicals();
			Collections.sort(periodicalsList, new Comparator<Periodicals>() {

				@Override
				public int compare(Periodicals o1, Periodicals o2) {
					return o1.getPriceForPublishment().compareTo(o2.getPriceForPublishment());
				}
			});

		} catch (Exception e) {
			System.out.println(e);

			try {
				connectionManager.rollback();
			} catch (SQLException e1) {
				System.out.println(e);
			}
		}
		return periodicalsList;
	}

	public List<Periodicals> sortPeriodicalsByName() {
		List<Periodicals> periodicalsList = null;

		try {

			periodicalsList = periodicalsDao.getAllPeriodicals();
			Collections.sort(periodicalsList, new Comparator<Periodicals>() {

				@Override
				public int compare(Periodicals o1, Periodicals o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});

		} catch (Exception e) {

			System.out.println(e);

			try {
				connectionManager.rollback();
			} catch (SQLException e1) {
				System.out.println(e);
			}
		}
		return periodicalsList;
	}

	public List<Periodicals> sortPeriodicalsByDate() {
		List<Periodicals> periodicalsList = null;

		try {

			periodicalsList = periodicalsDao.getAllPeriodicals();
			Collections.sort(periodicalsList, new Comparator<Periodicals>() {

				@Override
				public int compare(Periodicals o1, Periodicals o2) {
					return o1.getLastModified().compareTo(o2.getLastModified());
				}
			});

		} catch (Exception e) {

			System.out.println(e);

			try {
				connectionManager.rollback();
			} catch (SQLException e1) {
				System.out.println(e);
			}
		}
		return periodicalsList;
	}

	public List<Periodicals> sortPeriodicalsByPeriodicity() {
		List<Periodicals> periodicalsList = null;

		try {

			periodicalsList = periodicalsDao.getAllPeriodicals();
			Collections.sort(periodicalsList, new Comparator<Periodicals>() {

				@Override
				public int compare(Periodicals o1, Periodicals o2) {
					return o1.getPeriodicity().compareTo(o2.getPeriodicity());
				}
			});

		} catch (Exception e) {

			System.out.println(e);

			try {
				connectionManager.rollback();
			} catch (SQLException e1) {
				System.out.println(e);
			}
		}
		return periodicalsList;
	}

	public List<Periodicals> getListOfPeriodicals() {
		List<Periodicals> periodicalsList = null;
		try {

			periodicalsList = periodicalsDao.getAllPeriodicals();
		} catch (Exception e) {

			System.out.println(e);

			try {
				connectionManager.rollback();
			} catch (SQLException e1) {
				System.out.println(e);
			}
		}
		return periodicalsList;
	}

	public List<Periodicals> getAllPeriodicalsWithDeleted() {
		return periodicalsDao.getAllPeriodicalsWithDeleted();
	}

	public List<Periodicals> getAllPeriodicalsDeleted() {
		return periodicalsDao.getAllPeriodicalsWithDeleted();
	}

	public List<Periodicals> getAllPeriodicals() {
		return periodicalsDao.getAllPeriodicals();
	}

}
