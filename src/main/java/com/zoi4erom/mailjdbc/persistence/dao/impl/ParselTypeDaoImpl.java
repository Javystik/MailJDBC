package com.zoi4erom.mailjdbc.persistence.dao.impl;

import com.zoi4erom.mailjdbc.persistence.dao.contracts.ParselTypeDao;
import com.zoi4erom.mailjdbc.persistence.entity.ParselType;
import com.zoi4erom.mailjdbc.persistence.util.ConnectionManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParselTypeDaoImpl implements ParselTypeDao{

	@Override
	public boolean create(ParselType parselType) {
		String createParselTypeSql = """
      		INSERT INTO PARSEL_TYPE(NAME, DESCRIPTION)
      		VALUES (?,?);
		    """;
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(createParselTypeSql)) {
			preparedStatement.setString(1, parselType.getName());
			preparedStatement.setString(2, parselType.getDescription());

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ParselType> getAll() {
		String getAllParselType = """
      		SELECT * FROM PARSEL_TYPE;
		    """;
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(getAllParselType)) {
			var resultSet = preparedStatement.executeQuery();

			List<ParselType> parselTypes = new ArrayList<>();

			while (resultSet.next()){
				int id = resultSet.getInt("ID");
				String name = resultSet.getString("NAME");
				String description = resultSet.getString("DESCRIPTION");
				parselTypes.add(new ParselType(id, name, description));
			}
			return parselTypes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ParselType getById(Integer id) {
		String getAllParselTypeByIdSql = """
      		SELECT * FROM PARSEL_TYPE
      		WHERE ID = ?;
		    """;
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(getAllParselTypeByIdSql)) {
			preparedStatement.setInt(1, id);
			var resultSet = preparedStatement.executeQuery();

			ParselType parselType = null;
			while (resultSet.next()){
				int parselTypeId = resultSet.getInt("ID");
				String name = resultSet.getString("NAME");
				String description = resultSet.getString("DESCRIPTION");
				parselType = new ParselType(parselTypeId, name, description);
			}
			return parselType;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ParselType update(ParselType parselType) {
		String updateParselTypeSql = """
			UPDATE PARSEL_TYPE
			SET
				NAME = ?,
				DESCRIPTION = ?
			WHERE id = ?
		    """;

		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(updateParselTypeSql)) {
			preparedStatement.setString(1, parselType.getName());
			preparedStatement.setString(2, parselType.getDescription());
			preparedStatement.setInt(3, parselType.getId());


			preparedStatement.executeUpdate();

			return parselType;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean delete(Integer id) {
		String deleteParselTypeSql = """
      			DELETE FROM PARSEL_TYPE 
      			WHERE id = ?
		    """;

		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(deleteParselTypeSql)) {
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
