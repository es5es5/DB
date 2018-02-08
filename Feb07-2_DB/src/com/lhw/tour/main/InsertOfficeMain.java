package com.lhw.tour.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertOfficeMain {

	public static void main(String[] args) {
		Connection con = null; // 연결
		PreparedStatement pstmt = null; // DB서버로 명령어를 전송/실행 해주는 놈
		try {
			// 접속할 DB 서버 주소
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			// 접속할 때 OracleDriver를 써야한다고 java에게 알려줌
			// 자동으로 찾을 수 있음..
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "lhw", "lhw");
			System.out.println("연결됨");

			// sql 문
			String sql = "insert into feb07_room values(501,'본관',5)";
			pstmt = con.prepareStatement(sql);
			// 서버로 전송/실행하기
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 만든 역순으로 닫으셈 (Connection을 마지막으로 닫으셈)
			try {pstmt.close();} catch (Exception e) {}
			try {con.close();} catch (Exception e) {}
		}
	}
}
