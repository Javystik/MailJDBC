package com.zoi4erom.mailjdbc.persistence.dao.contracts;

import com.zoi4erom.mailjdbc.persistence.dao.Dao;
import com.zoi4erom.mailjdbc.persistence.entity.User;
import java.util.List;

public interface UserDao extends Dao<Integer, User> {
	@Override
	boolean create(User user);
	@Override
	List<User> getAll();
	@Override
	User getById(Integer id);
	@Override
	User update(User user);
	@Override
	boolean delete(Integer id);
}