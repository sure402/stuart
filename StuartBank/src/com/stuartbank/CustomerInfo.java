package com.stuartbank;

import java.sql.Date;

public class CustomerInfo {
	
	public static int customerId;
	public static String customerFirstName;
	public static String customerLaststName;
	public static int age;
	public static Date DateOfBirth;
//	public static Date accountOpenDate;
//	public static Date accountCloseDate;
	public static int lastUpDatedStaffId;
	
	public static int getCustomerId() {
		return customerId;
	}
	public static void setCustomerId(int customerId) {
		CustomerInfo.customerId = customerId;
	}
	public static String getCustomerFirstName() {
		return customerFirstName;
	}
	public static String setCustomerFirstName(String customerFirstName) {
		return CustomerInfo.customerFirstName = customerFirstName;
	}
	public static String getCustomerLaststName() {
		return customerLaststName;
	}
	public static void setCustomerLaststName(String customerLaststName) {
		CustomerInfo.customerLaststName = customerLaststName;
	}
	public static int getAge() {
		return age;
	}
	public static void setAge(int age) {
		CustomerInfo.age = age;
	}
	public static Date getDateOfBirth() {
		return DateOfBirth;
	}
	public static void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
//	public static Date getAccountOpenDate() {
//		return accountOpenDate;
//	}
//	public static void setAccountOpenDate(Date accountOpenDate) {
//		CustomerInfo.accountOpenDate = accountOpenDate;
//	}
//	public static Date getAccountCloseDate() {
//		return accountCloseDate;
//	}
//	public static void setAccountCloseDate(Date accountCloseDate) {
//		CustomerInfo.accountCloseDate = accountCloseDate;
//	}
	public static int getLastUpDatedStaffId() {
		return lastUpDatedStaffId;
	}
	public static void setLastUpDatedStaffId(int lastUpDatedStaffId) {
		CustomerInfo.lastUpDatedStaffId = lastUpDatedStaffId;
	}
}
