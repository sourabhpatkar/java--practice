package com.cms.utils;

import static com.cms.validation.validationRules.*;
import java.util.List;

import com.cms.CMSException;
import com.cms.app.Customer;

public class CMSUtils {

	public static Customer authenticCustomer(String email, String password, List<Customer> list) throws CMSException {
		// searching -- by PK -- yes -- contains | index Of
		// contains : not useful -- returns boolean

		// 1. public int indexOf (Object o)
		//

		// 1. check email's validation using "indexOf"
		Customer newCustomer = new Customer(email);
		int index = list.indexOf(newCustomer); // O(n)
		// 2. invalid email: throw custom exception
		if (index == -1)
			throw new CMSException("Invalid email,login failed");
		Customer customer = list.get(index); // O(1)
		// 3. get -- Customer ref -- check password -- invalid -- throw custom exception
		// 4. return the customer reference

		if (customer.getPassword().equals(password)) {
			System.out.println("logged in successfully");

			return customer;
		}
		throw new CMSException("Invalid password");
	}

	public static void changePassword(String email, String oldPassword, String newpassword, List<Customer> customerList)
			throws CMSException {
		// 1. email --> ctor(Customer) -- custObject ref
		Customer c = authenticCustomer(email, oldPassword, customerList);
		validatePassword(newpassword);
		c.setPassword(newpassword);

	}

	public static void deleteUser(String email, String password, List<Customer> customerList) throws CMSException {
		Customer c = authenticCustomer(email, password, customerList);
		Customer newCustomer = new Customer(email);
		int index = customerList.indexOf(newCustomer);
		customerList.remove(index);
	}
	
//	public static void sortEmail(String email, List<Customer> customerList) throws CMSExcepetion {
//		Customer newCustomer = new Customer(email);
//	//	c1 = collections.sort(newCustomer);
//		newCustomer.compareTo
//		System.out.println("after natural sorting: "+ newCustomer);
		
	}
		
		
}
