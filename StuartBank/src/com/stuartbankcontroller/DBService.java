package com.stuartbankcontroller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;

import com.stuartbank.BankVaultInfo;
import com.stuartbank.CustomerAddress;
import com.stuartbank.CustomerBankAccountInfo;
import com.stuartbank.CustomerInfo;

public class DBService implements DBServiceCalls {
	Connection con = null;
	public Connection dbConnection(String dbname, String dburl, String dbusername, String dbpassword) throws SQLException, ClassNotFoundException{
		
	//	Connection con = null;
		
		Class.forName(dbname); //creates new instance for the driver
		//gets connected to mysql database using, url, username, password of the installed mysql 
		con = DriverManager.getConnection(dburl,dbusername,dbpassword);
		
	return con;
	
}

public boolean validateuser(Connection con, String name, String password) throws SQLException {
	// TODO Auto-generated method stub
	ResultSet rs = null;
	 PreparedStatement pstmt= null;
	 String sql = "select * from bank.staffinfo where StaffId=? and Password =?";
	 System.out.println("@@@"+sql);
	 pstmt= con.prepareStatement(sql);
	 pstmt.setInt(1,Integer.valueOf(name));
	 pstmt.setString(2, password);
		rs= pstmt.executeQuery();
		int name1 =0;
		String password1 = null;
		while(rs.next()){
			name1 = rs.getInt("StaffId");
			password1 = rs.getString("Password");
		}
		
		if(name.equals(String.valueOf(name1))&& password.equals(password1)){
			return true;
		}else
	return false;


}
public boolean insertCustomerInfo(Connection con, CustomerInfo custinfo, CustomerAddress custAddress) throws SQLException {
	// TODO Auto-generated method stub
	ResultSet rs = null;
	 PreparedStatement pstmt= null;
	 con.setAutoCommit(false);
	 int j=0;
	 pstmt=con.prepareStatement("insert into bank.customerinfo values(?,?,?,?,?,?)");  
//	 pstmt=con.prepareStatement("DELETE FROM bank.customerinfo");
//	  PreparedStatement   pstmt1 =con.prepareStatement("insert into test.studentaddress values(?,?,?,?,?)"); 
	 pstmt.setInt(1, custinfo.getCustomerId());
	   pstmt.setString(2,custinfo.getCustomerFirstName());  
	   pstmt.setString(3,custinfo.getCustomerLaststName()); 
	   pstmt.setInt(4, custinfo.getAge());
	   pstmt.setDate(5, custinfo.getDateOfBirth());
	   pstmt.setInt(6, custinfo.getLastUpDatedStaffId());
	   j=pstmt.executeUpdate();
	   int k=0;
	 if(j>0){
	 pstmt=con.prepareStatement("insert into bank.customeraddrees values(?,?,?,?,?,?)"); 
		 
	 pstmt.setInt(1, custinfo.getCustomerId());
	   pstmt.setString(2,custAddress.getCity());  
	   pstmt.setString(3,custAddress.getState()); 
	   pstmt.setString(4,custAddress.getCountry()); 
	   pstmt.setInt(5,custAddress.getZipCode());
	   pstmt.setInt(6, custinfo.getLastUpDatedStaffId());
	   
	   k=pstmt.executeUpdate();
	   k++;
	   }
	   else{
	   con.rollback();
   }
	 if(j>0&&k>0){
		   System.out.println("no of records inserted="+ j);
		  con.commit();
		  return true;
	 }else{
		 System.out.println("Insertion Failed");
		 return false;
	 }
	
		 
//	 String sql = "select * from bank.customerinfo ";
//	 System.out.println("@@@"+sql);
//	 pstmt= con.prepareStatement(sql);
//		rs= pstmt.executeQuery();
//		
//		while(rs.next()){
//			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getDate(5)+" "+rs.getInt(6));
//		}
//	//	 con.commit();
//		return j;
	 	
	

	
		


}

public boolean insertBankAccountInfo(Connection con, CustomerBankAccountInfo acntinfo) throws SQLException {
	ResultSet rs = null;
	 PreparedStatement pstmt= null;
	 int j=0;
	 pstmt=con.prepareStatement("insert into bank.custbankaccountinfo values(?,?,?,?,?,?,?)");  
//	 pstmt=con.prepareStatement("DELETE FROM bank.customerinfo");
//	  PreparedStatement   pstmt1 =con.prepareStatement("insert into test.studentaddress values(?,?,?,?,?)"); 
	 
	 pstmt.setInt(1, acntinfo.getCustomerId());
	   pstmt.setLong(2, acntinfo.getCustomerBankAccountNo());  
	   pstmt.setString(3,acntinfo.getBankCode()); 
	   pstmt.setDouble(4, acntinfo.getCustomerAccounttBalance());
	   pstmt.setInt(5, acntinfo.getLastUpDatedStaffId());
	   pstmt.setDate(6, acntinfo.getLastUsedTransactionDate());
	   pstmt.setString(7, acntinfo.getCustomerAccountType());
	   j=pstmt.executeUpdate();

	 if(j>0){
		   System.out.println("no of records inserted="+ j);
		  con.commit();
		  return true;
	 }else{
		 System.out.println("Insertion Failed");
		 return false;
	 }
	
	
	
	
}


public boolean insertBankVaultInfo(Connection con, BankVaultInfo bvi) throws SQLException {
	ResultSet rs = null;
	 PreparedStatement pstmt= null;
	 int j=0;
	 pstmt=con.prepareStatement("insert into bank.bankvaultinfo values(?,?,?,?,?,?)");  
//	 pstmt=con.prepareStatement("DELETE FROM bank.customerinfo");
//	  PreparedStatement   pstmt1 =con.prepareStatement("insert into test.studentaddress values(?,?,?,?,?)"); 
	 
	 pstmt.setString(1, bvi.getBankName());
	   pstmt.setString(2, bvi.getBankCode());  
	   pstmt.setDouble(3, bvi.getBankBalance()); 
	   pstmt.setInt(4,bvi.getLastUpDatedStaffId());
	   pstmt.setInt(5, bvi.getNumberOfAccounts());
	   pstmt.setInt(6, bvi.getNumberOfCustomers() );
	   j=pstmt.executeUpdate();

	 if(j>0){
		   System.out.println("no of records inserted="+ j);
//		  con.commit();
		  return true;
	 }else{
		 System.out.println("Insertion Failed");
		 return false;
	 }
	
	
	
	
}


public int validateNumberGenerate(int randomNumber, Connection con) {
	// TODO Auto-generated method stub
	 Statement st = null;
	 int ranNum = 0;
	try {
		st = con.createStatement();
		String sql = "select CustomerId from bank.customerinfo where CustomerId="+randomNumber;
		 System.out.println("@@@"+sql);
		 ResultSet rs= st.executeQuery("select CustomerId from bank.customerinfo where CustomerId="+randomNumber);
		 while(rs.next()){
				System.out.println("DBID"+rs.getInt(1));
			ranNum = rs.getInt(1);
			}
		 
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	return ranNum;
}

public int validateSearchCustomerInfo(int customerid, Connection con) {
	// TODO Auto-generated method stub
	 Statement st = null;
	 int custid = 0;
	try {
		st = con.createStatement();
		String sql = "select CustomerId from bank.customerinfo where CustomerId="+customerid;
		 System.out.println("@@@"+sql);
		 ResultSet rs= st.executeQuery(sql);
		 while(rs.next()){
				System.out.println("DBID"+rs.getInt(1));
				custid = rs.getInt(1);
			}
		 
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	return custid;
}

@Override
public boolean validateBankCode(Connection con, String bankCode) throws SQLException {
	ResultSet rs = null;
	 PreparedStatement pstmt= null;
	 String sql = "select * from bank.bankvaultinfo where BankCode=?";
	 System.out.println("@@@"+sql);
	 pstmt= con.prepareStatement(sql);
	 pstmt.setString(1,String.valueOf(bankCode));
	 
		rs= pstmt.executeQuery();
		String bnkCode =null;
		String password1 = null;
		while(rs.next()){
			bnkCode = rs.getString("BankCode");
		}
		
		if(bankCode.equals(String.valueOf(bnkCode))){
			return true;
		}else
	return false;

}




}
