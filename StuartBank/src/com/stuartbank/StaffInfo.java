package com.stuartbank;

import java.util.Date;

public class StaffInfo {
	
	public static int staffId;
	public static int bankCode;
	public static String staffFirstName;
	public static String staffLaststName;
	public static int age;
	public static boolean isManager;
	public static String staffPrivelage;
	public static String password;
	
	public static int getStaffId() {
		return staffId;
	}
	public static void setStaffId(int staffId) {
		StaffInfo.staffId = staffId;
	}
	public static int getBankCode() {
		return bankCode;
	}
	public static void setBankCode(int bankCode) {
		StaffInfo.bankCode = bankCode;
	}
	public static String getStaffFirstName() {
		return staffFirstName;
	}
	public static void setStaffFirstName(String staffFirstName) {
		StaffInfo.staffFirstName = staffFirstName;
	}
	public static String getStaffLaststName() {
		return staffLaststName;
	}
	public static void setStaffLaststName(String staffLaststName) {
		StaffInfo.staffLaststName = staffLaststName;
	}
	public static int getAge() {
		return age;
	}
	public static void setAge(int age) {
		StaffInfo.age = age;
	}
	public static boolean isManager() {
		return isManager;
	}
	public static void setManager(boolean isManager) {
		StaffInfo.isManager = isManager;
	}
	public static String getStaffPrivelage() {
		return staffPrivelage;
	}
	public static void setStaffPrivelage(String staffPrivelage) {
		StaffInfo.staffPrivelage = staffPrivelage;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		StaffInfo.password = password;
	}
	
	
}
