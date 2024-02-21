package com.zoi4erom.mailjdbc.persistence.entity;

public class Mail {
	private int id;
	private String mailName;
	private String address;
	private String phoneNumber;

	public Mail(int id, String mailName, String address, String phoneNumber) {
		this.id = id;
		this.mailName = mailName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public Mail(String mailName, String address, String phoneNumber) {
		this.mailName = mailName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMailName() {
		return mailName;
	}

	public void setMailName(String mailName) {
		this.mailName = mailName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Mail{" +
		    "id=" + id +
		    ", mailName='" + mailName + '\'' +
		    ", address='" + address + '\'' +
		    ", phoneNumber='" + phoneNumber + '\'' +
		    '}';
	}
}