package com.sathya.jdbcex;

import java.util.List;

public class DataBaseClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductDao productDao=new ProductDao();
		int res=productDao.createProductTable();
		if(res==0)
			System.out.println("product1 table created successfully");
		else
			System.out.println("Table does not created");
		
		int res1=productDao.saveProduct(new Product(1,"mobile",55000.0));
		System.out.println("Data inserted successfully.."+res1); 
		int res2=productDao.saveProduct(new Product(2,"laptop",100000.0));
		System.out.println("Data inserted successfully.."+res2); 
		
		Product product=productDao.getProductById(1);
		System.out.println(product);
		Product product1=productDao.getProductById(3);
		System.out.println(product1);
		
		
		List<Product> prods=productDao.getAllProducts();
		prods.forEach(prod-> System.out.println(prod));
		
		
		int updcout=productDao.updateByPrice(400, 50);
		System.out.println("update successfully for "+updcout+" products");
		
		int delcount1=productDao.deleteById(1);
		if(delcount1==1)
			System.out.println("deleted product successfully");
		else
			System.out.println("can't delete the product");
		
		int delcount2=productDao.deleteByPrice(100050);
		if(delcount2>0)
			System.out.println("deleted product successfully");
		else
			System.out.println("can't delete the product");
		
		int res3=productDao.dropTable();
		System.out.println("Table dropped successfully "+res3);
	}

}
