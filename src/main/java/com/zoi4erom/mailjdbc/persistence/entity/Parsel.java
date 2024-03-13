package com.zoi4erom.mailjdbc.persistence.entity;

import java.util.ArrayList;

public class Parsel extends Entity{
	private int id;
	private int mailId;
	private String name;
	private int parselTypeId;
	private int senderUserId;
	private int recipientUserId;
	public Parsel(ParselBuilder parselBuilder) {
		this.id = parselBuilder.id;
		this.mailId = parselBuilder.mailId;
		this.name = parselBuilder.name;
		this.parselTypeId = parselBuilder.parselTypeId;
		this.senderUserId = parselBuilder.senderUserId;
		this.recipientUserId = parselBuilder.recipientUserId;
		this.validationMessages = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public int getParselTypeId() {
		return parselTypeId;
	}

	public void setParselTypeId(int parselTypeId) {
		this.parselTypeId = parselTypeId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMailId() {
		return mailId;
	}

	public void setMailId(int mailId) {
		this.mailId = mailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSenderUserId() {
		return senderUserId;
	}

	public void setSenderUserId(int senderUserId) {
		this.senderUserId = senderUserId;
	}

	public int getRecipientUserId() {
		return recipientUserId;
	}

	public void setRecipientUserId(int recipientUserId) {
		this.recipientUserId = recipientUserId;
	}


	@Override
	public String toString() {
		return "Parsel{" +
		    "id=" + id +
		    ", mailId=" + mailId +
		    ", name='" + name + '\'' +
		    ", parselTypeId=" + parselTypeId +
		    ", senderUserId=" + senderUserId +
		    ", recipientUserId=" + recipientUserId +
		    '}';
	}
	public static ParselBuilder builder(){
		return new ParselBuilder();
	}

	public static class ParselBuilder {
		private int id;
		private int mailId;
		private String name;
		private int parselTypeId;
		private int senderUserId;
		private int recipientUserId;

		public ParselBuilder id(int id){
			this.id = id;
			return this;
		}
		public ParselBuilder mailId(int mailId){
			this.mailId = mailId;
			return this;
		}
		public ParselBuilder name(String name){
			this.name = name;
			return this;
		}
		public ParselBuilder parselTypeId(int parselTypeId){
			this.parselTypeId = parselTypeId;
			return this;
		}
		public ParselBuilder senderUserId(int senderUserId){
			this.senderUserId = senderUserId;
			return this;
		}
		public ParselBuilder recipientUserId(int recipientUserId){
			this.recipientUserId = recipientUserId;
			return this;
		}
		public Parsel build(){
			return new Parsel(this);
		}
	}
}
