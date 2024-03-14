package com.zoi4erom.mailjdbc.domain.validator.impl.MailHandletImpl;

import com.zoi4erom.mailjdbc.persistence.entity.Mail;
import com.zoi4erom.mailjdbc.domain.validator.contracts.MailHandler;

public class PhoneNumberHandler implements MailHandler {
	private MailHandler nextMailHandler;
	@Override
	public void validate(Mail mail) {
		if (mail.getPhoneNumber() == null) {
			mail.getValidationMessages().add("Номер телефону не може бути порожнім");
		}else if (mail.getPhoneNumber().length() <= 5){
			mail.getValidationMessages().add("Номер телефону не може бути меншою за 5");
		}
		if (nextMailHandler != null) {
			nextMailHandler.validate(mail);
		}
	}

	@Override
	public void setNextHandler(MailHandler mailHandler) {
		nextMailHandler = mailHandler;
	}
}
