package com.sathya.jdbcex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	public int createProductTable()
	{
		int count=-1;
		try(Connection connection=DbConnection.createConnection();
				Statement statement=connection.createStatement())
		{
			count=statement.executeUpdate("create table product1 (proId number,proName varchar2(30),proPrice number)");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}

	public int saveProduct(Product product)
	{
		int count =0;
		try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("insert into product1 values(?,?,?)"))
		{
			preparedStatement.setInt(1, product.getProId());
			preparedStatement.setString(2, product.getProName());
			preparedStatement.setDouble(3, product.getProPrice()); 
			count=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	public Product getProductById(int id)
	{
		Product product=null;
		try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("select * from product1 where proId=?"))
		{
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				product =new Product();
				product.setProId(resultSet.getInt(1));
				product.setProName(resultSet.getString(2));
				product.setProPrice(resultSet.getDouble(3));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return product;
	}
	
	public List<Product> getAllProducts()
	{
		List<Product> prods=new ArrayList<Product>();
		try(Connection connection=DbConnection.createConnection();
				Statement statement=connection.createStatement())
		{
			ResultSet resultSet=statement.executeQuery("select * from product1");
			while(resultSet.next())
			{
				Product product =new Product();
				product.setProId(resultSet.getInt(1));
				product.setProName(resultSet.getString(2));
				product.setProPrice(resultSet.getDouble(3));
				prods.add(product);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return prods;
	}
	
	public int updateByPrice(double priceRange, double incrementValue)
	{
		int count =0;
		try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("update product1 set proPrice=proPrice+? where proPrice>?"))
		{
			preparedStatement.setDouble(1, incrementValue);
			preparedStatement.setDouble(2, priceRange);
			count=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	public int deleteById(int id)
	{
		int count =0;
		try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("delete from product1 where proId=?"))
		{
			preparedStatement.setInt(1, id);
			count=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	public int deleteByPrice(double price)
	{
		int count =0;
		try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("delete from product1 where proPrice=?"))
		{
			preparedStatement.setDouble(1, price);
			count=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	public int dropTable()
	{
		int count=-1;
		try(Connection connection=DbConnection.createConnection();
				Statement statement=connection.createStatement())
		{
			count=statement.executeUpdate("drop table product1");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
}
