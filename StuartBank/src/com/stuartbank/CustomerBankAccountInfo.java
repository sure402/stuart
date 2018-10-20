package com.stuartbank;


import java.sql.Date;

public class CustomerBankAccountInfo {
	public static int customerId;
	public static long customerBankAccountNo;
	public static String bankCode;
	public static double customerAccounttBalance;
	public static int lastUpDatedStaffId;
	public static Date lastUsedTransactionDate;
	public static String customerAccountType;
	
//	 public CustomerBankAccountInfo(int customerId, long customerBankAccountNo, String bankCode, 
//			 double customerAccounttBalance, int lastUpDatedStaffId, Date lastUsedTransactionDate, String customerAccountType) 
//	    { 
//	        this.customerId = customerId; 
//	        this.customerBankAccountNo = customerBankAccountNo; 
//	        this.bankCode = bankCode; 
//	        this.customerAccounttBalance = customerAccounttBalance; 
//	        this.lastUpDatedStaffId = lastUpDatedStaffId; 
//	        this.lastUsedTransactionDate = lastUsedTransactionDate;
//	        this.customerAccountType = customerAccountType;
//	    } 
	
	public static int getCustomerId() {
		return customerId;
	}
	public static void setCustomerId(int customerId) {
		CustomerBankAccountInfo.customerId = customerId;
	}
	public static long getCustomerBankAccountNo() {
		return customerBankAccountNo;
	}
	public static void setCustomerBankAccountNo(long customerBankAccountNo) {
		CustomerBankAccountInfo.customerBankAccountNo = customerBankAccountNo;
	}
	public static String getCustomerAccountType() {
		return customerAccountType;
	}
	public static void setCustomerAccountType(String customerAccountType) {
		CustomerBankAccountInfo.customerAccountType = customerAccountType;
	}
	public static String getBankCode() {
		return bankCode;
	}
	public static void setBankCode(String bankCode) {
		CustomerBankAccountInfo.bankCode = bankCode;
	}
	public static double getCustomerAccounttBalance() {
		return customerAccounttBalance;
	}
	public static void setCustomerAccounttBalance(double customerAccounttBalance) {
		CustomerBankAccountInfo.customerAccounttBalance = customerAccounttBalance;
	}
	public static int getLastUpDatedStaffId() {
		return lastUpDatedStaffId;
	}
	public static void setLastUpDatedStaffId(int lastUpDatedStaffId) {
		CustomerBankAccountInfo.lastUpDatedStaffId = lastUpDatedStaffId;
	}
	public static Date getLastUsedTransactionDate() {
		return lastUsedTransactionDate;
	}
	public static void setLastUsedTransactionDate(Date lastUsedTransactionDate) {
		CustomerBankAccountInfo.lastUsedTransactionDate = lastUsedTransactionDate;
	}

}
