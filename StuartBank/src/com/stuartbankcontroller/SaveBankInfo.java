package com.stuartbankcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stuartbank.CustomerBankAccountInfo;
import com.stuartbank.CustomerInfo;

/**
 * Servlet implementation class SaveBankInfo
 */

public class SaveBankInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveBankInfo() {
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
		Random rand = new Random();
		 
		HttpSession session = request.getSession(false);
		Connection con = (Connection) session.getAttribute("con");
		DBServiceCalls serv = new DBService();
		String sid = (String) session.getAttribute("name");
		int updatedStaffId = Integer.parseInt(sid);
		int custid = (int) session.getAttribute("custId");
//		int custid = Integer.parseInt(custId);
		
//		long first14 = (long) (Math.random() * 1000000000L);
//		long rand_acnt_no_gen = 52000000000L + first14;
		long rand_acnt_no_gen = 1000000000 +rand.nextInt(900000000);
//		int rand_int1 = 1000000000 +rand.nextInt(900000000);

		String bankCode =request.getParameter("bankcode");
		String custAcntBalance = request.getParameter("balance");
		double bankbalance = Double.parseDouble(custAcntBalance);
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
//		LocalDate localDate = LocalDate.now();
		 LocalDateTime now = LocalDateTime.now();

	        System.out.println("Before : " + now);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	        String formatDateTime = now.format(formatter);

	        System.out.println("After : " + formatDateTime);
		
		java.text.DateFormat format = new java.text.SimpleDateFormat("MM-dd-yyyy");
//		String date = format.format(localDate);
//		System.out.println(date);
		java.util.Date date1 = null;
		try {
			date1 = format.parse(formatDateTime);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date timestamp = new java.sql.Date(date1.getTime());
		
		String customerAccountType = request.getParameter("AccountType");
		
		CustomerBankAccountInfo acntinfo = new CustomerBankAccountInfo();
		acntinfo.setCustomerId(custid);
		acntinfo.setCustomerBankAccountNo(rand_acnt_no_gen);
		acntinfo.setBankCode(bankCode);
		acntinfo.setCustomerAccounttBalance(bankbalance);
		acntinfo.setLastUpDatedStaffId(updatedStaffId);
		acntinfo.setLastUsedTransactionDate(timestamp);
		acntinfo.setCustomerAccountType(customerAccountType);
		
		boolean bnkCOde = false;
		try {
			bnkCOde = serv.validateBankCode(con, bankCode);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(bnkCOde){
		boolean j = false ;

		try {
//			con1 = serv.dbConnection(dbname, dburl, dbusername, dbpassword);
			if(con!=null){
				 j = serv.insertBankAccountInfo(con, acntinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(j){
		p.println("Successfully BankAccountInfo displayed");
		session.setAttribute("bankcode", bankCode);
		RequestDispatcher rd = request.getRequestDispatcher("Sbhome");
		rd.include(request, response);
		}
			else{
				p.println("<p color='red'>Registration Failed</p>");
				RequestDispatcher rd = request.getRequestDispatcher("/bankaccountInfo.jsp");
				rd.include(request, response);
			
			}
		}else {
			p.println("<p color='red'>Please Try to Enter the Correct BankCode</p>");
			RequestDispatcher rd = request.getRequestDispatcher("/bankaccountInfo.jsp");
			rd.include(request, response);
		}
		
		
		
	
	}



}
