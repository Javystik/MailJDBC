package com.zoi4erom.mailjdbc.domain.validator.impl.MailHandletImpl;

import com.zoi4erom.mailjdbc.persistence.entity.Mail;
import com.zoi4erom.mailjdbc.domain.validator.contracts.MailHandler;

public class MailNameHandler implements MailHandler {
	private MailHandler nextMailHandler;
	@Override
	public void validate(Mail mail) {
		if (mail.getMailName() == null) {
			mail.getValidationMessages().add("Назва пошти не може бути пустою");
		} else if (mail.getMailName().length() <= 5) {
			mail.getValidationMessages().add("Назва пошти не може бути меншою за 5 символів");
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
