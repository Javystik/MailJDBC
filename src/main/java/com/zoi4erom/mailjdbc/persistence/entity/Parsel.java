package com.zoi4erom.mailjdbc.persistence.entity;

public class Parsel {
	private int id;
	private int mailId;
	private String name;
	private int parselTypeId;
	private int senderUserId;
	private int recipientUserId;

	public Parsel(int id, int mailId, String name, int parselTypeId, int senderUserId,
	    int recipientUserId) {
		this.id = id;
		this.mailId = mailId;
		this.name = name;
		this.parselTypeId = parselTypeId;
		this.senderUserId = senderUserId;
		this.recipientUserId = recipientUserId;
	}

	public Parsel(int mailId, String name, int parselTypeId, int senderUserId,
	    int recipientUserId) {
		this.mailId = mailId;
		this.name = name;
		this.parselTypeId = parselTypeId;
		this.senderUserId = senderUserId;
		this.recipientUserId = recipientUserId;
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
}
