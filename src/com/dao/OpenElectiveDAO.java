package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnection;
import com.dto.OpenElective;
import com.dto.Student;

public class OpenElectiveDAO {

	public OpenElective getOpenElective1() {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		System.out.println("In DAO");
		String SELECT = "Select * from OpenElective";
		connection = DbConnection.getConnection();
		try {
			preparedStatement  = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				OpenElective openElective  = new OpenElective();

				openElective.setoId(resultSet.getString(1));
				openElective.setYear(resultSet.getString(2));
				openElective.setBranch(resultSet.getString(3));
				openElective.setSub(resultSet.getString(4));
				return openElective;
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
	public List<OpenElective> getOpenElective() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		System.out.println("In DAO");
		
		String SELECT = "Select * from OpenElective";
		connection = DbConnection.getConnection();
		
		
		try {
			preparedStatement  = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			List<OpenElective> openList  = new ArrayList<OpenElective>();
			while(resultSet.next()){
				OpenElective openElective = new OpenElective();
				
				openElective.setoId(resultSet.getString(1));
				openElective.setYear(resultSet.getString(2));
				openElective.setBranch(resultSet.getString(3));
				openElective.setSub(resultSet.getString(4));
	
				openList.add(openElective);
				
			}
			return openList;

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

	public int register(OpenElective openElective) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;

		connection = DbConnection.getConnection();
		String INSERT = "Insert into OpenElective values (?,?,?,?)";
		System.out.println("In OpenElectiveDAO");
		
		try {
			preparedStatement  = connection.prepareStatement(INSERT);

			preparedStatement.setString(1,openElective.getoId());
			preparedStatement.setString(2,openElective.getYear());
			preparedStatement.setString(3,openElective.getBranch());
			preparedStatement.setString(4,openElective.getSub());
			

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
}