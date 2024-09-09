package com.nit.servlet;

import java.io.IOException;

import com.nit.connection.TransferDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int update;
		response.setContentType("text/html");
			try {
				update = TransferDAO.transferAmount(request);
				System.out.println(update);
				
				if(update>0) {
					request.getRequestDispatcher("transfersuccess.jsp").include(request,response);
				}
				else {
					request.getRequestDispatcher("transferfail.jsp").include(request,response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

}
