package com.zoi4erom.mailjdbc.persistence.dao.impl;

import com.zoi4erom.mailjdbc.persistence.dao.contracts.ParselDao;
import com.zoi4erom.mailjdbc.persistence.entity.Parsel;
import com.zoi4erom.mailjdbc.persistence.entity.ParselType;
import com.zoi4erom.mailjdbc.persistence.util.ConnectionManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParselDaoImpl implements ParselDao {

	@Override
	public boolean create(Parsel parsel) {
		String createParselSql = """
      		INSERT INTO PARSEL(mailid, name, parseltypeid, senderuserid, recipientuserid)
      		VALUES (?,?,?,?,?);
		    """;
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
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Parsel> getAll() {
		String getAllParselsSql = """
      		SELECT * FROM PARSEL;
		    """;
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(getAllParselsSql)) {
			var resultSet = preparedStatement.executeQuery();

			List<Parsel> parsels = new ArrayList<>();

			while (resultSet.next()){
				int id = resultSet.getInt("id");
				int mailId = resultSet.getInt("MAILID");
				String name = resultSet.getString("NAME");
				int parselTypeId = resultSet.getInt("PARSELTYPEID");
				int senderUserId = resultSet.getInt("SENDERUSERID");
				int recipientUserId = resultSet.getInt("RECIPIENTUSERID");
				parsels.add(new Parsel(id, mailId, name, parselTypeId, senderUserId, recipientUserId));
			}
			return parsels;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public Parsel getById(Integer id) {
		String getAllParselByIdSql = """
      		SELECT * FROM PARSEL
      		WHERE ID = ?;
		    """;
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
				parsel = new Parsel(parselId, mailId, name, parselTypeId, senderUserId, recipientUserId);
			}
			return parsel;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Parsel update(Parsel parsel) {
		String updateParselSql = """
			UPDATE PARSEL
			SET
				MAILID = ?,
				NAME = ?,
				PARSELTYPEID = ?,
				SENDERUSERID = ?,
				RECIPIENTUSERID = ?
			WHERE id = ?
		    """;

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
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean delete(Integer id) {
		String deleteParselSql = """
      			DELETE FROM PARSEL
      			WHERE id = ?
		    """;

		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(deleteParselSql)) {
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
