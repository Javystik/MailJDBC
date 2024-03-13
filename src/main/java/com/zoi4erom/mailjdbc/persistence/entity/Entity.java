package com.zoi4erom.mailjdbc.persistence.entity;

import java.util.List;

public abstract class Entity {
	List<String> validationMessages;

	public List<String> getValidationMessages() {
		return validationMessages;
	}

	public void setValidationMessages(List<String> validationMessages) {
		this.validationMessages = validationMessages;
	}
}
