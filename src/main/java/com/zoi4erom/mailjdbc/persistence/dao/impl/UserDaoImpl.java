package com.zoi4erom.mailjdbc.persistence.dao.impl;

import com.zoi4erom.mailjdbc.persistence.dao.contracts.UserDao;
import com.zoi4erom.mailjdbc.persistence.entity.User;
import com.zoi4erom.mailjdbc.persistence.util.ConnectionManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
	@Override
	public boolean create(User user) {
		String createUserSql = """
      		INSERT INTO USERS(FULLNAME, PASSWORD, HOMEADDRESS)
      		VALUES (?,?,?);
		    """;
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(createUserSql)) {
			preparedStatement.setString(1, user.getFullname());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getHomeAdress());

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> getAll() {
		String getAllSql = """
      		SELECT * FROM USERS;
		    """;
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(getAllSql)) {
			var resultSet = preparedStatement.executeQuery();

			List<User> users = new ArrayList<>();

			while (resultSet.next()){
				int id = resultSet.getInt("ID");
				String fullname = resultSet.getString("FULLNAME");
				String password = resultSet.getString("PASSWORD");
				String homeAddress = resultSet.getString("HOMEADDRESS");
				users.add(new User(id, fullname, password, homeAddress));
			}
			return users;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public User getById(Integer id) {
		String getAllSqlById = """
      		SELECT * FROM USERS
      		WHERE ID = ?;
		    """;
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(getAllSqlById)) {
			preparedStatement.setInt(1, id);
			var resultSet = preparedStatement.executeQuery();

			User user = null;
			while (resultSet.next()){
				int userId = resultSet.getInt("ID");
				String fullname = resultSet.getString("FULLNAME");
				String password = resultSet.getString("PASSWORD");
				String homeAddress = resultSet.getString("HOMEADDRESS");
				user = new User(userId, fullname, password, homeAddress);
			}
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public User update(User user) {
		String updateSql = """
      	UPDATE USERS
      	SET FULLNAME = ?,
			PASSWORD = ?,
      		HOMEADDRESS = ?
      	WHERE id = ?
		    """;

		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(updateSql)) {
			preparedStatement.setString(1, user.getFullname());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getHomeAdress());
			preparedStatement.setInt(4, user.getId());

			preparedStatement.executeUpdate();

			return user;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean delete(Integer id) {
		String deleteSql = """
      			DELETE FROM USERS 
      			WHERE id = ?
		    """;

		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(deleteSql)) {
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
