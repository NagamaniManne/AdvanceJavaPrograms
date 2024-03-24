package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		long mobile=Long.parseLong(request.getParameter("mobile"));
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String dob=request.getParameter("dob");
		String[] qualification=request.getParameterValues("qualification");
		String country=request.getParameter("country");
		String[] languages=request.getParameterValues("languages");
		String comments=request.getParameter("comments");
		
		
		String qual=String.join(", ", qualification);
		String lang=String.join(", ", languages);
		
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor='pink'>");
		writer.println("<h1>Your Registration Details.......</h1>");
		writer.println("<p>Your UserName: "+username+"</p>");
		writer.println("<p>Your Password: "+password+"</p>");
		writer.println("<p>Your Mobile Number: "+mobile+"</p>");
		writer.println("<p>Your Emai Id: "+email+"</p>");
		writer.println("<p>Your Gender: "+gender+"</p>");
		writer.println("<p>Your Date Of Birth: "+dob+"</p>");
		writer.println("<p>Your Qualifications: "+qual+"</p>");
		writer.println("<p>Your Country: "+country+"</p>");
		writer.println("<p>Languages you know are: "+lang+"</p>");
		writer.println("<p>Your Comments: "+comments+"</p>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
