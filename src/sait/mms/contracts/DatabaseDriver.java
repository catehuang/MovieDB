package sait.mms.contracts;

import java.sql.*;

public interface DatabaseDriver {
	void connect() throws SQLException;
	
	/**
	 * Performs a retrieval from the database
	 * @param query Query sent to be executed
	 * @return Return the result as result set 
	 * @throws SQLException Thrown if a problem happens
	 */
	ResultSet get(String query)  throws SQLException;
	
	int update(String query) throws SQLException;
	
	void disconnect() throws SQLException;
}
