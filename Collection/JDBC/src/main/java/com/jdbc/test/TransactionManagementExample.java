package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class TransactionManagementExample {
	
	final static Logger logger = Logger.getLogger(JDBCPreparedStatementEmployee.class);

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://10.242.133.153:3306/test";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	public static void main(String[] argv) throws SQLException {
		Connection dbConnection = null;
	try{
		
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}
		dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
		//Assume a valid connection object conn
		dbConnection.setAutoCommit(false);
		   Statement stmt = dbConnection.createStatement();
		   
		   String SQL = "INSERT INTO PRODUCTS (productID,productCode,name,quantity,price) VALUES (11,'PEN','PEN BLACK',23,24 )";
		   stmt.executeUpdate(SQL);  
		   //Submit a malformed SQL statement that breaks
		   String SQLTest = "INSERTED INTO PRODUCTS (productID,productCode,name,quantity,price) VALUES (19,34,'xxx',23,24 )";
		   stmt.executeUpdate(SQLTest);
		   // If there is no error.
		   dbConnection.commit();

		
	}
	catch(SQLException se){
		se.printStackTrace();
		dbConnection.rollback();
		
	}

	}
}
