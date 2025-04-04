package com.utils;

public class CommonUtils {
	
	public void print(String msg) {
		try {
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to print the "+msg);
			
		}
		
	}

}
