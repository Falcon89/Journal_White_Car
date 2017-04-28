package com.internet.journalwhitecar.ua.model;

import java.sql.Date;

public class UserBucket {

	private Integer id;
	private User userId;
	private Periodicals periodicalId;
	private Date dateIn;
	private Date dateOut;
	private String status;
	private Integer paidPrice;
	private Double totalPrice;
	private String formattedTotalPrice;
	


	public UserBucket(Integer bucketId, User userId, Periodicals periodicals_id, Date dateIn, Date dateOut,
			String status, Integer paidPrice) {
		super();
		this.id = bucketId;
		this.userId = userId;
		this.periodicalId = periodicals_id;
		this.dateIn = dateIn;
		this.dateOut = dateOut;
		this.status = status;
		this.paidPrice = paidPrice;
	}

	public UserBucket(User userId, Periodicals periodicals_id, Date dateIn, Date dateOut, String status,
			Integer paidPrice) {
		super();
		this.userId = userId;
		this.periodicalId = periodicals_id;
		this.dateIn = dateIn;
		this.dateOut = dateOut;
		this.status = status;
		this.paidPrice = paidPrice;
	}

	
	public Periodicals getPeriodicalId() {
		return periodicalId;
	}

	public void setPeriodicalId(Periodicals periodicalId) {
		this.periodicalId = periodicalId;
	}

	public UserBucket() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	

	public Date getDateIn() {
		return dateIn;
	}

	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}

	public Date getDateOut() {
		return dateOut;
	}

	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPaidPrice() {
		return paidPrice;
	}

	public void setPaidPrice(Integer paidPrice) {
		this.paidPrice = paidPrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getFormattedTotalPrice() {
		return formattedTotalPrice;
	}

	public void setFormattedTotalPrice(String formattedTotalPrice) {
		this.formattedTotalPrice = formattedTotalPrice;
	}

	@Override
	public String toString() {
		return "UserBucket [bucketId=" + id + ", userId=" + userId + ", periodicals_id=" + periodicalId
				+ ", dateIn=" + dateIn + ", dateOut=" + dateOut + ", status=" + status + ", paidPrice=" + paidPrice
				+ ", totalPrice=" + totalPrice + "]";
	}



	

	

}
