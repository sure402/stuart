package com.stuartbank;

public class CustomerAddress {
	
	public static int customerId;
	public static String city;
	public static String state;
	public static String country;
	public static int zipCode;

	
	public static int getCustomerId() {
		return customerId;
	}
	public static void setCustomerId(int customerId) {
		CustomerAddress.customerId = customerId;
	}
	public static String getCity() {
		return city;
	}
	public static void setCity(String city) {
		CustomerAddress.city = city;
	}
	public static String getState() {
		return state;
	}
	public static void setState(String state) {
		CustomerAddress.state = state;
	}
	public static String getCountry() {
		return country;
	}
	public static void setCountry(String country) {
		CustomerAddress.country = country;
	}
	public static int getZipCode() {
		return zipCode;
	}
	public static void setZipCode(int zipCode) {
		CustomerAddress.zipCode = zipCode;
	}
	
	
}
