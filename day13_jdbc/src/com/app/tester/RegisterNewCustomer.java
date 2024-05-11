package com.app.tester;

import static com.app.utils.DBUtils.openConnection;
//
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class RegisterNewCustomer {

	public static void main(String[] args) {
		//display all users
		try(Scanner sc = new Scanner(System.in);
				Connection cn = openConnection();
				PreparedStatement ps = cn.prepareStatement("insert into users values(?,?,?,?,?,?,?,?)");
				){
			System.out.println(" id | first_name | last_name | email| password | dob|status | role");
			ps.setInt(1, sc.nextInt());
			ps.setString(2, sc.next());
			ps.setString(3, sc.next());
			ps.setString(4, sc.next());
			ps.setString(5, sc.next());
			Date date1 = Date.valueOf(sc.next());
			ps.setDate(6, date1);
			ps.setBoolean(7, sc.nextBoolean());
			ps.setString(8, sc.next());
			int rowsAffected = ps.executeUpdate();
			
				if(rowsAffected>0)
					System.out.println("Registered Succefully!!  \nHello !!");
				else
					System.out.println("invalid credentials");
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
