package com.zoi4erom.mailjdbc.domain.validator.contracts;

import com.zoi4erom.mailjdbc.persistence.entity.Parsel;
import com.zoi4erom.mailjdbc.domain.validator.Handler;

public interface ParselHandler extends Handler<Parsel, ParselHandler> {

	@Override
	void validate(Parsel parsel);

	@Override
	void setNextHandler(ParselHandler parselHandler);
}
