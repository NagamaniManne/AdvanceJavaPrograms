package com.sathya.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the data
				String qualification=request.getParameter("qualification");
				String designation=request.getParameter("designation");
				
				//create cookies objects
				Cookie cookie3=new Cookie("qualification", qualification);
				Cookie cookie4=new Cookie("designation", designation);
				
				
				response.addCookie(cookie3);
				response.addCookie(cookie4);
				
				//next form
				RequestDispatcher dispatcher=request.getRequestDispatcher("form3.html");
				dispatcher.forward(request, response);
	}

}
