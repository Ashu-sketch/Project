package com.controller.bean.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	public static Connection createConnection() {
		 Connection con = null;
	     String url = "jdbc:sqlserver://DESKTOP-H7NK121\\SQLEXPRESS; databaseName=db_calorie;integratedSecurity=true; encrypt=false;"; //MySQL URL and followed by the database name
	   
	     try 
	     {
	         try 
	         {
	        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         } 
	         catch (ClassNotFoundException e)
	         { throw new RuntimeException("unhandled", e);
	         } 
	         con = DriverManager.getConnection(url); //attempting to connect to MySQL database
//	         System.out.println("Printing connection object "+con);
	     } 
	     catch (SQLException e) 
	     {
	    	 throw new RuntimeException("unhandled", e);
	    	 
	     }
	     return con;
	}


}
