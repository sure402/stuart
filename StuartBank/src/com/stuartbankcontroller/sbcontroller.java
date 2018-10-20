package com.stuartbankcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class sbcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public sbcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		ServletContext config = getServletContext();
		String dbname =config.getInitParameter("dbdrivername");
		String dburl= config.getInitParameter("dburl");
		String dbusername= config.getInitParameter("dbusername");
		String dbpassword= config.getInitParameter("dbpassword");
		
		
//		String env = con.getInitParameter("env");
		
		DBService serv = new DBService();
		Connection con1 = null;
		boolean loginflag = false;
		try {
			con1 = serv.dbConnection(dbname, dburl, dbusername, dbpassword);
			if(con1!=null){
				 loginflag = serv.validateuser(con1,name,password);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(loginflag)	{	
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("con", con1);
			RequestDispatcher rd = request.getRequestDispatcher("Sbhome");
			rd.forward(request, response);
	
			}
			else{
				p.println("<p color='red'>Invalid logon Details</p>");
				RequestDispatcher rd = request.getRequestDispatcher("/sblogin.jsp");
				rd.include(request, response);
			
			}
		
		p.close();
	}


}
