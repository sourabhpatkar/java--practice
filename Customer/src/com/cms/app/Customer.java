package com.cms.app;

import java.time.LocalDate;

import com.cms.ServicePlan;

public class Customer implements Comparable<Customer>{
//	 first name, last name email(string),password(string),registrationAmount(double),dob(LocalDate),plan(ServicePlan : enum)
//	 Unique ID - email
	private String fname;
	private String lname;
	private String email;
	private String password;
	private double registrationAmount;
	private ServicePlan plan;
	private LocalDate dob;
	private int customerId;
	private static int idGenerator;

	public Customer(String fname, String lname, String email, String password, double registrationAmount,
			ServicePlan plan, LocalDate dob) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.plan = plan;
		this.dob = dob;
		this.customerId = ++idGenerator;
	}
	
	public Customer (String email) {
		this.email=email;
	}

	@Override
	public String toString() {
		return "customerSignup [fname=" + fname + ", lname=" + lname + ", email=" + email + ", password=" + password
				+ ", registrationAmount=" + registrationAmount + ", ServicePlan=" + plan + ", dob=" + dob
				+ ", customerId=" + customerId + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		//RTTI
		if(o instanceof Customer) {
			Customer c = (Customer)o;
			//equal checking
			return this.email.equals(c.email);
			
		}
		else 
			return false;
	}
	
	@Override
	public int compareTo(Customer newCustomer) {
		return (this.email).compareTo(newCustomer.email);
		
	}
//	
//	@Override
//	public boolean equals

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
		
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getRegistrationAmount() {
		return registrationAmount;
	}

	public void setRegistrationAmount(double registrationAmount) {
		this.registrationAmount = registrationAmount;
	}

	public ServicePlan getPlan() {
		return plan;
	}

	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


}
