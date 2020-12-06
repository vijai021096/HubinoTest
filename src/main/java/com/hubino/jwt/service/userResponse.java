package com.hubino.jwt.service;

public class userResponse {

	private String userName;
	
	private String deptName;
	
	private String roleName;
	
	private String city;
	
	private String state;
	
	private String country;

	
	
	public userResponse() {
		super();
	}


	public userResponse(String userName, String deptName, String roleName, String city, String state, String country) {
		super();
		this.userName = userName;
		this.deptName = deptName;
		this.roleName = roleName;
		this.city = city;
		this.state = state;
		this.country = country;
	}


	public String getUserName() {
		return userName;
	}
	

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
