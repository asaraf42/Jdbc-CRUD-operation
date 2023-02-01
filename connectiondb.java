package com.db.cons.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.db.cons.conn.constantsdb.*;

public class connectiondb {
	
	
	static 
	{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
	
	public static Connection getconnection() throws Exception
	{
	Connection con=DriverManager.getConnection(url,user,password);
	return con;
	}
	

}
