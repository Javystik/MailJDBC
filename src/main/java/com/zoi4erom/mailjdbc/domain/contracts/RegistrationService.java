package com.zoi4erom.mailjdbc.domain.contracts;

import java.util.List;

public interface RegistrationService {
	List<String> registerUser(String fullName, String password, String homeAddress);
}
