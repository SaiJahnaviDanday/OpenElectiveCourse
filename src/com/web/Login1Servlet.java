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


@WebServlet("/Login1Servlet")
public class Login1Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servlet called...");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");


		HttpSession session = request.getSession();
		session.setAttribute("loginId", loginId);
		session.setAttribute("password", password);

		if(loginId.equalsIgnoreCase("hod") && password.equalsIgnoreCase("hod")){
			System.out.println("In If");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("GetStudentetails");
			requestDispatcher.forward(request, response);
		}
		else{

			StudentDAO studentDAO = new StudentDAO();
			Student student = studentDAO.getStudent(loginId,password); 
			System.out.println("InSevlet"+loginId);

			out.println("<html>");

			if(student != null){
				session.setAttribute("student",student);
				out.println("<h1><center>Hi : " + loginId +"!</center></h1>");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("courses.html");
				requestDispatcher.include(request, response);

			}
			else {

				out.println("<h1><center>Invalid Credentials</center></h1>");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.html");
				requestDispatcher.include(request, response);
			}
			out.println("</html>");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
