package com.sathya.jdbcpfex;

import java.sql.*;

public class TransactionEx {

	public static void main(String[] args) throws SQLException 
	{
		// TODO Auto-generated method stub
		Connection connection=null;
		Statement statement=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "nagamani", "nagamani");
			connection.setAutoCommit(false);
			statement=connection.createStatement();
			statement.executeUpdate("insert into emp values(1,nagamani,55000.09)");
			statement.executeUpdate("insert into emp values(2,'nikitha',55000.09)");
			statement.executeUpdate("insert into emp values(3,'santhi',55000.09)");
			statement.executeUpdate("delete from emp where empId=3");
			connection.commit();
			System.out.println("Commit Success");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println("Commit fail");
			connection.rollback();
			e.printStackTrace();
		}
	}

}
