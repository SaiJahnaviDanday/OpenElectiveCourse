package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OpenElectiveDAO;
import com.dao.StudentDAO;
import com.dto.OpenElective;
import com.dto.Student;



@WebServlet("/Register1Servlet")
public class Register1Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Register1ServletServlet called...");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String oId = request.getParameter("oId");
		String year = request.getParameter("year");
		String branch = request.getParameter("branch");
		String sub = request.getParameter("sub");

		OpenElective openElective = new OpenElective(oId,year, branch, sub);
        System.out.println(openElective);
        
        OpenElectiveDAO openElectiveDAO = new OpenElectiveDAO();
        int result = openElectiveDAO.register(openElective);
        
        if(result > 0){
        	out.println("<body bgcolor = yellow text=red>");
			out.println("<h1><center>Successfully Registered !!!</center></h1>");
			out.println("</body>");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
			requestDispatcher.include(request, response);
        	
        }
        else{
        	out.println("<body bgcolor = yellow text = red>");
			out.println("<h1><center>Registration Failed!!!</center></h1>");
			RequestDispatcher rd = request.getRequestDispatcher("register1.html");
			rd.include(request, response); 
			out.println("</body>");
			
			
        }
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
