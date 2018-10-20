package com.stuartbankcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchCustomerInfo
 */

public class SearchCustomerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCustomerInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		String customerId = request.getParameter("customerId");
		int custid = Integer.parseInt(customerId);
		
		HttpSession session = request.getSession(false);
		Connection con = (Connection) session.getAttribute("con");
		DBServiceCalls serv = new DBService();
//		boolean serachcustomerinfo = false;
		int serachcustomerinfo = 0;
		 serachcustomerinfo = serv.validateSearchCustomerInfo(custid, con);
		 
		 if(serachcustomerinfo ==0){
			 p.println("<p color='red'>Invalid customerId. Please enter Correct CustomerId or click the customer registartion link</p>");
			 RequestDispatcher rd = request.getRequestDispatcher("/searchcustomer.jsp");
				rd.include(request, response);
		 }else{
			 session.setAttribute("custId", serachcustomerinfo);
			 RequestDispatcher rd = request.getRequestDispatcher("/bankaccountInfo.jsp");
				rd.include(request, response);
		 }
	}



}
