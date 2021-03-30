package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.dto.Student;



@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servlet called...");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String sName = request.getParameter("sName");
		String year = request.getParameter("year");
		String branch = request.getParameter("branch");
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");

		Student student = new Student(sName, year,branch,loginId, password);
        System.out.println(student);
        
        StudentDAO studentDAO = new StudentDAO();
        int result = studentDAO.register(student);
        
        if(result > 0){
        	out.println("<body bgcolor = yellow text=red>");
			out.println("<h1><center>Successfully Registered !!!</center></h1>");
			out.println("</body>");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.html");
			requestDispatcher.include(request, response);
        	
        }
        else{
        	out.println("<body bgcolor = yellow text=red>");
			out.println("<h1><center>Registration Failed!!!</center></h1>");
			RequestDispatcher rd = request.getRequestDispatcher("register.html");
			rd.include(request, response); 
			out.println("</body>");
			
			
        }
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
