package com.chandan.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String userFullName;
	private String userEmail;
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
