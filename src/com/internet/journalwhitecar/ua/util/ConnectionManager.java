package com.internet.journalwhitecar.ua.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class ConnectionManager {
									
	private static final String URL=  "jdbc:mysql://localhost:3306/journalwhitecar";
	private static final String userName=  "root";
	private static final String password=  "root";
	
	private static Connection connection;
	
	private ConnectionManager(){
	
	}
	
	public static Connection makeConnection() {
		
		if(connection ==null){
			try {
				 Class.forName("com.mysql.jdbc.Driver").newInstance(); 
				connection=DriverManager.getConnection(URL, userName,password);
				System.out.println("Connection is sucsessfully done...");
			} catch (SQLException e) {				
				e.printStackTrace();
			} catch (Exception e) {
				
				e.printStackTrace();
	}
	
		}
		return connection;}
	
}
