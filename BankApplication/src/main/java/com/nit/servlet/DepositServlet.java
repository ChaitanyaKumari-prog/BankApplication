package com.nit.servlet;

import java.io.IOException;

import com.nit.connection.DepositDAO;
import com.nit.connection.LoginBean;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DepositServlet
 */
@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double amount=Double.parseDouble(request.getParameter("amount"));
		ServletContext sc=request.getServletContext();
		LoginBean lb=(LoginBean)sc.getAttribute("login");
		double balance=lb.getBalance();
		balance+=amount;
		lb.setBalance(balance);
		int update=DepositDAO.deposit(lb);
		if(update>0) {
			request.getRequestDispatcher("transfersuccess.jsp").include(request,response);
		}else {
			request.getRequestDispatcher("depositfail.jsp").include(request,response);
		}
		
		
		
	}

}
