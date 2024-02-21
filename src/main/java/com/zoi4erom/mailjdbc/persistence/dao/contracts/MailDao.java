package com.zoi4erom.mailjdbc.persistence.dao.contracts;

import com.zoi4erom.mailjdbc.persistence.dao.Dao;
import com.zoi4erom.mailjdbc.persistence.entity.Mail;
import java.util.List;

public interface MailDao extends Dao<Integer, Mail> {

	@Override
	boolean create(Mail mail);

	@Override
	List<Mail> getAll();

	@Override
	Mail getById(Integer id);

	@Override
	Mail update(Mail mail);

	@Override
	boolean delete(Integer id);
}
