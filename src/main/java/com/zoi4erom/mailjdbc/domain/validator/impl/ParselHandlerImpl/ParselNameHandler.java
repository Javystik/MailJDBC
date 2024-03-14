package com.zoi4erom.mailjdbc.domain.validator.impl.ParselHandlerImpl;

import com.zoi4erom.mailjdbc.persistence.entity.Parsel;
import com.zoi4erom.mailjdbc.domain.validator.contracts.ParselHandler;

public class ParselNameHandler implements ParselHandler {
	private ParselHandler nextParselHandler;
	@Override
	public void validate(Parsel parsel) {
		if(parsel.getName() == null){
			parsel.getValidationMessages().add("Назва посилки не може бути пустим");
		}else if (parsel.getName().length() <= 4 || parsel.getName().length() >= 50){
			parsel.getValidationMessages().add("Назва посилки не може бути меншою за 4 символа "
			    + "та більше за 50 символів");
		}
		if (nextParselHandler != null) {
			nextParselHandler.validate(parsel);
		}
	}

	@Override
	public void setNextHandler(ParselHandler parselHandler) {
		nextParselHandler = parselHandler;
	}
}
