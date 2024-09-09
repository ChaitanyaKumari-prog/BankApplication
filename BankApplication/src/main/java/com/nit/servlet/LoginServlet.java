package com.nit.servlet;

import java.io.IOException;

import com.nit.connection.LoginBean;
import com.nit.connection.LoginDAO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginBean obj=LoginDAO.login(request);
		ServletContext sc=request.getServletContext();
		if(obj!=null) {
			sc.setAttribute("login",obj);
			request.getRequestDispatcher("loginSuccess.jsp").forward(request,response);
		}else {
			request.getRequestDispatcher("loginfail.jsp").forward(request,response);
		}
	}

}
