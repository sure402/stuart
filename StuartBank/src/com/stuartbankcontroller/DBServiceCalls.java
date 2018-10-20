package com.stuartbankcontroller;

import java.sql.Connection;
import java.sql.SQLException;

import com.stuartbank.BankVaultInfo;
import com.stuartbank.CustomerAddress;
import com.stuartbank.CustomerBankAccountInfo;
import com.stuartbank.CustomerInfo;

public interface DBServiceCalls {
	
	public Connection dbConnection(String dbname, String dburl, String dbusername, String dbpassword) throws SQLException, ClassNotFoundException;
	
	public boolean validateuser(Connection con, String name, String password) throws SQLException;
	
	public boolean insertCustomerInfo(Connection con, CustomerInfo custinfo, CustomerAddress custAddress) throws SQLException;
	
	public boolean insertBankAccountInfo(Connection con, CustomerBankAccountInfo acntinfo) throws SQLException;
	
	public boolean insertBankVaultInfo(Connection con, BankVaultInfo bvi) throws SQLException;
	
	public int validateNumberGenerate(int randomNumber, Connection con);

	public int validateSearchCustomerInfo(int customerId, Connection con);
	
	public boolean validateBankCode(Connection con, String bankCode) throws SQLException;
}
