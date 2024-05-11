package com.app.tester;

import static com.app.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TestPreparedStatement {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				// get db cn
				Connection cn = openConnection();
				// create a pre-compiled statement to hold SQL
				PreparedStatement pst = cn.prepareStatement("select* from users where email=? and password=?")){
				System.out.println("Enter Email and Password");
				// set IN parameters: public void setType(int paramIndex,Type value) throw SQLException
				pst.setString(1, sc.next()); // email
				pst.setString(2, sc.next()); // password
				// execute the query
				try(ResultSet rst = pst.executeQuery()){
                // ResultSet method : Type getType(column position or name)
					if(rst.next())
						System.out.println("Login successfull "+ rst.getString(2)+ rst.getString(3));
					else
						System.out.println("Invalid login credentials");
				} // rst close
				 
		
		} // JVM : pst.close(),cn.close()==> cleaning up of db resources
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
