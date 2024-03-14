package com.zoi4erom.mailjdbc.domain.validator.impl.ParselTypeHandlerImpl;

import com.zoi4erom.mailjdbc.persistence.entity.ParselType;
import com.zoi4erom.mailjdbc.domain.validator.contracts.ParselTypeHandler;

public class NameHandler implements ParselTypeHandler {
	private ParselTypeHandler nextParselTypeHandler;
	@Override
	public void validate(ParselType parselType) {
		if(parselType.getName() == null){
			parselType.getValidationMessages().add("Поле з назвою типу посилки не може бути пустим");
		}else if(parselType.getName().length() <= 4 || parselType.getName().length() >= 50){
			parselType.getValidationMessages().add("Поле з назвою типу посилки не може бути "
			    + "меншим за 4 символа та більше 50 символів");
		}
		if (nextParselTypeHandler != null) {
			nextParselTypeHandler.validate(parselType);
		}
	}

	@Override
	public void setNextHandler(ParselTypeHandler parselTypeHandler) {
		nextParselTypeHandler = parselTypeHandler;
	}
}
