package com.zoi4erom.mailjdbc.persistence.dao.impl;

import com.zoi4erom.mailjdbc.persistence.dao.contracts.MailDao;
import com.zoi4erom.mailjdbc.persistence.entity.Mail;
import com.zoi4erom.mailjdbc.persistence.exception.TableOperationException;
import com.zoi4erom.mailjdbc.persistence.util.ConnectionManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MailDaoImpl implements MailDao{
	private static final String createMailSql = """
      		INSERT INTO MAIL(mailname, address, phonenumber)
      		VALUES (?,?,?);
		    """;
	private static final String getAllMail = """
      		SELECT * FROM MAIL;
		    """;

	private static final String getAllMailByIdSql = """
      		SELECT * FROM MAIL
      		WHERE ID = ?;
		    """;
	private static final String updateMailSql = """
			UPDATE MAIL
			SET
				MAILNAME = ?,
				ADDRESS = ?,
				PHONENUMBER = ?
			WHERE id = ?
		    """;
	private static final String deleteMailSql = """
      			DELETE FROM MAIL 
      			WHERE id = ?
		    """;
	private MailDaoImpl() {
	}
	@Override
	public boolean create(Mail mail) {
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(createMailSql)) {
			preparedStatement.setString(1, mail.getMailName());
			preparedStatement.setString(2, mail.getAddress());
			preparedStatement.setString(3, mail.getPhoneNumber());

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new TableOperationException("Помилка при роботі з операцією create в таблиці mail: " + e);
		}
	}

	@Override
	public List<Mail> getAll() {
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(getAllMail)) {
			var resultSet = preparedStatement.executeQuery();

			List<Mail> mails = new ArrayList<>();

			while (resultSet.next()){
				int mailId = resultSet.getInt("ID");
				String mailName = resultSet.getString("MAILNAME");
				String address = resultSet.getString("ADDRESS");
				String phoneNumber = resultSet.getString("PHONENUMBER");
				Mail mail = Mail.builder()
				    .id(mailId)
				    .mailName(mailName)
				    .address(address)
				    .phoneNumber(phoneNumber)
				    .build();


				mails.add(mail);
			}
			return mails;
		} catch (SQLException e) {
			throw new TableOperationException("Помилка при роботі з операцією getAll в таблиці mail: " + e);
		}
	}

	@Override
	public Mail getById(Integer id) {
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(getAllMailByIdSql)) {
			preparedStatement.setInt(1, id);
			var resultSet = preparedStatement.executeQuery();

			Mail mail = null;
			while (resultSet.next()){
				int mailId = resultSet.getInt("ID");
				String mailName = resultSet.getString("MAILNAME");
				String address = resultSet.getString("ADDRESS");
				String phoneNumber = resultSet.getString("PHONENUMBER");
				mail = Mail.builder()
				    .id(mailId)
				    .mailName(mailName)
				    .address(address)
				    .phoneNumber(phoneNumber)
				    .build();
			}
			return mail;
		} catch (SQLException e) {
			throw new TableOperationException("Помилка при роботі з операцією getById в таблиці mail: " + e);
		}
	}

	@Override
	public Mail update(Mail mail) {
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(updateMailSql)) {
			preparedStatement.setString(1, mail.getMailName());
			preparedStatement.setString(2, mail.getAddress());
			preparedStatement.setString(3, mail.getPhoneNumber());
			preparedStatement.setInt(4, mail.getId());

			preparedStatement.executeUpdate();

			return mail;

		} catch (SQLException e) {
			throw new TableOperationException("Помилка при роботі з операцією update в таблиці mail: " + e);
		}
	}

	@Override
	public boolean delete(Integer id) {
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(deleteMailSql)) {
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new TableOperationException("Помилка при роботі з операцією delete в таблиці mail: " + e);		}
	}
	private static class MailDaoImplHolder{
		public static final MailDaoImpl MAIL_DAO_INSTANCE = new MailDaoImpl();
	}
	public static MailDaoImpl getInstance(){
		return MailDaoImplHolder.MAIL_DAO_INSTANCE;
	}
}
