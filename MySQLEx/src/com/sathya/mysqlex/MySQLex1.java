package com.sathya.mysqlex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLex1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
				//step-1: load the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Loaded Successfully.....");
				
				//step-2 create the connection
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/sathya", "root", "root");
				System.out.println("Connected to Database Successfully....");
				
				//step-3 process the query
				Statement statement=connection.createStatement();
				String q="create table emp(empId number,empName varchar2(30),empSalary number)";
//				String q="drop table emp";
				int res=statement.executeUpdate(q);
				System.out.println("Table created Successfully...."+res);
//				System.out.println("Table dropped Successfully...."+res);
				
				//step-4 close the connection/resources
				connection.close();
				System.out.println("Connection closed Successfully....");

	}

}