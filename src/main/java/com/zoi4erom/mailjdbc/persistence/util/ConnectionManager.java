package com.zoi4erom.mailjdbc.persistence.util;

import com.zoi4erom.mailjdbc.persistence.util.PropertiesUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
	private static final String URL_KEY = "db.url";
	private ConnectionManager() {
	}
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(
			    PropertiesUtil.getProperty(URL_KEY)
			);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
