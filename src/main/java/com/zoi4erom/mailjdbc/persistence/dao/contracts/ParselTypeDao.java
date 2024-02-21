package com.zoi4erom.mailjdbc.persistence.dao.contracts;

import com.zoi4erom.mailjdbc.persistence.dao.Dao;
import com.zoi4erom.mailjdbc.persistence.entity.ParselType;
import java.util.List;

public interface ParselTypeDao extends Dao<Integer, ParselType> {

	@Override
	boolean create(ParselType parselType);

	@Override
	List<ParselType> getAll();

	@Override
	ParselType getById(Integer id);

	@Override
	ParselType update(ParselType parselType);

	@Override
	boolean delete(Integer id);
}
