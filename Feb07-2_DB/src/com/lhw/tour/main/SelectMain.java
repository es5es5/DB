package com.lhw.tour.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectMain {
	public static void main(String[] args) {
		
		Scanner keyboard = null;
		Connection con = null; // 연결
		PreparedStatement pstmt = null; // db에 실제 작업
		ResultSet rs = null; // select한 결과를 담을
		try {
			// 연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url, "kwon", "kwon");
			
			// 입력
			keyboard = new Scanner(System.in);
			System.out.print("교통수단 : ");
			String what = keyboard.next();
			
			// sql
			String sql = "select e_name, o_where, o_floor, o_ho, e_phone " + 
					"from feb07_office, feb07_employee, feb07_damdang " + 
					"where o_ho = e_office and e_phone = d_phone " + 
					"	and d_damdang = ? " + 
					"order by e_name";
			
			// pstmt 만들고
			pstmt = con.prepareStatement(sql);
			
			// ?에 값 채우기
			pstmt.setString(1, what); 
			
			// 실행
			// insert, update, delete : pstmt.executeUpdate();
			// select
			rs = pstmt.executeQuery();
			
			// rs.next(); : 다음 데이터로 가기
			//				다음 데이터가 없으면 false, 있으면 true
			while (rs.next() == true) {
				// rs.getString("e_name") : 현재 데이터의 e_name필드 값
				System.out.println( rs.getString("e_name") );
				System.out.println( rs.getString("o_where") );
				System.out.println( rs.getInt("o_floor") );
				System.out.println( rs.getString("o_ho") );
				System.out.println( rs.getString("e_phone") );
				System.out.println("-----");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			keyboard.close();
			try {rs.close();} catch (Exception e) {}
			try {pstmt.close();} catch (Exception e) {}
			try {con.close();} catch (Exception e) {}
		}
		
	}
}







