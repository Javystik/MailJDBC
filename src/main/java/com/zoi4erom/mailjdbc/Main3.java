package com.zoi4erom.mailjdbc;

import static java.lang.System.*;

import com.zoi4erom.mailjdbc.domain.contracts.RegistrationService;
import com.zoi4erom.mailjdbc.domain.impl.AuthenticationServiceImpl;
import com.zoi4erom.mailjdbc.domain.impl.RegistrationServiceImpl;
import java.util.List;

public class Main3 {

	private static final AuthenticationServiceImpl authenticationService = AuthenticationServiceImpl.getInstance();
	private static final RegistrationService registrationService = RegistrationServiceImpl.getInstance();

	public static void main(String[] args) {
		//authenticationServiceTest();

		//registrationServiceTest();
	}

	private static void registrationServiceTest() {
		var validationMessage = registrationService.registerUser("Test111111111",
		    "123456789", "Тестова 12");
		if(validationMessage.isEmpty()){
			out.println("Успішна реєстрація вітаємо вас! ");
		}else{
			printValidationMessagesIfAny(validationMessage);
		}
	}

	private static void authenticationServiceTest() {
		var user = authenticationService.authenticate(14, "Test111111111", "Тестова 12");
		if(user != null){
			out.println("Успішна аутентифікація");
		}else {
			out.println("Помилка аутентифікації. Користувача за введеними даними не знайдено");
		}
	}

	public static void printValidationMessagesIfAny(List<String> validationMessages) {
		if (validationMessages != null && !validationMessages.isEmpty()) {
			out.println("Помилки: ");
			for (String validateMessage : validationMessages) {
				out.println("    - " + validateMessage);
			}
		}
	}
}
