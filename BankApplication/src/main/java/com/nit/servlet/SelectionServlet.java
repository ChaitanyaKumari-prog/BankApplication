package com.nit.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectionServlet
 */
@WebServlet("/selection")
public class SelectionServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation=request.getParameter("transfer");
		switch(operation) {
		   case "Deposit":
			        request.getRequestDispatcher("deposit.html").include(request,response);
			        break;
		   case "Transfer Money":
			        request.getRequestDispatcher("transfer.html").include(request, response); 
			        break;
		}
	}

}
