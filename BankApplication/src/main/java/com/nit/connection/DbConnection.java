package com.nit.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	static Connection con=null;
	  private DbConnection() {
		  
	  }
	  static{
		  try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			}catch (Exception e) {
				
			}
	  }
	  public static Connection getCon() {
		  return con;
	  }
}
