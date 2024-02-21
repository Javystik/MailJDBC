package com.zoi4erom.mailjdbc;

import com.zoi4erom.mailjdbc.persistence.dao.impl.MailDaoImpl;
import com.zoi4erom.mailjdbc.persistence.dao.impl.ParselDaoImpl;
import com.zoi4erom.mailjdbc.persistence.dao.impl.ParselTypeDaoImpl;
import com.zoi4erom.mailjdbc.persistence.dao.impl.UserDaoImpl;
import com.zoi4erom.mailjdbc.persistence.entity.Mail;
import com.zoi4erom.mailjdbc.persistence.entity.Parsel;
import com.zoi4erom.mailjdbc.persistence.entity.ParselType;
import com.zoi4erom.mailjdbc.persistence.entity.User;
import java.util.List;

public class Main {
	private static final UserDaoImpl userDao = new UserDaoImpl();
	private static final MailDaoImpl mailDao = new MailDaoImpl();
	private static final ParselTypeDaoImpl parselTypeDao = new ParselTypeDaoImpl();
	private static final ParselDaoImpl parselDao = new ParselDaoImpl();
	public static void main(String[] args){
//
//		createUser();
//
		//getALlUsers();

//		getUserById(9);

		//updateUser(9);

		//deleteUser(9);

		/////////////////////////////////////////

		//createMail();
//
//		getAllMails();
//
//		getMailById(3);
//
//		updateMail(3);

//		deleteMail(3);

		///////////////////////////////////////////

//		createParselType();
////
//		getAllParselType();
//
//		getParselTypeById(1);
//
		//updateParselType();
//
//		deleteParselType(1);

		///////////////////////////////////////////////////
//
//		createParsel();
////
//		getAllParsels();
//
//		getParselById(2);
//
//		updateParsel(1);
//
//		deleteParsel(1);
	}

	private static void deleteParsel(Integer id) {
		parselDao.delete(id);
	}

	private static void updateParsel(Integer id) {
		Parsel parsel = getParselById(id);
		parsel.setName("2 лис");
		parselDao.update(parsel);
	}

	private static Parsel getParselById(Integer id) {
		Parsel parsel = parselDao.getById(id);
		System.out.println(parsel);
		return parsel;
	}

	private static void getAllParsels() {
		List<Parsel> parsel = parselDao.getAll();
		for (Parsel parsels: parsel){
			System.out.println(parsels);
		}
	}

	private static void createParsel() {
		Parsel parsel = new Parsel(1, "Лист другу", 1, 1, 2);
		parselDao.create(parsel);
	}

	private static void deleteParselType(Integer id) {
		parselTypeDao.delete(id);
	}

	private static void updateParselType() {
		ParselType parselType = getParselTypeById(1);
		System.out.println(parselType);
		parselType.setDescription("Нові всякі листочки");

		System.out.println(parselType);
		parselTypeDao.update(parselType);
	}

	private static ParselType getParselTypeById(Integer id) {
		ParselType parselType = parselTypeDao.getById(id);
		System.out.println(parselType);
		return parselType;
	}

	private static void getAllParselType() {
		List<ParselType> parselTypeList = parselTypeDao.getAll();
		for (ParselType parselType: parselTypeList){
			System.out.println(parselType);
		}
	}

	private static void createParselType() {
		parselTypeDao.create(new ParselType("Листи", "Листочки всякі"));
	}

	private static void deleteMail(Integer id) {
		mailDao.delete(id);
	}

	private static void updateMail(Integer id) {
		Mail mail = getMailById(id);
		System.out.println(mail);
		mail.setMailName("Нова пошта");

		System.out.println(mail);
		mailDao.update(mail);
	}

	private static Mail getMailById(Integer id) {
		Mail mail = mailDao.getById(id);
		System.out.println(mail);
		return mail;
	}

	private static void getAllMails() {
		List<Mail> mails = mailDao.getAll();
		for (Mail mail: mails){
			System.out.println(mail);
		}
	}

	private static void createMail() {
		mailDao.create(new Mail("Розетка", "Ромашкова 15", "+23123134124"));
	}

	private static void updateUser(Integer id){
		User user = getUserById(id);
		System.out.println(user);

		user.setFullname("Новий тест юзер");

		User updateUser = userDao.update(user);
		System.out.println(updateUser);
	}
	private static User getUserById(int id) {
		User user = userDao.getById(id);
		System.out.println(user);
		return user;
	}

	private static void deleteUser(int id) {
		userDao.delete(id);
	}

	private static void getALlUsers() {
		List<User> allUsers = userDao.getAll();

		for (User user: allUsers){
			System.out.println(user);
		}
	}

	private static void createUser() {
		User user = new User("Міроха", "12345", "Ромашково 12");
		userDao.create(user);
	}
}
