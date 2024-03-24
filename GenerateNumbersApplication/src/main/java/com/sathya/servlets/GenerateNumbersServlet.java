package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GenerateNumbersServlet")
public class GenerateNumbersServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start=Integer.parseInt(request.getParameter("start"));
		int end=Integer.parseInt(request.getParameter("end"));
		String operator=request.getParameter("operation");
		
		ArrayList<Integer> result=new ArrayList<Integer>();
		switch(operator)
		{
		case "Even": 
							for(int i=start;i<=end;i++)
							{
								if(i%2==0)
									result.add(i);
							}
							break;
							
		case "Odd":
							for(int i=start;i<=end;i++)
							{
								if(i%2!=0)
									result.add(i);
							}
							break;
							
		case "Prime":   	
							boolean flag;
							for(int i=start;i<=end;i++)
							{
								flag=true;
								for(int j=2;j<=i/2;j++)
								{
									if(i%j==0)
									{
										flag=false;
										break;
									}
								}
								if(flag)
									result.add(i);
							}
							break;
							
		case "Perfect":
							int sum;
							for(int i=start;i<=end;i++)
							{
							    sum=0;
							    for(int j=1;j<i;j++)
							    {
							 	if(i%j==0)
									sum=sum+j;
							    }
							    if(i==sum)
							    	result.add(i);
							}
							break;
							
		case "Strong":
							int sum1,temp,rem,fact;
							for(int i=start;i<=end;i++)
							{
							    sum1=0;
							    temp=i;
							    while(temp>0)
							    {
							 	rem=temp%10;
								if(rem==0 || rem==1)
								    fact=1;
								else
								   {
									fact=1;
									for(int j=1;j<=rem;j++)
									   fact=fact*j; 
								   }
								sum1=sum1+fact;
								temp=temp/10;
							    }
							if(i==sum1)
								result.add(i);
							}
							break;
			}
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<body bgcolor='pink'>");
		writer.println("<h1>"+operator+" Numbers Result.....</h1>");
		writer.println("<p>Your Start Number: "+start+"</p>");
		writer.println("<p>Your End Number: "+end+"</p>");
//		writer.println("<p>Your Operator: "+operator+"</p>");
		writer.println("<p>Your "+operator+" Numbers Result ...  "+result+"</p>");
		writer.println("</body>");
		writer.println("</html>");
		
	}

}
