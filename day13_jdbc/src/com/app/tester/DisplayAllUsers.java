package com.app.tester;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

import static com.app.utils.DBUtils.*;
public class DisplayAllUsers {

	public static void main(String[] args) {
		//display all users
		try(Scanner sc = new Scanner(System.in);
				Connection cn = openConnection();
				PreparedStatement ps = cn.prepareStatement("select* from users where role = 'voter' and dob between ? and ?");
				){
			System.out.println("enter dob and end date");
			Date date1 = Date.valueOf(sc.next());
			Date date2 = Date.valueOf(sc.next());
			ps.setDate(1, date1);
			ps.setDate(2, date2);
			
			try(ResultSet rst = ps.executeQuery()) {
				while(rst.next()) {
				/* id | first_name | last_name | email| password | dob|status | role*/
				System.out.printf("Id %d Name %s %s Email %s pwd %s DoB %s Status %b Rolr %s %n", 
						rst.getInt(1), rst.getString(2),rst.getString(3),
						rst.getString(4),rst.getString(5),rst.getDate(6),rst.getBoolean(7),
						rst.getString(8));// implement class instance	
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
