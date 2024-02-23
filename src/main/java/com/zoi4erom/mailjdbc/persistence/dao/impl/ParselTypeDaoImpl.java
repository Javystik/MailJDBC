package com.zoi4erom.mailjdbc.persistence.dao.impl;

import com.zoi4erom.mailjdbc.persistence.dao.contracts.ParselTypeDao;
import com.zoi4erom.mailjdbc.persistence.entity.ParselType;
import com.zoi4erom.mailjdbc.persistence.exception.TableOperationException;
import com.zoi4erom.mailjdbc.persistence.util.ConnectionManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParselTypeDaoImpl implements ParselTypeDao{
	private static final String createParselTypeSql = """
      		INSERT INTO PARSEL_TYPE(NAME, DESCRIPTION)
      		VALUES (?,?);
		    """;
	private static final String getAllParselType = """
      		SELECT * FROM PARSEL_TYPE;
		    """;
	private static final String getAllParselTypeByIdSql = """
      		SELECT * FROM PARSEL_TYPE
      		WHERE ID = ?;
		    """;
	private static final String updateParselTypeSql = """
			UPDATE PARSEL_TYPE
			SET
				NAME = ?,
				DESCRIPTION = ?
			WHERE id = ?
		    """;
	private static final String deleteParselTypeSql = """
      			DELETE FROM PARSEL_TYPE 
      			WHERE id = ?
		    """;

	private ParselTypeDaoImpl() {
	}

	@Override
	public boolean create(ParselType parselType) {
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(createParselTypeSql)) {
			preparedStatement.setString(1, parselType.getName());
			preparedStatement.setString(2, parselType.getDescription());

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new TableOperationException("Помилка при роботі з операцією create в таблиці parselType: " + e);
		}
	}

	@Override
	public List<ParselType> getAll() {
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(getAllParselType)) {
			var resultSet = preparedStatement.executeQuery();

			List<ParselType> parselTypes = new ArrayList<>();

			while (resultSet.next()){
				int parselTypeId = resultSet.getInt("ID");
				String name = resultSet.getString("NAME");
				String description = resultSet.getString("DESCRIPTION");

				ParselType parselType = ParselType.builder()
				    .id(parselTypeId)
				    .name(name)
				    .description(description)
				    .build();
				parselTypes.add(parselType);
			}
			return parselTypes;
		} catch (SQLException e) {
			throw new TableOperationException("Помилка при роботі з операцією getAll в таблиці parselType: " + e);
		}
	}

	@Override
	public ParselType getById(Integer id) {
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(getAllParselTypeByIdSql)) {
			preparedStatement.setInt(1, id);
			var resultSet = preparedStatement.executeQuery();

			ParselType parselType = null;
			while (resultSet.next()){
				int parselTypeId = resultSet.getInt("ID");
				String name = resultSet.getString("NAME");
				String description = resultSet.getString("DESCRIPTION");
				parselType = ParselType.builder()
				    .id(parselTypeId)
				    .name(name)
				    .description(description)
				    .build();
			}
			return parselType;
		} catch (SQLException e) {
			throw new TableOperationException("Помилка при роботі з операцією getById в таблиці parselType: " + e);
		}
	}

	@Override
	public ParselType update(ParselType parselType) {
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(updateParselTypeSql)) {
			preparedStatement.setString(1, parselType.getName());
			preparedStatement.setString(2, parselType.getDescription());
			preparedStatement.setInt(3, parselType.getId());


			preparedStatement.executeUpdate();

			return parselType;

		} catch (SQLException e) {
			throw new TableOperationException("Помилка при роботі з операцією update в таблиці parselType: " + e);
		}
	}

	@Override
	public boolean delete(Integer id) {
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(deleteParselTypeSql)) {
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new TableOperationException("Помилка при роботі з операцією delete в таблиці parselType: " + e);
		}
	}
	private static class ParselTypeDaoImplHolder{
		public static final ParselTypeDaoImpl PARSEL_TYPE_DAO_INSTANCE = new ParselTypeDaoImpl();
	}
	public static ParselTypeDaoImpl getInstance(){
		return ParselTypeDaoImplHolder.PARSEL_TYPE_DAO_INSTANCE;
	}
}
