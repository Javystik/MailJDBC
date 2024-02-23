package com.zoi4erom.mailjdbc.persistence.entity;

public class Mail implements Entity{
	private int id;
	private String mailName;
	private String address;
	private String phoneNumber;

	public Mail(MailBuilder mailBuilder) {
		this.id = mailBuilder.id;
		this.mailName = mailBuilder.mailName;
		this.address = mailBuilder.address;
		this.phoneNumber = mailBuilder.phoneNumber;
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

	public static MailBuilder builder(){
		return new MailBuilder();
	}

	public static class MailBuilder {
		private int id;
		private String mailName;
		private String address;
		private String phoneNumber;

		public MailBuilder id(int id){
			this.id = id;
			return this;
		}
		public MailBuilder mailName(String mailName){
			this.mailName = mailName;
			return this;
		}
		public MailBuilder address(String address){
			this.address = address;
			return this;
		}
		public MailBuilder phoneNumber(String phoneNumber){
			this.phoneNumber = phoneNumber;
			return this;
		}
		public Mail build(){
			return new Mail(this);
		}
	}
}