package com.sathya.jdbcpfex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingEx {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "nagamani", "nagamani");
		
		Statement statement=connection.createStatement();
		statement.addBatch("create table stu(id number, name varchar2(20))");
		statement.addBatch("insert into stu values(111,'ratan')");
		statement.addBatch("insert into stu values(222,'sathya')");
		statement.addBatch("delete from stu where id in(111,222)");
		statement.addBatch("drop table stu");
		int[] res=statement.executeBatch();
		for(int r:res)
		{
			System.out.println(r);
		}
	}

}
