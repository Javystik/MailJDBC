package com.zoi4erom.mailjdbc.domain.validator.impl.UserHandlerImpl;

import com.zoi4erom.mailjdbc.persistence.entity.User;
import com.zoi4erom.mailjdbc.domain.validator.contracts.UserHandler;

public class HomeAddressHandler implements UserHandler {
	private UserHandler nextUserHandler;
	@Override
	public void validate(User user) {
		if(user.getHomeAddress() == null){
			user.getValidationMessages().add("Домашня адреса не може бути пустою");
		}else if(user.getHomeAddress().length() < 5){
			user.getValidationMessages().add("Домашня адреса не може бути меншою ніж 5 символів");
		}
		if (nextUserHandler != null) {
			nextUserHandler.validate(user);
		}
	}

	@Override
	public void setNextHandler(UserHandler userHandler) {
		nextUserHandler = userHandler;
	}
}
