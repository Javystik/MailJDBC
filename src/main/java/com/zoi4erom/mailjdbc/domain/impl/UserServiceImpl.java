package com.zoi4erom.mailjdbc.domain.impl;

import com.zoi4erom.mailjdbc.domain.contracts.UserService;
import com.zoi4erom.mailjdbc.persistence.dao.contracts.UserDao;
import com.zoi4erom.mailjdbc.persistence.dao.impl.UserDaoImpl;
import com.zoi4erom.mailjdbc.persistence.entity.User;
import java.util.List;
public class UserServiceImpl implements UserService {

	private UserServiceImpl() {
	}
	private static class UserServiceImplHolder{
		public static final UserServiceImpl USER_SERVICE_INSTANCE = new UserServiceImpl();
	}
	public static UserServiceImpl getInstance(){
		return UserServiceImpl.UserServiceImplHolder.USER_SERVICE_INSTANCE;
	}

	private final UserDao userDao = UserDaoImpl.getInstance();
	@Override
	public boolean createUser(User user) {
		return userDao.create(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAll();
	}

	@Override
	public User getByUserId(Integer id) {
		return userDao.getById(id);
	}
	@Override
	public User updateUser(User user) {
		return userDao.update(user);
	}

	@Override
	public boolean deleteUser(Integer id) {
		return userDao.delete(id);
	}
}
