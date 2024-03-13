package com.zoi4erom.mailjdbc.persistence.validator.contracts;

import com.zoi4erom.mailjdbc.persistence.entity.ParselType;
import com.zoi4erom.mailjdbc.persistence.validator.Handler;

public interface ParselTypeHandler extends Handler<ParselType, ParselTypeHandler> {

	@Override
	void validate(ParselType parselType);

	@Override
	void setNextHandler(ParselTypeHandler parselTypeHandler);
}
