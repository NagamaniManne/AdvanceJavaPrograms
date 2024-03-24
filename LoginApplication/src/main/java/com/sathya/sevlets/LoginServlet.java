package com.sathya.sevlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step-1: Read the Data
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		//Step-2: Process the Data
//		String status;
//		if(username.equals("sathya") && password.equals("Sathya@123"))
//		{
//			status="Login Successfull....";
//		}
//		else
//		{
//			status="Login Fail....";
//		}
//		
//		//Step-3: Render the response
//		PrintWriter writer=response.getWriter();
//		response.setContentType("text/html");
//		writer.println("<html>");
//		writer.println("<h1>Login Status.....</h1>"+status);
//		writer.println("</html>");
		
		
//		if(username.equals("sathya") && password.equals("Sathya@123"))
//		{
//			RequestDispatcher dispatcher=request.getRequestDispatcher("success.html");
//			dispatcher.forward(request, response);
//		}
//		else
//		{
//			PrintWriter writer=response.getWriter();
//			response.setContentType("text/html");
//			writer.println("<html>");
//			writer.println("<h1>Login Failed Please recheck the details and enter correctly.....</h1>");
//			writer.println("</html>");
//			RequestDispatcher dispatcher=request.getRequestDispatcher("login.html");
//			dispatcher.include(request, response);
//		}
		
		
//		if(username.equals("sathya") && password.equals("Sathya@123"))
//		{
//			response.sendRedirect("http://www.tcs.com");
//		}
//		else
//		{
//			response.sendError(808,"Login Fail please enter the correct details");
//		}
		
		
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		
		if(username.equals("sathya") && password.equals("Sathya@123"))
		{
			writer.println("<html>");
			writer.println("<a href='http://www.sathyatech.com'>Click here to open sathya website</a>");
			writer.println("</html>");
		}
		else
		{
			writer.println("<a href='login.html'>Click here to open login Page</a>");
		}
	}


}
