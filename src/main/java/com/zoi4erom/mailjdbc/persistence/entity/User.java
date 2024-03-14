package com.zoi4erom.mailjdbc.persistence.entity;

import java.util.ArrayList;

public class User extends Entity{
	private int id;
	private String fullName;
	private String password;
	private String homeAddress;
	public User(UserBuilder userBuilder) {
		this.id = userBuilder.id;
		this.fullName = userBuilder.fullName;
		this.password = userBuilder.password;
		this.homeAddress = userBuilder.homeAddress;
		this.validationMessages = new ArrayList<>();
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	@Override
	public String toString() {
		return "User{" +
		    "id=" + id +
		    ", fullName='" + fullName + '\'' +
		    ", password='" + password + '\'' +
		    ", homeAddress='" + homeAddress + '\'' +
		    '}';
	}
	public static UserBuilder builder() {
		return new UserBuilder();
	}

	public static class UserBuilder {
		private int id;
		private String fullName;
		private String password;
		private String homeAddress;

		public UserBuilder id(int id){
			this.id = id;
			return this;
		}
		public UserBuilder fullName(String fullName){
			this.fullName = fullName;
			return this;
		}
		public UserBuilder password(String password){
			this.password = password;
			return this;
		}
		public UserBuilder homeAddress(String homeAddress){
			this.homeAddress = homeAddress;
			return this;
		}
		public User build(){
			return new User(this);
		}
	}
}