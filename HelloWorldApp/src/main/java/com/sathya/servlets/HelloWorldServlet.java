package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/test")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain");
		
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<h1>Welcome to Sathya Tech</h1>");
		writer.println("<h2>This is Servlet First Project</h2>");
		writer.println("<h3>Ratan Sir classes</h3>");
		writer.println("</html>");
	}

}