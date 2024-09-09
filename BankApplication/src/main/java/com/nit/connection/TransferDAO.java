package com.nit.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

public class TransferDAO {
      public static int transferAmount(HttpServletRequest request) throws Exception {
    	  Connection con=DbConnection.getCon();
    	  int updateTarget=0;
    	  int updateSource=0;
    	  try {
			PreparedStatement pstmt=con.prepareStatement("insert into transaction values(?,?,?,?)");
			pstmt.setLong(1,Long.parseLong(request.getParameter("accnumber")));
			pstmt.setString(2,"tra"+Math.random());
			//inserting date and time in database
			LocalDateTime date=LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		    String formattedDate = date.format(myFormatObj);
		    pstmt.setString(3,formattedDate);

		    pstmt.setDouble(4,Double.parseDouble(request.getParameter("amt")));
			updateTarget=pstmt.executeUpdate();
			System.out.println(updateTarget);
			PreparedStatement pstmt1=con.prepareStatement("update bankAccount set BALANCE=BALANCE-? where ACCNO=?");
			ServletContext sc=request.getServletContext();
			LoginBean lb=(LoginBean)sc.getAttribute("login");
			System.out.println(lb);
			pstmt1.setDouble(1,Double.parseDouble(request.getParameter("amt")));
			pstmt1.setLong(2,lb.getAccountNumber());
			updateSource=pstmt1.executeUpdate();
		   }catch (SQLException e) {
		   }

    	  return updateTarget;
      }
}
