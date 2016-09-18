package com.sjzjava.dto;

public class UserDto {
	
	//用户ID
	private String userId;
	//用户名
	private String userName;
	//用户年龄
	private int age;
	//用户生日（暂时作为用户民族使用）
	private String birthday;
	//用户地址
	private String address;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
