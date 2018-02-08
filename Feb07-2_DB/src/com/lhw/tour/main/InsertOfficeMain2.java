package com.lhw.tour.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertOfficeMain2 {

	public static void main(String[] args) {
		Connection con = null; // 연결
		PreparedStatement pstmt = null; // DB서버로 명령어를 전송/실행 해주는 놈
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url, "lhw", "lhw");
			System.out.println("연결됨");
			
			System.out.print("호 : ");
			String room = keyboard.next();
			System.out.print("건물 : ");
			String building = keyboard.next();
			System.out.print("층 : ");
			int floor = keyboard.nextInt();
			
			// 자바 변수의 값이 들어와야 할 자리에 ?로
			String sql = "insert into feb07_room values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, room);
			pstmt.setString(2, building);
			pstmt.setInt(3, floor);
			
			// 그 실행 때문에 영향받은 행 수가 리턴
			int row = pstmt.executeUpdate();
			if (row == 1) {
				System.out.println("등록 성공");
			}
		} catch (Exception e) {
		} finally {
			keyboard.close();
			try {pstmt.close();} catch (Exception e) {}
			try {con.close();} catch (Exception e) {}
		}
	}
}
