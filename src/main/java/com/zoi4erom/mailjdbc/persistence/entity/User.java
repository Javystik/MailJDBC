package com.zoi4erom.mailjdbc.persistence.entity;

public class User {
	private int id;
	private String fullname;
	private String password;
	private String homeAdress;

	public User(int id, String fullname, String password, String homeAdress) {
		this.id = id;
		this.fullname = fullname;
		this.password = password;
		this.homeAdress = homeAdress;
	}

	public User(String fullname, String password, String homeAdress) {
		this.fullname = fullname;
		this.password = password;
		this.homeAdress = homeAdress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHomeAdress() {
		return homeAdress;
	}

	public void setHomeAdress(String homeAdress) {
		this.homeAdress = homeAdress;
	}

	@Override
	public String toString() {
		return "User{" +
		    "id=" + id +
		    ", fullname='" + fullname + '\'' +
		    ", password='" + password + '\'' +
		    ", homeAdress='" + homeAdress + '\'' +
		    '}';
	}
}