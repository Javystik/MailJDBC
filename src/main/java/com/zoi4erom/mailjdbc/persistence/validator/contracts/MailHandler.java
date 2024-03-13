package com.zoi4erom.mailjdbc.persistence.validator.contracts;

import com.zoi4erom.mailjdbc.persistence.entity.Mail;
import com.zoi4erom.mailjdbc.persistence.validator.Handler;

public interface MailHandler extends Handler<Mail, MailHandler> {

	@Override
	void validate(Mail mail);

	@Override
	void setNextHandler(MailHandler mailHandler);
}
