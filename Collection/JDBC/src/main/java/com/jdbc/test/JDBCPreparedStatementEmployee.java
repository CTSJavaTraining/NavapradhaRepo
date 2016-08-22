package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * @author 523696 class to connect to the MySQL database and perform queries,
 *         inserts and deletes
 */

public class JDBCPreparedStatementEmployee {

	final static Logger logger = Logger.getLogger(JDBCPreparedStatementEmployee.class);

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://10.242.133.153:3306/test";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	public static void main(String[] argv) {

		try {

			selectProducts();
			updateProducts();
			removeProducts();
			insertProducts();

		} catch (SQLException e) {

			logger.debug(e.getMessage());

		}

	}

	/**
	 * Method to fetch the products using select query
	 */
	private static void selectProducts() throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT * FROM PRODUCTS WHERE productID = ?";

		try {
			dbConnection = getDBConnection();
			// Statements allow to issue SQL queries to the database
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, 1);

			// execute select SQL statement
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				String productId = rs.getString("productID");
				String productCode = rs.getString("productCode");

				logger.debug("productid : " + productId);
				logger.debug("productname : " + productCode);

			}

		} catch (SQLException e) {

			logger.debug(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	/**
	 * Method to update the products based on the product id
	 */
	private static void updateProducts() throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "UPDATE PRODUCTS SET NAME = 'xxx' WHERE productID = ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, 1);

			// execute select SQL stetement
			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			logger.debug(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	/**
	 * Method to delete the products based on the product id
	 */
	private static void removeProducts() throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "DELETE FROM PRODUCTS WHERE productID = ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, 1);

			// execute select SQL stetement
			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			logger.debug(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	/**
	 * Method to insert the products
	 */
	private static void insertProducts() throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "INSERT INTO PRODUCTS (productID,productCode,name,quantity,price) VALUES (?,?,?,?,? )";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, "PEN");
			preparedStatement.setString(3, "Pen Blue");
			preparedStatement.setInt(4, 8000);
			preparedStatement.setDouble(5, 1.25);

			// execute select SQL stetement
			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			logger.debug(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	/**
	 * Method to create connection with MYSQL
	 */
	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			logger.debug(e.getMessage());

		}

		try {

			// Setup the connection with the DB

			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			logger.debug(e.getMessage());

		}

		return dbConnection;

	}

}
