package com.zoi4erom.mailjdbc.persistence.dao.contracts;

import com.zoi4erom.mailjdbc.persistence.dao.Dao;
import com.zoi4erom.mailjdbc.persistence.entity.Parsel;
import java.util.List;

public interface ParselDao extends Dao<Integer, Parsel> {

	@Override
	boolean create(Parsel parsel);

	@Override
	List<Parsel> getAll();

	@Override
	Parsel getById(Integer id);

	@Override
	Parsel update(Parsel parsel);

	@Override
	boolean delete(Integer id);
}
