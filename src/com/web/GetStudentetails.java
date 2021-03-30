package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OpenElectiveDAO;
import com.db.DbConnection;
import com.dto.OpenElective;


@WebServlet("/GetStudentetails")
public class GetStudentetails extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        
		System.out.println("In GetStudentetails");
		
		OpenElectiveDAO openElectiveDAO = new OpenElectiveDAO();
		List<OpenElective> openList  = openElectiveDAO.getOpenElective();

		if(openList != null){
			request.setAttribute("openList", openList);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("DisplayAllStudent.jsp");
			requestDispatcher.include(request, response);
			
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}








