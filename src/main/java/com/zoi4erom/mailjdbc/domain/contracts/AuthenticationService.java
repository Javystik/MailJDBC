package com.zoi4erom.mailjdbc.domain.contracts;

import com.zoi4erom.mailjdbc.persistence.entity.User;

public interface AuthenticationService {
	User authenticate(Integer id, String username, String password);
}
