package com.nit.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;

public class LoginDAO {
  public static LoginBean login(HttpServletRequest request) {
	  Connection con=DbConnection.getCon();
	  LoginBean lb=null;
	  try {
		  
		PreparedStatement pstmt=con.prepareStatement("select * from bankAccount where ACCNO=? and ACCHOLDERNAME=?");
		pstmt.setLong(1,Long.parseLong(request.getParameter("accno")));
		pstmt.setString(2,request.getParameter("acchname"));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			lb=new LoginBean();
			lb.setAccountNumber(rs.getLong(1));
			lb.setAccountHolderName(rs.getString(2));
			lb.setBalance(rs.getDouble(3));
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return lb;
  }
  
}
