package com.lhw.tour.main;

import java.sql.Connection;
import java.sql.DriverManager;

public class main {

	public static void main(String[] args) {
		// ojbc8.jar
		try {
			// DB에서 properties - Connection URL
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			// 연결
			Connection con = DriverManager.getConnection(url, "lhw", "lhw");
			System.out.println("연결됨");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
