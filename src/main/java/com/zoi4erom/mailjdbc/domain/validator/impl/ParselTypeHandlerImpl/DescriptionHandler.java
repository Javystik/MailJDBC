package com.zoi4erom.mailjdbc.domain.validator.impl.ParselTypeHandlerImpl;

import com.zoi4erom.mailjdbc.persistence.entity.ParselType;
import com.zoi4erom.mailjdbc.domain.validator.contracts.ParselTypeHandler;

public class DescriptionHandler implements ParselTypeHandler {
	private ParselTypeHandler nextParselTypeHandler;
	@Override
	public void validate(ParselType parselType) {
		if(parselType.getDescription() == null){
			parselType.getValidationMessages().add("Поле з описом типу посилки не може бути пустим");
		}else if(parselType.getDescription().length() <= 5 || parselType.getDescription().length() >= 100){
			parselType.getValidationMessages().add("Поле з розміром типу посилки не може "
			    + "бути меншим за 5 та більшим за 100");
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
