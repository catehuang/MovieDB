package sait.mms.drivers;

import java.sql.*;

import sait.mms.contracts.DatabaseDriver;

public class MariaDBDriver implements DatabaseDriver {
	private static final String SERVER = "localhost";
	private static final int PORT = 3306;
	private static final String DATABASE = "movies";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123";
	
	private Connection connection = null;
	
	@Override
	public void connect() throws SQLException {
		String dsn = this.getDsn();
		connection = DriverManager.getConnection(dsn);
	}

	private String getDsn() {
		final String DB_URL = String.format("jdbc:mariadb://%s:%d/%s?user=%s&password=%s", SERVER, PORT, DATABASE,
				USERNAME, PASSWORD);
		return DB_URL;
	}

	@Override
	public ResultSet get(String query) throws SQLException {
		Statement stmt = connection.createStatement();
		ResultSet results = stmt.executeQuery(query);
		return results;
	}

	@Override
	public int update(String query) throws SQLException {
		Statement stmt = connection.createStatement();
		int rows = stmt.executeUpdate(query);
		return rows;
	}

	@Override
	public void disconnect() throws SQLException {
		if(connection != null && !connection.isClosed())
			connection.close();		
	}
}

