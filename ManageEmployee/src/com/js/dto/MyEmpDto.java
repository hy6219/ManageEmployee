package com.js.dto;

import java.util.Date;

public class MyEmpDto {
	/**
	 * CREATE TABLE MYEMP(
	USERID    VARCHAR(20) PRIMARY KEY,
	PWD       VARCHAR(20) NOT NULL,
	NAME      VARCHAR(20) NOT NULL,
	LEV       CHAR(1)     DEFAULT 'A',--A:운영자 B:일반회원
	REGDATE   DATE        DEFAULT SYSDATE,
	GENDER    CHAR(1)     DEFAULT '1',--1:남자 2:여자
	PHONE     VARCHAR(30)
);
	 */
	private String userId;
	private String pwd;
	private String name;
	private String lev;
	private Date   regDate;
	private String gender;
	private String phone;
	public MyEmpDto() {

		// TODO Auto-generated constructor stub
	}
	public MyEmpDto(String userId, String pwd, String name, String lev, Date regDate, String gender, String phone) {

		this.userId = userId;
		this.pwd = pwd;
		this.name = name;
		this.lev = lev;
		this.regDate = regDate;
		this.gender = gender;
		this.phone = phone;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLev() {
		return lev;
	}
	public void setLev(String lev) {
		this.lev = lev;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "MyEmpDto [userId=" + userId + ", pwd=" + pwd + ", name=" + name + ", lev=" + lev + ", regDate="
				+ regDate + ", gender=" + gender + ", phone=" + phone + "]";
	}
	
	
	
}
