package com.stuartbankcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stuartbank.CustomerAddress;
import com.stuartbank.CustomerInfo;

/**
 * Servlet implementation class SaveCustomerInfo
 */

public class SaveCustomerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCustomerInfo() {
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
		 // create instance of Random class
        Random rand = new Random();
 
		HttpSession session = request.getSession(false);
		Connection con = (Connection) session.getAttribute("con");
		DBServiceCalls serv = new DBService();
		String sid = (String) session.getAttribute("name");
		int updatedStaffId = Integer.parseInt(sid);
//		session.setAttribute("staffId", updatedStaffId);
		
		int rand_int1 =0;
		int resultRandom = 0;
		int count = 1;
	        do {
	        	rand_int1 = 1000000 +rand.nextInt(9000000);
	             resultRandom = serv.validateNumberGenerate(rand_int1, con);
	        
	            if(resultRandom== 0){
	            	break;
	            }
	            count++;
	        } while (count < 5);
			
		
		String fn=(String) request.getParameter("FisrtName");
		String ln=(String)request.getParameter("LastName");
		System.out.println(ln);
		String age1 = request.getParameter("age");
		int age = Integer.parseInt(age1);
		String dob1 = request.getParameter("DateOfBirth");
		System.out.println(dob1);
		java.text.DateFormat format = new java.text.SimpleDateFormat("MM-dd-yyyy");
		java.util.Date date = null;
		try {
			date = format.parse(dob1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date timestamp = new java.sql.Date(date.getTime());
		System.out.println(timestamp);
		String city = request.getParameter("City");
		String state = request.getParameter("State");
		String country = request.getParameter("Country");
		String zip = request.getParameter("ZIPCode");
		int zipCode = Integer.parseInt(zip);
		
		
		CustomerInfo custinfo = new CustomerInfo();
		custinfo.setCustomerId(rand_int1);
		custinfo.setCustomerFirstName(fn);
		custinfo.setCustomerLaststName(ln);
		custinfo.setAge(age);
		custinfo.setDateOfBirth(timestamp);
		custinfo.setLastUpDatedStaffId(updatedStaffId);
		
		CustomerAddress custAddress = new CustomerAddress();
		custAddress.setCustomerId(rand_int1);
		custAddress.setCity(city);
		custAddress.setState(state);
		custAddress.setZipCode(zipCode);
		custAddress.setCountry(country);
		
		
	
//		DBService serv = new DBService();
//		Connection con1 = null;
		boolean j = false ;

		try {
//			con1 = serv.dbConnection(dbname, dburl, dbusername, dbpassword);
			if(con!=null){
				 j = serv.insertCustomerInfo(con, custinfo, custAddress);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(j){
		p.println("Successfully Registered");
		session.setAttribute("custId", rand_int1);
		RequestDispatcher rd = request.getRequestDispatcher("Sbhome");
		rd.include(request, response);
		
		}
			else{
				p.println("<p color='red'>Registration Failed</p>");
				RequestDispatcher rd = request.getRequestDispatcher("Customerinfo");
				rd.include(request, response);
			
			}
		}
	}



