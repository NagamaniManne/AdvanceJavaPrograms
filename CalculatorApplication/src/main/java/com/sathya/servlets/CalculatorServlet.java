package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1=Integer.parseInt(request.getParameter("first"));
		int num2=Integer.parseInt(request.getParameter("second"));
		String operator=request.getParameter("operation");
		int result = 0;
		switch(operator)
		{
		case "+": result=num1+num2;
					break;
		case "-": result=num1-num2;
					break;
		case "*": result=num1*num2;
					break;
		case "/": result=num1/num2;
					break;
		case "%": result=num1%num2;
					break;
		}
		
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<body bgcolor='pink'>");
		writer.println("<h1>Calculated Result.....</h1>");
		writer.println("<p>Your First Number: "+num1+"</p>");
		writer.println("<p>Your Second Number: "+num2+"</p>");
		writer.println("<p>Your Operator: "+operator+"</p>");
		writer.println("<p>Your Result ...  "+result+"</p>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
