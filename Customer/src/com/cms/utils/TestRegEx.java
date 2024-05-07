package com.cms.utils;

public class TestRegEx {

	public static void main(String password) {
		String regEx = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";
		if (password.matches(regEx)) {
			System.out.println("password conditions matched!!!!");
		} else
			System.out.println("enter a strong password!!!");

	}
}
