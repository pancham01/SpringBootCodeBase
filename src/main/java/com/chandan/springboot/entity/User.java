package com.chandan.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	@Size(min = 2,max = 10,message = "Name is too short..........")
	private String userFullName;
	@Email(message = "Invalid email........")
	private String userEmail;
	@Size(min = 10,max = 10,message = "Kindly enter min 10 digits bro")
	private String userMob;
	private String userCity;
	
	private String userGender;

	public User() {

	}

	public User(String userFullName, String userEmail, String userMob, String userCity, String userGender) {

		this.userFullName = userFullName;
		this.userEmail = userEmail;
		this.userMob = userMob;
		this.userCity = userCity;
		this.userGender = userGender;
	}

	

	public User(long userId, @Size(min = 2, max = 10, message = "Name is too short..........") String userFullName,
			@Email(message = "Invalid email........") String userEmail,
			@Size(min = 10, max = 10, message = "Kindly enter min 10 digits bro") String userMob, String userCity,
			String userGender) {
		super();
		this.userId = userId;
		this.userFullName = userFullName;
		this.userEmail = userEmail;
		this.userMob = userMob;
		this.userCity = userCity;
		this.userGender = userGender;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserMob() {
		return userMob;
	}

	public void setUserMob(String userMob) {
		this.userMob = userMob;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFullName=" + userFullName + ", userEmail=" + userEmail + ", userMob="
				+ userMob + ", userCity=" + userCity + ", userGender=" + userGender + "]";
	}

}
