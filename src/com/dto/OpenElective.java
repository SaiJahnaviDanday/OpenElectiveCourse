package com.dto;

public class OpenElective {
	private String oId;
	private String year;
	private String branch;
	private String sub;
	
	public OpenElective() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public OpenElective(String oId,String  year,String branch,String sub) {
		this.oId = oId;
		this.year = year;
		this.branch = branch;
		this.sub = sub;
	}


	@Override
	public String toString() {
		return "OpenElective [oId=" + oId + ", year=" + year + ", branch=" + branch + ", sub=" + sub + "]";
	}


	public String getoId() {
		return oId;
	}


	public void setoId(String oId) {
		this.oId = oId;
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


	public String getSub() {
		return sub;
	}


	public void setSub(String sub) {
		this.sub = sub;
	}


	
}
