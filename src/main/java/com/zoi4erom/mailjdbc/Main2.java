package com.zoi4erom.mailjdbc;

import com.zoi4erom.mailjdbc.persistence.entity.Mail;
import com.zoi4erom.mailjdbc.persistence.entity.Parsel;
import com.zoi4erom.mailjdbc.persistence.entity.ParselType;
import com.zoi4erom.mailjdbc.persistence.entity.User;
import com.zoi4erom.mailjdbc.persistence.validator.contracts.MailHandler;
import com.zoi4erom.mailjdbc.persistence.validator.contracts.ParselHandler;
import com.zoi4erom.mailjdbc.persistence.validator.contracts.ParselTypeHandler;
import com.zoi4erom.mailjdbc.persistence.validator.contracts.UserHandler;
import com.zoi4erom.mailjdbc.persistence.validator.impl.MailHandletImpl.AddressHandler;
import com.zoi4erom.mailjdbc.persistence.validator.impl.MailHandletImpl.MailNameHandler;
import com.zoi4erom.mailjdbc.persistence.validator.impl.MailHandletImpl.PhoneNumberHandler;
import com.zoi4erom.mailjdbc.persistence.validator.impl.ParselHandlerImpl.ParselNameHandler;
import com.zoi4erom.mailjdbc.persistence.validator.impl.ParselTypeHandlerImpl.DescriptionHandler;
import com.zoi4erom.mailjdbc.persistence.validator.impl.ParselTypeHandlerImpl.NameHandler;
import com.zoi4erom.mailjdbc.persistence.validator.impl.UserHandlerImpl.FullNameHandler;
import com.zoi4erom.mailjdbc.persistence.validator.impl.UserHandlerImpl.HomeAddressHandler;
import com.zoi4erom.mailjdbc.persistence.validator.impl.UserHandlerImpl.PasswordHandler;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {
		//mailValidateTest();
		//userValidateTest();
		//parsetlTypeValidateTest();
		parselValidate();
	}
	private static void parselValidate() {
		ParselHandler nameHandler = new ParselNameHandler();

		Parsel parsel = Parsel.builder()
		    .id(1)
		    .name("Te")
		    .mailId(1)
		    .mailId(1)
		    .recipientUserId(1)
		    .senderUserId(1)
		    .build();

		nameHandler.validate(parsel);

		printValidationMessagesIfAny(parsel.getValidationMessages());
	}
	private static void parsetlTypeValidateTest() {
		ParselTypeHandler nameHandler = new NameHandler();
		ParselTypeHandler description = new DescriptionHandler();

		nameHandler.setNextHandler(description);

		ParselType parselType = ParselType.builder()
		    .id(1)
		    .name("Te")
		    .description("123")
		    .build();

		nameHandler.validate(parselType);

		printValidationMessagesIfAny(parselType.getValidationMessages());
	}
	private static void mailValidateTest() {
		MailHandler mailNameHandler = new MailNameHandler();
		MailHandler addressHandler = new AddressHandler();
		MailHandler phoneNumberHandler = new PhoneNumberHandler();

		mailNameHandler.setNextHandler(addressHandler);
		addressHandler.setNextHandler(phoneNumberHandler);

		Mail mail = Mail.builder()
		    .id(1)
		    .mailName("Test Mail2222")
		    .address("Test address22")
		    .phoneNumber("+380000000")
		    .build();

		mailNameHandler.validate(mail);

		printValidationMessagesIfAny(mail.getValidationMessages());
	}
	private static void userValidateTest() {
		UserHandler fullNameHandler = new FullNameHandler();
		UserHandler homeAddressHandler = new HomeAddressHandler();
		UserHandler passwordHandler = new PasswordHandler();

		fullNameHandler.setNextHandler(homeAddressHandler);
		homeAddressHandler.setNextHandler(passwordHandler);

		User user = User.builder()
		    .id(1)
		    .fullName("Test User")
		    .password("12")
		    .homeAddress("")
		    .build();

		fullNameHandler.validate(user);

		printValidationMessagesIfAny(user.getValidationMessages());
	}

	public static void printValidationMessagesIfAny(List<String> validationMessages) {
		if (validationMessages != null && !validationMessages.isEmpty()) {
			System.out.println("Помилки: ");
			for (String validateMessage : validationMessages) {
				System.out.println("    - " + validateMessage);
			}
		} else {
			System.out.println("Успішне створення!");
		}
	}
}
