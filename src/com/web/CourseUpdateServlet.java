package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentDAO;

import com.dto.Student;

@WebServlet("/CourseUpdateServlet")
public class CourseUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String loginId = request.getParameter("loginId");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.getStudent(loginId); 
		if(student != null){
			System.out.println("InCourseSevlet"+loginId);
			request.setAttribute("student", student);
			RequestDispatcher rd = request.getRequestDispatcher("it.jsp");
			rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
