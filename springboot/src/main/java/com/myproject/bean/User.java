package com.myproject.bean;

public class User {
	private String username;
	private String password;
	private String name;
	private String age;
	private String sex;
	public User(String name,String age,String sex) {
		this.name=name;
		this.age=age;
		this.sex = sex;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "User [ name=" + name + ", age=" + age + ", sex="+ sex + "]";
	}
	
	

}
