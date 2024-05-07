package com.cms.validation;

import java.time.LocalDate;
import java.util.List;
import com.cms.CMSException;
import com.cms.ServicePlan;
import com.cms.app.Customer;

public class validationRules {

	public static ServicePlan validateServicePlan(String Splan, double cost) throws CMSException {
//		ServicePlan Spl = ServicePlan.valueOf(Splan.toUpperCase());
		ServicePlan spl = ServicePlan.valueOf(Splan.toUpperCase());
		if (spl.getplanCost() == cost)
			return spl;
		throw new CMSException("Invalid Service plan or amount");
	}

// add a method to check for duplicate customers(by email)
	public static void checkForDupCustomer(String email, List<Customer> customerList) throws CMSException {
		// 1. create customer class instance wrapping PK

		Customer newCustomer = new Customer(email);
		if (customerList.contains(newCustomer))
			throw new CMSException("Email exists!!");
	}

	public static Customer validateCustomer(String fname, String lname, String email, String password,
			double registrationAmount, String servicePlan, String dob, List<Customer> customerList) throws CMSException {
//	checkForDupCustomer(email,customerList);
		ServicePlan spl = validateServicePlan(servicePlan, registrationAmount);
		checkForDupCustomer(email, customerList);
		LocalDate date = LocalDate.parse(dob);
		validatePassword(password);
		return new Customer(fname, lname, email, password, registrationAmount, spl, date);
	}

	public static void validatePassword(String password) throws CMSException {
		String regEx = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";
		if (!password.matches(regEx)) {
			throw new CMSException("Invalid Password!!!");
		} else
			System.out.println("password validated");
	}}

//  change password
	


