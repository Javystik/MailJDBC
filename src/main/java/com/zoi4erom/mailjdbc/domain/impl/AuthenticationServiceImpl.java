package com.zoi4erom.mailjdbc.domain.impl;

import com.zoi4erom.mailjdbc.domain.contracts.AuthenticationService;
import com.zoi4erom.mailjdbc.domain.contracts.UserService;
import com.zoi4erom.mailjdbc.persistence.entity.User;

public class AuthenticationServiceImpl implements AuthenticationService {
	private final UserService userService = UserServiceImpl.getInstance();

	private AuthenticationServiceImpl() {
	}
	private static class AuthenticationServiceImplHolder{
		private static final AuthenticationServiceImpl authenticationServiceImpl = new AuthenticationServiceImpl();
	}
	public static AuthenticationServiceImpl getInstance(){
		return AuthenticationServiceImplHolder.authenticationServiceImpl;
	}

	@Override
	public User authenticate(Integer id, String fullName, String password) {
		User user = userService.getByUserId(id);
		if (user != null) {
			if(user.getFullName().equals(fullName) && user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}
}