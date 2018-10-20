package com.stuartbankcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SbHome
 */
//@WebServlet("/SbHome")
public class SbHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SbHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
//		String name = request.getParameter("name");
		
		
//		HttpSession session = request.getSession(false);
//		session.getAttribute("name");
//		p.println("Welcome "+ (String)session.getAttribute("name"));
		
		RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
		rd.include(request, response);
		//response.sendRedirect("http://www.google.com?q="+name);
		
	}
		
		
	}




