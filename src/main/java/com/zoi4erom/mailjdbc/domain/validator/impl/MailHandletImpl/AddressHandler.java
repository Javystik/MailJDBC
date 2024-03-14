package com.zoi4erom.mailjdbc.domain.validator.impl.MailHandletImpl;

import com.zoi4erom.mailjdbc.persistence.entity.Mail;
import com.zoi4erom.mailjdbc.domain.validator.contracts.MailHandler;

public class AddressHandler implements MailHandler{
	private MailHandler nextMailHandler;
	@Override
	public void validate(Mail mail) {
		if (mail.getAddress() == null){
			mail.getValidationMessages().add("Адреса пошти не може бути порожньою");
		}else if (mail.getAddress().length() <= 5){
			mail.getValidationMessages().add("Адреса пошти не може бути меншою за 5");
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
