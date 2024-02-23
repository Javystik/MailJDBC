package com.zoi4erom.mailjdbc.persistence.exception;
public class ConnectionCloseException extends RuntimeException {

	public ConnectionCloseException(String message) {
		super(message);
	}
}
