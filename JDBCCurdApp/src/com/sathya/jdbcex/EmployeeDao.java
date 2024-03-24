package com.sathya.jdbcex;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDao {
	public int save(Employee emp) 
	{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int count=0;
		try
		{
			connection=DbConnection.createConnection();
			preparedStatement=connection.prepareStatement("insert into emp values(?,?,?)");
			preparedStatement.setInt(1,emp.getEmpId());
			preparedStatement.setString(2,emp.getEmpName());
			preparedStatement.setDouble(3,emp.getEmpSalary());
			count=preparedStatement.executeUpdate();
		}
		catch(SQLException s)
		{
			s.printStackTrace();
		}
		finally
		{
			try
			{
				if(connection!=null)
					connection.close();
				if(preparedStatement!=null)
					preparedStatement.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return count;
	}
	public Employee findById(int empId)
	{
		Employee employee=null;
		try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("select * from emp where empId=?"))
		{
			preparedStatement.setInt(1, empId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				employee =new Employee();
				employee.setEmpId(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEmpSalary(resultSet.getDouble(3));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return employee;
	}
	
	public List<Employee> findAll()
	{
		List<Employee> emps=new ArrayList<Employee>();
		try(Connection connection=DbConnection.createConnection();
				Statement statement=connection.createStatement())
		{
			ResultSet resultSet=statement.executeQuery("select * from emp");
			while(resultSet.next())
			{
				Employee employee =new Employee();
				employee.setEmpId(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEmpSalary(resultSet.getDouble(3));
				emps.add(employee);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return emps;
	}
	
	public int deleteById(int empId)
	{
		int count =0;
		try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("delete from emp where empId=?"))
		{
			preparedStatement.setInt(1, empId);
			count=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	public int deleteBySalary(double empSalary)
	{
		int count =0;
		try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("delete from emp where empSalary>?"))
		{
			preparedStatement.setDouble(1, empSalary);
			count=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	public int updateSalary(double currentSalary, double incSalary)
	{
		int count =0;
		try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("update emp set empSalary=empSalary+? where empSalary>?"))
		{
			preparedStatement.setDouble(1, incSalary);
			preparedStatement.setDouble(2, currentSalary);
			count=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
}
