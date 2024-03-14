package com.zoi4erom.mailjdbc.domain.validator.impl.UserHandlerImpl;

import com.zoi4erom.mailjdbc.persistence.entity.User;
import com.zoi4erom.mailjdbc.domain.validator.contracts.UserHandler;

public class PasswordHandler implements UserHandler{
	private UserHandler nextUserHandler;

	@Override
	public void validate(User user) {
		if(user.getPassword() == null){
			user.getValidationMessages().add("Пароль не може бути пустим");
		}else if (user.getPassword().length() <= 4 || user.getPassword().length() >= 24){
			user.getValidationMessages().add("Пароль не може бути меншим ніж 4 символа, "
			    + "та більший ніж 24");
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
