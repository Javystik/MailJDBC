package com.zoi4erom.mailjdbc.persistence.dao.impl;

import com.zoi4erom.mailjdbc.persistence.dao.contracts.ParselDao;
import com.zoi4erom.mailjdbc.persistence.entity.Parsel;
import com.zoi4erom.mailjdbc.persistence.exception.TableOperationException;
import com.zoi4erom.mailjdbc.persistence.util.ConnectionManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParselDaoImpl implements ParselDao {
	private static final String createParselSql = """
      		INSERT INTO PARSEL(mailid, name, parseltypeid, senderuserid, recipientuserid)
      		VALUES (?,?,?,?,?);
		    """;
	private static final String getAllParselsSql = """
      		SELECT * FROM PARSEL;
		    """;
	private static final String getAllParselByIdSql = """
      		SELECT * FROM PARSEL
      		WHERE ID = ?;
		    """;
	private static final String updateParselSql = """
			UPDATE PARSEL
			SET
				MAILID = ?,
				NAME = ?,
				PARSELTYPEID = ?,
				SENDERUSERID = ?,
				RECIPIENTUSERID = ?
			WHERE id = ?
		    """;
	private static final String deleteParselSql = """
      			DELETE FROM PARSEL
      			WHERE id = ?
		    """;

	private ParselDaoImpl() {
	}

	@Override
	public boolean create(Parsel parsel) {
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(createParselSql)) {
			preparedStatement.setInt(1, parsel.getMailId());
			preparedStatement.setString(2, parsel.getName());
			preparedStatement.setInt(3, parsel.getParselTypeId());
			preparedStatement.setInt(4, parsel.getSenderUserId());
			preparedStatement.setInt(5, parsel.getRecipientUserId());

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new TableOperationException("Помилка при роботі з операцією create в таблиці parsel: " + e);
		}
	}

	@Override
	public List<Parsel> getAll() {
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(getAllParselsSql)) {
			var resultSet = preparedStatement.executeQuery();

			List<Parsel> parsels = new ArrayList<>();

			while (resultSet.next()){
				int parselId = resultSet.getInt("id");
				int mailId = resultSet.getInt("MAILID");
				String name = resultSet.getString("NAME");
				int parselTypeId = resultSet.getInt("PARSELTYPEID");
				int senderUserId = resultSet.getInt("SENDERUSERID");
				int recipientUserId = resultSet.getInt("RECIPIENTUSERID");
				Parsel parsel = Parsel.builder()
				    .id(parselId)
				    .mailId(mailId)
				    .name(name)
				    .parselTypeId(parselTypeId)
				    .senderUserId(senderUserId)
				    .recipientUserId(recipientUserId)
				    .build();
				parsels.add(parsel);
			}
			return parsels;
		} catch (SQLException e) {
			throw new TableOperationException("Помилка при роботі з операцією getAll в таблиці parsel: " + e);
		}
	}
	@Override
	public Parsel getById(Integer id) {
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(getAllParselByIdSql)) {
			preparedStatement.setInt(1, id);
			var resultSet = preparedStatement.executeQuery();

			Parsel parsel = null;
			while (resultSet.next()){
				int parselId = resultSet.getInt("id");
				int mailId = resultSet.getInt("MAILID");
				String name = resultSet.getString("NAME");
				int parselTypeId = resultSet.getInt("PARSELTYPEID");
				int senderUserId = resultSet.getInt("SENDERUSERID");
				int recipientUserId = resultSet.getInt("RECIPIENTUSERID");

				parsel = Parsel.builder()
				    .id(parselId)
				    .mailId(mailId)
				    .name(name)
				    .parselTypeId(parselTypeId)
				    .senderUserId(senderUserId)
				    .recipientUserId(recipientUserId)
				    .build();
			}
			return parsel;
		} catch (SQLException e) {
			throw new TableOperationException("Помилка при роботі з операцією getById в таблиці parsel: " + e);
		}
	}

	@Override
	public Parsel update(Parsel parsel) {
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(updateParselSql)) {
			preparedStatement.setInt(1, parsel.getMailId());
			preparedStatement.setString(2, parsel.getName());
			preparedStatement.setInt(3, parsel.getParselTypeId());
			preparedStatement.setInt(4, parsel.getSenderUserId());
			preparedStatement.setInt(5, parsel.getRecipientUserId());
			preparedStatement.setInt(6, parsel.getId());

			preparedStatement.executeUpdate();

			return parsel;

		} catch (SQLException e) {
			throw new TableOperationException("Помилка при роботі з операцією update в таблиці parsel: " + e);
		}
	}

	@Override
	public boolean delete(Integer id) {
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(deleteParselSql)) {
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new TableOperationException("Помилка при роботі з операцією delete в таблиці parsel: " + e);
		}
	}
	private static class ParselDaoImplHolder{
		public static final ParselDaoImpl PARSEL_DAO_INSTANCE = new ParselDaoImpl();
	}
	public static ParselDaoImpl getInstance(){
		return ParselDaoImplHolder.PARSEL_DAO_INSTANCE;
	}
}
