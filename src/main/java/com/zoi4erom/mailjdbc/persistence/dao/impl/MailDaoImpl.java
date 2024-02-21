package com.zoi4erom.mailjdbc.persistence.dao.impl;

import com.zoi4erom.mailjdbc.persistence.dao.contracts.MailDao;
import com.zoi4erom.mailjdbc.persistence.entity.Mail;
import com.zoi4erom.mailjdbc.persistence.util.ConnectionManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MailDaoImpl implements MailDao{

	@Override
	public boolean create(Mail mail) {
		String createMailSql = """
      		INSERT INTO MAIL(mailname, address, phonenumber)
      		VALUES (?,?,?);
		    """;
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(createMailSql)) {
			preparedStatement.setString(1, mail.getMailName());
			preparedStatement.setString(2, mail.getAddress());
			preparedStatement.setString(3, mail.getPhoneNumber());

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Mail> getAll() {
		String getAllMail = """
      		SELECT * FROM MAIL;
		    """;
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(getAllMail)) {
			var resultSet = preparedStatement.executeQuery();

			List<Mail> mails = new ArrayList<>();

			while (resultSet.next()){
				int id = resultSet.getInt("ID");
				String mailName = resultSet.getString("MAILNAME");
				String address = resultSet.getString("ADDRESS");
				String phoneNumber = resultSet.getString("PHONENUMBER");
				mails.add(new Mail(id, mailName, address, phoneNumber));
			}
			return mails;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Mail getById(Integer id) {
		String getAllMailByIdSql = """
      		SELECT * FROM MAIL
      		WHERE ID = ?;
		    """;
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
				mail = new Mail(mailId, mailName, address, phoneNumber);
			}
			return mail;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Mail update(Mail mail) {
		String updateMailSql = """
			UPDATE MAIL
			SET
				MAILNAME = ?,
				ADDRESS = ?,
				PHONENUMBER = ?
			WHERE id = ?
		    """;

		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(updateMailSql)) {
			preparedStatement.setString(1, mail.getMailName());
			preparedStatement.setString(2, mail.getAddress());
			preparedStatement.setString(3, mail.getPhoneNumber());
			preparedStatement.setInt(4, mail.getId());

			preparedStatement.executeUpdate();

			return mail;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean delete(Integer id) {
		String deleteMailSql = """
      			DELETE FROM MAIL 
      			WHERE id = ?
		    """;

		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(deleteMailSql)) {
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
