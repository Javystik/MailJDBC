package com.zoi4erom.mailjdbc.persistence.validator.impl.UserHandlerImpl;

import com.zoi4erom.mailjdbc.persistence.entity.User;
import com.zoi4erom.mailjdbc.persistence.validator.contracts.UserHandler;

public class FullNameHandler implements UserHandler {
	private UserHandler nextUserHandler;
	@Override
	public void validate(User user) {
		if(user.getFullName() == null){
			user.getValidationMessages().add("ПІБ не може бути пустим");
		}else if (user.getFullName().length() <= 10){
			user.getValidationMessages().add("ПІБ не може бути меншим ніж 10 символів");
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
