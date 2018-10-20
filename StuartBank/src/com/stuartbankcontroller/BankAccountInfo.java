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
 * Servlet implementation class BankBalanceInfo
 */

public class BankAccountInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankAccountInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		
		HttpSession session = request.getSession(false);
		Integer custId=null;
		try{
			 custId=(Integer) session.getAttribute("custId");
			 if(custId!= null){
				RequestDispatcher rd = request.getRequestDispatcher("/bankaccountInfo.jsp");
				rd.include(request, response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/searchcustomer.jsp");
				rd.include(request, response);
				
			}
			

		}catch(Exception e){
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("/searchcustomer.jsp");
			rd.include(request, response);
		}
				
	
	}



}
