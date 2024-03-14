package com.zoi4erom.mailjdbc.domain.contracts;

import com.zoi4erom.mailjdbc.persistence.entity.User;
import java.util.List;

public interface UserService {
	boolean createUser(User user);
	List<User> getAllUsers();
	User getByUserId(Integer id);
	User updateUser(User user);
	boolean deleteUser(Integer id);
}
