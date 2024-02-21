package com.zoi4erom.mailjdbc.persistence.dao;

import java.util.List;

public interface Dao<T, E>{
	boolean create(E e);
	List<E> getAll();
	E getById(T id);
	E update(E e);
	boolean delete(T id);
}
