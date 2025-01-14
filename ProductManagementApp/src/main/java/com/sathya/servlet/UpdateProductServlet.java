package com.sathya.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;


@SuppressWarnings("serial")
@WebServlet("/UpdateProductServlet")
@MultipartConfig

public class UpdateProductServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proId=request.getParameter("proId");
		String proName=request.getParameter("proName");
		Double proPrice=Double.parseDouble(request.getParameter("proPrice"));
		String proBrand=request.getParameter("proBrand");
		String proMadeIn=request.getParameter("proMadeIn");
		Date proMfgDate=Date.valueOf(request.getParameter("proMfgDate"));
		Date proExpDate=Date.valueOf(request.getParameter("proExpDate"));
		
		
		Product product=new Product();
		product.setProId(proId);
		product.setProName(proName);
		product.setProPrice(proPrice);
		product.setProBrand(proBrand);
		product.setProMadeIn(proMadeIn);
		product.setProMfgDate(proMfgDate);
		product.setProExpDate(proExpDate);
		
		
		Part filepart=request.getPart("newProImage");
		
		if(filepart!=null && filepart.getSize()>0)
		{
			InputStream inputStream=filepart.getInputStream();
			
			//conversion of InputStream into byte[]
			byte[] newImage = IOUtils.toByteArray(inputStream);
			product.setProImage(newImage);
		}
		else
		{
			String s=request.getParameter("existingImage");
//			InputStream inputStream=part1.getInputStream();
			
			//conversion of InputStream into byte[]
			byte[] existingImage = Base64.getDecoder().decode(s);
			product.setProImage(existingImage);
			
		}
			
		String s1=request.getParameter("existingAudio");		
		//conversion of InputStream into byte[]
		byte[] Audio = Base64.getDecoder().decode(s1);
		product.setProAudio(Audio);
		
		String s2=request.getParameter("existingVideo");		
		//conversion of InputStream into byte[]
		byte[] Video = Base64.getDecoder().decode(s2);
		product.setProVideo(Video);
			
			
		//Giving the product object to DAO layer
		
		ProductDao productDao=new ProductDao();
		int result=productDao.updateById(product);
		
		
		if(result==1)
		{
			//To send the data to JSP, add the data to request object
			request.setAttribute("updateResult", result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("<h1 class='text-danger text-center'>Data Updation Failed, Please check and enter the details again...</h1>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("editForm.jsp");
			dispatcher.include(request, response);
		}
	}

}
