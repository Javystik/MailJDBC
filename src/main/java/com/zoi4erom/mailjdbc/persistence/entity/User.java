package com.zoi4erom.mailjdbc.persistence.entity;
public class User implements Entity{
	private int id;
	private String fullname;
	private String password;
	private String homeAdress;

	public User(UserBuilder userBuilder) {
		this.id = userBuilder.id;
		this.fullname = userBuilder.fullname;
		this.password = userBuilder.password;
		this.homeAdress = userBuilder.homeAdress;
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
	public static UserBuilder builder() {
		return new UserBuilder();
	}

	public static class UserBuilder {
		private int id;
		private String fullname;
		private String password;
		private String homeAdress;

		public UserBuilder id(int id){
			this.id = id;
			return this;
		}
		public UserBuilder fullname(String fullname){
			this.fullname = fullname;
			return this;
		}
		public UserBuilder password(String password){
			this.password = password;
			return this;
		}
		public UserBuilder homeAdress(String homeAdress){
			this.homeAdress = homeAdress;
			return this;
		}
		public User build(){
			return new User(this);
		}
	}
}