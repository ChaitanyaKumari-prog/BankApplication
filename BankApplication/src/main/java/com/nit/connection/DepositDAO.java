package com.nit.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;

public class DepositDAO {
   public static int deposit(LoginBean lb) {
	   Connection con=DbConnection.getCon();
	   int k=0;
	   try {
		PreparedStatement pstmt=con.prepareStatement("update bankAccount set BALANCE=? where  ACCNO=?");
		pstmt.setDouble(1,lb.getBalance());
		pstmt.setLong(2,lb.getAccountNumber());
		k=pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	   return k;
   }
}
