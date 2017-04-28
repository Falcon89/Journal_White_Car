package com.internet.journalwhitecar.ua.model;

import java.sql.Timestamp;

public class User {

	private Integer id;
	private String firstName;	
	private String lastName;
	private String email;
	private String password;
	private String role;
	private Timestamp lastModified;
	private String userImage;
	private Boolean isDeleted;
	
	public User() {
		super();
	}

	public User(String firstName, String lastName, String email, String password, String role,
			Timestamp userLastModified, String userImage, Boolean isDeleted) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.lastModified = userLastModified;
		this.userImage = userImage;
		this.isDeleted = isDeleted;
	}



	public User(Integer userId, String firstName, String lastName, String email, String password, String role,
			Timestamp userLastModified, String userImage, Boolean isDeleted) {
		super();
		this.id = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.lastModified = userLastModified;
		this.userImage = userImage;
		this.isDeleted = isDeleted;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "User [userId=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", role=" + role + ", userLastModified=" + lastModified
				+ ", userImage=" + userImage + ", isDeleted=" + isDeleted + "]";
	}




}
