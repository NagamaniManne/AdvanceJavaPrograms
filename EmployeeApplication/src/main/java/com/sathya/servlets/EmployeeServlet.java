package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId=Integer.parseInt(request.getParameter("empId"));
		String empName=request.getParameter("empName");
		double empSalary=Double.parseDouble(request.getParameter("empSalary"));
		
		double grossSalary,hra,da,pf;
		if(empSalary>=50000)
		{
			hra=empSalary*0.3;
			da=empSalary*0.1;
			pf=empSalary*0.06;
		}
		else if(empSalary>=25000 && empSalary<50000)
		{
			hra=empSalary*0.2;
			da=empSalary*0.05;
			pf=empSalary*0.03;
		}
		else
		{
			hra=empSalary*0.1;
			da=empSalary*0.03;
			pf=empSalary*0.02;
		}
		grossSalary=empSalary+hra+da-pf;
		
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<body bgcolor='pink'>");
		writer.println("<h1>Employee Salary Details.....</h1>");
		writer.println("Employee Id: "+empId+"<br><br>");
		writer.println("Employee Name: "+empName+"<br><br>");
		writer.println("Employee BasicSalary: $"+empSalary+"<br><br>");
		writer.println("HRA Amount: $"+hra+"<br><br>");
		writer.println("DA Amount: $"+da+"<br><br>");
		writer.println("PF Amount: $"+pf+"<br><br>");
		writer.println("Gross Salary: $"+grossSalary+"<br><br>");
		writer.println("</body>");
		writer.println("</html>");
	}


}
