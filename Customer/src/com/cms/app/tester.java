package com.cms.app;

import static com.cms.validation.validationRules.validateCustomer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.cms.CMSException;

import static com.cms.utils.CMSUtils.*;
public class tester {
	public static void main(String[] args) throws CMSException {

		List<Customer> customerList = new ArrayList<>();

		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			while (!exit) {
				System.out.println(
						"Enter 0 to exit: \n1.SignUp \n2.Display \n3.SignIn \n4.ChangePassword \n5.Unsubscribe \n6.SortEmail");
				try {
					switch (sc.nextInt()) {
					case 0:
						exit = true;
						break;

					case 1:
						System.out.println("Enter fname,lname,email,password, registrationAmount, "
								+ "ServicePlan, dob, customerId");
						Customer newCustomer = validateCustomer(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next(), customerList);

						customerList.add(newCustomer);
						System.out.println("registration successfull");

						break;

					case 2:
						for (Customer c : customerList) {
							System.out.println(c);
						}
						break;

					case 3: // login
						System.out.println("enter email and password");
						newCustomer = authenticCustomer(sc.next(), sc.next(), customerList);
						System.out.println("succesfull login, your details" + customerList);
						break;
					case 4: // change password
						System.out.println("enter email, old pwd and new pwd");
//						newCustomer = CMSUtils.authenticCustomer(sc.next(), sc.next(), customerList);
//						// change password
//						newCustomer.setPassword(sc.next());
//						System.out.println("Password changed! ");
						 changePassword(sc.next(), sc.next(),sc.next(),customerList);
						break;
					case 5: // un-subscribe
						System.out.println("enter email and password to delete user");
						deleteUser(sc.next(), sc.next(), customerList);
						System.out.println("user deleted successfully");
						break;
						
					case 6: //Display customer details sorted as per the email (asc) : using natural ordering
						Collections.sort(customerList);
						System.out.println("sorted according to email"+customerList);
					case 7: //Display customer details sorted as per the dob n last name  : using custom ordering , using anonymous inner class.
						
    	
                     }
				} catch (Exception e) {

					System.out.println(e);
					sc.nextLine();
				}
			}
		}

	}

}
