package com.gaoxin.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	private  Connection conn = null;
	private static final String URL = "jdbc:mysql://107.170.239.139:3306/stu_info";
	private static final String USER = "root";
	private static final String PASSWD ="rootpasswd";

	public  Connection getConnection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(URL,USER,PASSWD);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;	
	}
}
