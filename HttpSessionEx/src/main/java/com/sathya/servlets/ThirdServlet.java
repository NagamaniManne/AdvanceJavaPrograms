package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor='pink'>");
		writer.println("<pre style='color:red'>");
		writer.println("User Name... "+session.getAttribute("username"));
		writer.println("Age... "+session.getAttribute("age"));
		writer.println("Qualification... "+session.getAttribute("qualification"));
		writer.println("Designation... "+session.getAttribute("designation"));
		writer.println("Email... "+request.getParameter("email"));
		writer.println("Mobile Number.. "+request.getParameter("mobile"));
		writer.println("</pre>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
