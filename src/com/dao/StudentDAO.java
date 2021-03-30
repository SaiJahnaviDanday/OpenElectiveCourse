package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnection;
import com.dto.Student;

public class StudentDAO {

	public Student getStudent(String loginId, String password) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		System.out.println("In DAO"+loginId);
		String SELECT = "Select * from Student Where loginId=? and password=?";
		connection = DbConnection.getConnection();
		try {
			preparedStatement  = connection.prepareStatement(SELECT);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				Student student  = new Student();

				student.setsName(resultSet.getString(1));
				student.setYear(resultSet.getString(2));
				student.setBranch(resultSet.getString(3));
				student.setLoginId(resultSet.getString(4));
				student.setPassword(resultSet.getString(5));
				return student;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			try{
				if(connection != null){
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		}

		return null;
	}

	public int register(Student student) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;

		connection = DbConnection.getConnection();
		String INSERT = "Insert into Student values (?,?,?,?,?)";
		try {
			preparedStatement  = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, student.getsName());
			preparedStatement.setString(2, student.getYear());
			preparedStatement.setString(3, student.getBranch());
			preparedStatement.setString(4, student.getLoginId());
			preparedStatement.setString(5, student.getPassword());

			result = preparedStatement.executeUpdate();
			return result;


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			try{
				if(connection != null){
					preparedStatement.close();
					connection.close();
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		}

		return 0;
	}
	public Student getStudent(String loginId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		System.out.println("In DAO");
		
		String SELECT = "Select * from Student Where loginId=?";
		connection = DbConnection.getConnection();
		try {
			preparedStatement  = connection.prepareStatement(SELECT);
			preparedStatement.setString(1, loginId);
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				Student student  = new Student();
				student.setsName(resultSet.getString(1));
				student.setYear(resultSet.getString(2));
				student.setBranch(resultSet.getString(3));
				student.setLoginId(resultSet.getString(4));
				student.setPassword(resultSet.getString(5));
				return student;

				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			try{
				if(connection != null){
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		}

		return null;
	}
	public List<Student> getStudent() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		System.out.println("In DAO");
		
		String SELECT = "Select * from Student";
		connection = DbConnection.getConnection();
		
		
		try {
			preparedStatement  = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			List<Student> stdList  = new ArrayList<Student>();
			while(resultSet.next()){
				Student student = new Student();
				student.setsName(resultSet.getString(1));
				student.setYear(resultSet.getString(2));
				student.setBranch(resultSet.getString(3));
				student.setLoginId(resultSet.getString(4));
				student.setPassword(resultSet.getString(5));
	
				stdList.add(student);
				
			}
			return stdList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			try{
				if(connection != null){
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		}

		return null;
	}
}