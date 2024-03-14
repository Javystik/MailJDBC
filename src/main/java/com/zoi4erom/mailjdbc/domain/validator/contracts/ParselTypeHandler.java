package com.zoi4erom.mailjdbc.domain.validator.contracts;

import com.zoi4erom.mailjdbc.persistence.entity.ParselType;
import com.zoi4erom.mailjdbc.domain.validator.Handler;

public interface ParselTypeHandler extends Handler<ParselType, ParselTypeHandler> {

	@Override
	void validate(ParselType parselType);

	@Override
	void setNextHandler(ParselTypeHandler parselTypeHandler);
}
