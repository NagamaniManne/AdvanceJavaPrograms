package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proId=request.getParameter("proId");
		ProductDao productDao=new ProductDao();
		
		Product existingProduct=productDao.getProductById(proId);
		
		//add the product object to the request object
		request.setAttribute("existingProduct", existingProduct);

		
		//forward the request to editform.jsp
		RequestDispatcher dispatcher=request.getRequestDispatcher("editForm.jsp");
		dispatcher.forward(request, response);
	}
}
