//package forms;

import java.sql.Connection;
import java.sql.DriverManager;



public class MyConnection {

	//create a function to connect with mysql database
	
	public static Connection getConnection() {
		
		Connection con = null;
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");			 
			 con = DriverManager.getConnection("jdbc:mysql://localhost/jewellery_shop", "root", "" );		 			 			
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return con;
	}

	
	
}
