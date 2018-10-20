package com.stuartbankcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stuartbank.BankVaultInfo;

/**
 * Servlet implementation class BankVaultInfo
 */

public class InfoBankVault extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoBankVault() {
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
		// 
		String bankname = request.getParameter("bankname");
		String bankcode = request.getParameter("bankcode");
		String bnkblnc = request.getParameter("bankbalance");
		double bankbalance = Double.parseDouble(bnkblnc);
		String noacnts = request.getParameter("noaccounts");
		int noaccounts = Integer.parseInt(noacnts);
		String nocustrs = request.getParameter("nocustomers");
		int nocustomers = Integer.parseInt(nocustrs);

		
		BankVaultInfo bvi = new BankVaultInfo();
		bvi.setBankName(bankname);
		bvi.setBankCode(bankcode);
		bvi.setBankBalance(bankbalance);	
		bvi.setLastUpDatedStaffId(updatedStaffId);
		bvi.setNumberOfAccounts(noaccounts);
		bvi.setNumberOfCustomers(nocustomers);
		boolean j = false ;

		try {
//			con1 = serv.dbConnection(dbname, dburl, dbusername, dbpassword);
			if(con!=null){
				Statement st = null;
				st = con.createStatement();
			
				ResultSet rs = null;
				rs= st.executeQuery("SELECT CustBankAccountNo, CustAcntBalance FROM bank.custbankaccountinfo;");
				int count = 0;
				int balance = 0;
				int totalbalance = 0;
				while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getInt(2));
				
				balance = rs.getInt(2);
				totalbalance = totalbalance + balance ;
				count++;
				System.out.println("no count" +count );
				System.out.println("totalbalance" +totalbalance );
			}
			}
				
//				 j = serv.insertBankVaultInfo(con, bvi);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(j){
		p.println("Successfully BankVaultInfo displayed");
		RequestDispatcher rd = request.getRequestDispatcher("Sbhome");
		rd.include(request, response);
		}
			else{
				p.println("<p color='red'>Registration Failed</p>");
				RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
				rd.include(request, response);
			
			}
		
	}



}
