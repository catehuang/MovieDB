package sait.mms.drivers;

import java.sql.*;

import sait.mms.contracts.DatabaseDriver;

public class MariaDBDriver implements DatabaseDriver {
	private static final String SERVER = "localhost";
	private static final int PORT = 3306;
	private static final String DATABASE = "movies";
	private static final String USERNAME = "cprg251";
	private static final String PASSWORD = "password";
	
	private Connection connection = null;
	
	/**
	 * Connect to database
	 */
	@Override
	public void connect() throws SQLException {
		String dsn = this.getDsn();
		connection = DriverManager.getConnection(dsn);
	}

	/**
	 * Get Data source name
	 * @return
	 */
	private String getDsn() {
		final String DB_URL = String.format("jdbc:mariadb://%s:%d/%s?user=%s&password=%s", SERVER, PORT, DATABASE,
				USERNAME, PASSWORD);
		return DB_URL;
	}
	

	/**
	 * Execute query
	 */
	@Override
	public ResultSet get(String query) throws SQLException {
		Statement stmt = connection.createStatement();
		ResultSet results = stmt.executeQuery(query);
		return results;
	}

	/**
	 * Execute query for updating database
	 */
	@Override
	public int update(String query) throws SQLException {
		Statement stmt = connection.createStatement();
		int rows = stmt.executeUpdate(query);
		return rows;
	}

	/**
	 * Disconnect to database
	 */
	@Override
	public void disconnect() throws SQLException {
		if(connection != null && !connection.isClosed())
			connection.close();		
	}
}

