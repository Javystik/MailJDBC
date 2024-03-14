package com.zoi4erom.mailjdbc.domain.impl;

import com.zoi4erom.mailjdbc.domain.contracts.RegistrationService;
import com.zoi4erom.mailjdbc.domain.validator.contracts.UserHandler;
import com.zoi4erom.mailjdbc.domain.validator.impl.UserHandlerImpl.FullNameHandler;
import com.zoi4erom.mailjdbc.domain.validator.impl.UserHandlerImpl.HomeAddressHandler;
import com.zoi4erom.mailjdbc.domain.validator.impl.UserHandlerImpl.PasswordHandler;
import com.zoi4erom.mailjdbc.persistence.dao.impl.UserDaoImpl;
import com.zoi4erom.mailjdbc.persistence.entity.User;
import java.util.List;

public class RegistrationServiceImpl implements RegistrationService {
	private final UserDaoImpl userDao = UserDaoImpl.getInstance();

	private RegistrationServiceImpl() {
	}

	private static class RegistrationServiceImplHolder{
		private static final RegistrationServiceImpl REGISTRATION_SERVICE_HOLDER = new RegistrationServiceImpl();
	}
	public static RegistrationServiceImpl getInstance(){
		return RegistrationServiceImplHolder.REGISTRATION_SERVICE_HOLDER;
	}

	@Override
	public List<String> registerUser(String fullName, String password, String homeAddress) {
		User user = User.builder()
		    .fullName(fullName)
		    .homeAddress(password)
		    .password(homeAddress)
		    .build();

		UserHandler fullNameHandler = new FullNameHandler();
		UserHandler homeAddressHandler = new HomeAddressHandler();
		UserHandler passwordHandler = new PasswordHandler();

		fullNameHandler.setNextHandler(homeAddressHandler);
		homeAddressHandler.setNextHandler(passwordHandler);

		fullNameHandler.validate(user);

		if(user.getValidationMessages().isEmpty()){
			userDao.create(user);
		}
		return user.getValidationMessages();
	}
}
