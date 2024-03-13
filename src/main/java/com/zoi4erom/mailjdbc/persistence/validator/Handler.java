package com.zoi4erom.mailjdbc.persistence.validator;

public interface Handler<E, T extends Handler<E, T>>{

	void validate(E e);

	void setNextHandler(T t);
}
