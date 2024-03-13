package com.zoi4erom.mailjdbc.persistence.validator.contracts;

import com.zoi4erom.mailjdbc.persistence.entity.User;
import com.zoi4erom.mailjdbc.persistence.validator.Handler;

public interface UserHandler extends Handler<User, UserHandler> {

	@Override
	void validate(User user);

	@Override
	void setNextHandler(UserHandler userHandler);
}
