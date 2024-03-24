package com.sathya.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet("/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Read the data
		String proId=request.getParameter("proId");
		String proName=request.getParameter("proName");
		Double proPrice=Double.parseDouble(request.getParameter("proPrice"));
		String proBrand=request.getParameter("proBrand");
		String proMadeIn=request.getParameter("proMadeIn");
		Date proMfgDate=Date.valueOf(request.getParameter("proMfgDate"));
		Date proExpDate=Date.valueOf(request.getParameter("proExpDate"));
		Part part=request.getPart("proImage");
		InputStream inputStream=part.getInputStream();
		
		//conversion of InputStream into byte[]
		byte[] proImage = IOUtils.toByteArray(inputStream);
		
		//before method using input stream
//		Part part=request.getPart("proImage");
//		InputStream proImage=part.getInputStream();
		
	     Part part1=request.getPart("proAudio");
	     InputStream inputStream1=part1.getInputStream();
	     byte[] proAudio= IOUtils.toByteArray(inputStream1);
	     
	     Part part2=request.getPart("proVideo");
	     InputStream inputStreams2=part2.getInputStream();
	     byte[] proVideo= IOUtils.toByteArray(inputStreams2);

		
		//Using above details create the product object
		
		Product product=new Product();
		product.setProId(proId);
		product.setProName(proName);
		product.setProPrice(proPrice);
		product.setProBrand(proBrand);
		product.setProMadeIn(proMadeIn);
		product.setProMfgDate(proMfgDate);
		product.setProExpDate(proExpDate);
		product.setProImage(proImage);
		product.setProAudio(proAudio);
		product.setProVideo(proVideo);
		
		//Giving the product object to DAO layer
		ProductDao productDao=new ProductDao();
		int result=productDao.save(product);
		
		
		if(result==1)
		{
			//To send the data to JSP, add the data to request object
			request.setAttribute("saveResult", result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("<h1 class='text-danger text-center'>Data Insertion Failed, Please check and enter the details again...</h1>"+result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("add-product.html");
			dispatcher.include(request, response);
		}
	}
}