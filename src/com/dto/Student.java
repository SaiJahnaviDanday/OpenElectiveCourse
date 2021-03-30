package com.dto;

public class Student {
	private String sName;
	private String year;
	private String branch;
	private String loginId;
	private String password;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Student(String sName, String year, String branch,String loginId, String password) {
		super();
		this.sName = sName;
		this.year = year;
		this.branch = branch;
		this.loginId = loginId;
		this.password = password;
	}


	@Override
	public String toString() {
		return "Student [sName=" + sName + ", year=" + year + ", branch=" + branch + ", loginId="
				+ loginId + ", password=" + password + "]";
	}

	public String getsName() {
		return sName;
	}


	public void setsName(String sName) {
		this.sName = sName;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	
	
	
}
