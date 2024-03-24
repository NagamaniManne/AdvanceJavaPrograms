package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step-1: Read the requested data
		int proId=Integer.parseInt(request.getParameter("proId"));
		String proName=request.getParameter("proName");
		double proPrice=Double.parseDouble(request.getParameter("proPrice"));
		int proQuantity=Integer.parseInt(request.getParameter("proQuantity"));
		
		//Step-2: process the data
		double total=proPrice*proQuantity;
		double discount=0,netAmount=0;
		
		if(total<1000)
		{
			discount=0;
		}
		else if(total>=1000 && total<5000)
		{
			discount=total*0.05;
		}
		else if(total>=5000 && total<10000)
		{
			discount=total*0.1;
		}
		else
		{
			discount=total*0.15;
		}
		netAmount=total-discount;
		
		//Step-3 render the response
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<body bgcolor='pink'>");
		writer.println("<h1>Product Bill Invoice.....</h1>");
		writer.println("Product Id: "+proId+"<br><br>");
		writer.println("Product Name: "+proName+"<br><br>");
		writer.println("Product Price: $"+proPrice+"<br><br>");
		writer.println("Product Quantity: "+proQuantity+"<br><br>");
		writer.println("Total Bill Amount: $"+total+"<br><br>");
		writer.println("Discount Amount: $"+discount+"<br><br>");
		writer.println("Net Amount to Pay: $"+netAmount+"<br><br>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
