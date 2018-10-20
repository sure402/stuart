package com.stuartbankcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stuartbank.BankVaultInfo;

/**
 * Servlet implementation class BankInfo
 */

public class BankInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankInfo() {
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
		Connection con = (Connection) session.getAttribute("con");
		DBServiceCalls serv = new DBService();
		String sid = (String) session.getAttribute("name");
		int updatedStaffId = Integer.parseInt(sid);
		if(con!=null){
			Statement st = null;
			Statement st1 = null;
			try {
				st = con.createStatement();
				st1 = con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			ResultSet rs = null;
			ResultSet rs1 = null;
			try {
				rs= st.executeQuery("SELECT CustBankAccountNo, CustAcntBalance FROM bank.custbankaccountinfo;");
				 rs1=st1.executeQuery("SELECT CustomerId FROM bank.customerinfo;");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int count = 0;
			int balance = 0;
			int totalbalance = 0;
			String counts = null;
			int Customercount = 0;
			String noOfCustomers = null;
			Double totalAcntBalance = null;
			try {
				while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getInt(2));
				
				balance = rs.getInt(2);
				totalbalance = totalbalance + balance ;
				count++;
				 counts=String.valueOf(count);
				System.out.println("" +counts );
				totalAcntBalance = Double.valueOf(totalbalance);
				System.out.println("totalbalance" +totalAcntBalance );
				
				}
			}	 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				try {
				while(rs1.next()){
					System.out.println(rs1.getInt(1));
					Customercount++;
					noOfCustomers=String.valueOf(Customercount);
						System.out.println("" +noOfCustomers );
				}
				}
				 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				BankVaultInfo bvi  = new BankVaultInfo();
//				bvi.setBankName(bankname);
//				bvi.setbviBankCode(bankcode);
				bvi.setBankBalance(totalAcntBalance);	
				bvi.setNumberOfAccounts(count);
				bvi.setNumberOfCustomers(Customercount);
				request.setAttribute("bankVaultInfo", bvi);
//				request.setAttribute("totalnoofAccountsbalance", totalAcntBalance);
//				request.setAttribute("noOfCustomers", noOfCustomers);
			RequestDispatcher rd = request.getRequestDispatcher("/bankInfo.jsp");
			rd.include(request, response);
		}
		
		
		
	

		
	}




}
