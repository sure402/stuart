package com.stuartbankcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stuartbank.AccountInfo;
import com.stuartbank.CustomerBankAccountInfo;

/**
 * Servlet implementation class CustomerAccountBankinfo
 */

public class CustomerAccountBankinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAccountBankinfo() {
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
		
		if(con!=null){
			Statement st = null;
			try {
				st = con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			ResultSet rs = null;
			try {
				rs= st.executeQuery("SELECT * FROM bank.custbankaccountinfo;");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int custid = 0;
			long bankacntno = 0;
			String bankcode = null;
			float bankbalance = 0;
			int lastupdatedstaffId = 0;
			Date transactonDate = null;
			String acntType = null;
			CustomerBankAccountInfo cbai  = null;
			cbai=new CustomerBankAccountInfo();
			 List<AccountInfo> std = null;
			 std = new ArrayList<AccountInfo>();
			try {
				while(rs.next()){
//				System.out.println(rs.getInt(1)+" "+rs.getInt(2));
				 custid = rs.getInt(1);
				 bankacntno = rs.getLong(2);
				 bankcode = rs.getString(3);
				 bankbalance = rs.getFloat(4);
				 lastupdatedstaffId = rs.getInt(5);
				 transactonDate = rs.getDate(6);
				 acntType = rs.getString(7);
				 
					cbai.setCustomerId(custid);
					cbai.setCustomerBankAccountNo(bankacntno);
					cbai.setBankCode(bankcode);
					cbai.setCustomerAccounttBalance(bankbalance);
					cbai.setLastUpDatedStaffId(lastupdatedstaffId);
					cbai.setLastUsedTransactionDate(transactonDate);
					cbai.setCustomerAccountType(acntType);
					
					std.add(new AccountInfo(cbai.getCustomerId(), cbai.getCustomerBankAccountNo(),cbai.getBankCode(),
	                 cbai.getCustomerAccounttBalance(),
	                 cbai.getLastUpDatedStaffId(),
	                cbai.getLastUsedTransactionDate(), 
	                cbai.getCustomerAccountType()));
				
				}
			}	 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
					request.setAttribute("bankacntInfo", std);
	RequestDispatcher rd = request.getRequestDispatcher("/customerbankaccountinfo.jsp");
	rd.include(request, response);
		
	}
	}

}
