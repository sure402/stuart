package com.stuartbank;

public class BankVaultInfo {

	public static String bankName;
	public static String bankCode;
	public static double bankBalance;
	public static int lastUpDatedStaffId;
	public static int numberOfAccounts;
	public static int numberOfCustomers;
	
	
	public static String getBankName() {
		return bankName;
	}
	public static void setBankName(String bankName) {
		BankVaultInfo.bankName = bankName;
	}
	public static String getBankCode() {
		return bankCode;
	}
	public static void setBankCode(String bankCode) {
		BankVaultInfo.bankCode = bankCode;
	}
	public static double getBankBalance() {
		return bankBalance;
	}
	public static void setBankBalance(double bankBalance) {
		BankVaultInfo.bankBalance = bankBalance;
	}
	public static int getLastUpDatedStaffId() {
		return lastUpDatedStaffId;
	}
	public static void setLastUpDatedStaffId(int lastUpDatedStaffId) {
		BankVaultInfo.lastUpDatedStaffId = lastUpDatedStaffId;
	}
	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	public static void setNumberOfAccounts(int numberOfAccounts) {
		BankVaultInfo.numberOfAccounts = numberOfAccounts;
	}
	public static int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	public static void setNumberOfCustomers(int numberOfCustomers) {
		BankVaultInfo.numberOfCustomers = numberOfCustomers;
	}
	
	
}
