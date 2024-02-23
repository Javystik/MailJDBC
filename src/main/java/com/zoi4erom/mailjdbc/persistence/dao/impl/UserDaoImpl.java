package com.zoi4erom.mailjdbc.persistence.dao.impl;

import com.zoi4erom.mailjdbc.persistence.dao.contracts.UserDao;
import com.zoi4erom.mailjdbc.persistence.entity.User;
import com.zoi4erom.mailjdbc.persistence.exception.TableOperationException;
import com.zoi4erom.mailjdbc.persistence.util.ConnectionManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
	private static final String createUserSql = """
      		INSERT INTO USERS(FULLNAME, PASSWORD, HOMEADDRESS)
      		VALUES (?,?,?);
		    """;
	private static final String getAllSql = """
      		SELECT * FROM USERS;
		    """;
	private static final String getAllSqlById = """
      		SELECT * FROM USERS
      		WHERE ID = ?;
		    """;
	private static final String updateSql = """
      	UPDATE USERS
      	SET FULLNAME = ?,
			PASSWORD = ?,
      		HOMEADDRESS = ?
      	WHERE id = ?
		    """;
	private static final String deleteSql = """
      			DELETE FROM USERS 
      			WHERE id = ?
		    """;

	private UserDaoImpl() {
	}

	@Override
	public boolean create(User user) {
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(createUserSql)) {
			preparedStatement.setString(1, user.getFullname());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getHomeAdress());

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new TableOperationException("Помилка при роботі з операцією create в таблиці user: " + e);
		}
	}

	@Override
	public List<User> getAll() {
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(getAllSql)) {
			var resultSet = preparedStatement.executeQuery();

			List<User> users = new ArrayList<>();

			while (resultSet.next()){
				int userId = resultSet.getInt("ID");
				String fullname = resultSet.getString("FULLNAME");
				String password = resultSet.getString("PASSWORD");
				String homeAddress = resultSet.getString("HOMEADDRESS");

				User user = User.builder()
				    .id(userId)
				    .fullname(fullname)
				    .password(password)
				    .homeAdress(homeAddress)
				    .build();

				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			throw new TableOperationException("Помилка при роботі з операцією getAll в таблиці user: " + e);
		}
	}

	@Override
	public User getById(Integer id) {
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

				user = User.builder()
				    .id(userId)
				    .fullname(fullname)
				    .password(password)
				    .homeAdress(homeAddress)
				    .build();
			}
			return user;
		} catch (SQLException e) {
			throw new TableOperationException("Помилка при роботі з операцією getById в таблиці user: " + e);
		}
	}

	@Override
	public User update(User user) {
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(updateSql)) {
			preparedStatement.setString(1, user.getFullname());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getHomeAdress());
			preparedStatement.setInt(4, user.getId());

			preparedStatement.executeUpdate();

			return user;

		} catch (SQLException e) {
			throw new TableOperationException("Помилка при роботі з операцією update в таблиці user: " + e);
		}
	}

	@Override
	public boolean delete(Integer id) {
		try (var connection = ConnectionManager.getConnection();
		    var preparedStatement = connection.prepareStatement(deleteSql)) {
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new TableOperationException("Помилка при роботі з операцією delete в таблиці user: " + e);
		}
	}
	private static class UserDaoImplHolder{
		public static final UserDaoImpl USER_DAO_INSTANCE = new UserDaoImpl();
	}
	public static UserDaoImpl getInstance(){
		return UserDaoImplHolder.USER_DAO_INSTANCE;
	}
}
