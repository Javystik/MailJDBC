package com.zoi4erom.mailjdbc;

import com.zoi4erom.mailjdbc.persistence.dao.impl.MailDaoImpl;
import com.zoi4erom.mailjdbc.persistence.dao.impl.ParselDaoImpl;
import com.zoi4erom.mailjdbc.persistence.dao.impl.ParselTypeDaoImpl;
import com.zoi4erom.mailjdbc.persistence.dao.impl.UserDaoImpl;
import com.zoi4erom.mailjdbc.persistence.entity.Mail;
import com.zoi4erom.mailjdbc.persistence.entity.Parsel;
import com.zoi4erom.mailjdbc.persistence.entity.ParselType;
import com.zoi4erom.mailjdbc.persistence.entity.User;
import com.zoi4erom.mailjdbc.persistence.entity.User.UserBuilder;
import java.util.List;

public class Main {
	private static final UserDaoImpl userDao = UserDaoImpl.getInstance();
	private static final MailDaoImpl mailDao = MailDaoImpl.getInstance();
	private static final ParselTypeDaoImpl parselTypeDao = ParselTypeDaoImpl.getInstance();
	private static final ParselDaoImpl parselDao = ParselDaoImpl.getInstance();
	public static void main(String[] args){
//
//		createUser();
//
//		getALlUsers();

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
		Parsel parsel = Parsel.builder()
		    .mailId(1)
		    .name("Лист другу")
		    .parselTypeId(1)
		    .senderUserId(1)
		    .recipientUserId(2)
		    .build();
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
		ParselType parselType = ParselType.builder()
		    .name("Листи")
		    .description("Листочки всякі")
		    .build();
		parselTypeDao.create(parselType);
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
		Mail mail = Mail.builder()
		    .mailName("Розетка")
		    .address("Ромашкова 15")
		    .phoneNumber("+23123134124")
		    .build();
		mailDao.create(mail);
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
		User user = User.builder()
		    .fullname("Міроха")
		    .password("12345")
		    .homeAdress("Ромашково 12")
		    .build();
		userDao.create(user);
	}
}
