//Connection : 연결
//	서버에 연결될 수 있는 수가 한정
//	con.close()할 때 연결이 끊어짐
//	
//PreparedStatement : sql 수행하는 녀석
//	연결 하나당 만들 수 있는 수가 한정
//	pstmt.close()로 그 녀석 죽이기


package com.lhw.sm.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import oracle.net.aso.k;

public class SMMain {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Connection con = null; // 연결 (close할 때 연결 끊김, 개수 한정)
		PreparedStatement pstmt = null; // sql 수행 (한 con에 만들 수 있는 개수 한정 약 500개)
		int menu = 0;
		String sql = "";
		ResultSet rs =null;
		
		SimpleDateFormat sdf = null;
		sdf = new SimpleDateFormat("yyyy");
		int birthYear = 0;
		int nowYear = 0;
		int no = 0;
		double mid = 0;
		double fin = 0;
		String name = "";
		String birthday = "";
		
		try {
			// DB 서버 주소
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			// 연결
			while (true) {
				System.out.println("-------------");
				System.out.println("1. 학생 등록");
				System.out.println("2. 학생 조회");
				System.out.println("3. 점수 수정");
				System.out.println("4. 이름 수정");
				System.out.println("5. 학생 삭제");
				System.out.println("4. 종료");
				System.out.println("-------------");
				System.out.print("메뉴 : ");

				menu = keyboard.nextInt();
				if (menu == 1) {
					con = DriverManager.getConnection(url, "lhw", "lhw");
					System.out.print("이름 : ");
					name = keyboard.next();
					System.out.print("생일(YYYYMMDD) : ");
					birthday = keyboard.next();
					System.out.print("중간 : ");
					mid = keyboard.nextDouble();
					System.out.print("기말 : ");
					fin = keyboard.nextDouble();

					sql = "insert into feb08_student values("
							+ "feb08_student_seq.nextval, ?, to_date(?,'YYYYMMDD'), ?,?" 
							+ ")";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, birthday);
					pstmt.setDouble(3, mid);
					pstmt.setDouble(4, fin);
					
					// INSERT
					if (pstmt.executeUpdate() == 1) {
						System.out.println("성공");
					}
					
					pstmt.close();
					con.close();
					
				} else if (menu == 2) {
					con = DriverManager.getConnection(url, "lhw", "lhw");
					sql = "select s_no, s_name, s_birthday, (s_mid+s_fin)/2 as s_avg from feb08_student order by s_no desc";
					pstmt = con.prepareStatement(sql);
					
					// SELECT
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						System.out.println(rs.getInt("s_no") + ")");
						System.out.println("이름 : " + rs.getString("s_name"));
						System.out.println("생일 : " + rs.getDate("s_birthday"));
						
						// 나이 계산
						birthYear = Integer.parseInt(sdf.format(rs.getDate("s_birthday")));
						nowYear = Integer.parseInt(sdf.format(new Date()));
						System.out.println("나이 : " + (nowYear - birthYear + 1) + "살");
						
						System.out.println("평균 : " + rs.getDouble("s_avg") + "점");
						System.out.println("-----");
					}
					
					rs.close();
					pstmt.close();
					con.close();
					
				} else if (menu == 3) {
					con = DriverManager.getConnection(url, "lhw", "lhw");
					System.out.println("학생 번호 : ");
					no = keyboard.nextInt();
					System.out.println("중간고사 : ");
					mid = keyboard.nextDouble();
					System.out.println("기말고사 : ");
					fin = keyboard.nextDouble();
					
					sql = "update feb08_student " + 
							"set s_mid=?, s_fin=? " + 
							"where s_no = ?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(3, no);
					pstmt.setDouble(1, mid);
					pstmt.setDouble(2, fin);
					
					if (pstmt.executeUpdate() == 1) {
						System.out.println("수정 성공");
					}
					pstmt.close();
					con.close();
					
				} else if (menu == 4) {
					con = DriverManager.getConnection(url, "lhw", "lhw");
					System.out.println("학생 번호 : ");
					no = keyboard.nextInt();
					System.out.println("바꿀 이름 : ");
					name = keyboard.next();
					
					sql = "update feb08_student " + 
							"set s_name = ? " + 
							"where s_no = ?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(2, no);
					pstmt.setString(1, name);
					
					if (pstmt.executeUpdate() == 1) {
						System.out.println("수정 성공");
					}
					pstmt.close();
					con.close();
					
				} else if (menu == 5) {
					con = DriverManager.getConnection(url, "lhw", "lhw");
					System.out.println("삭제할 번호 : ");
					no = keyboard.nextInt();
					
					sql = "delete from FEB08_STUDENT " + 
							"where s_no = ?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, no);
					if (pstmt.executeUpdate() == 1) {
						System.out.println("삭제 성공");
					}
					pstmt.close();
					con.close();
					
				} else {
					System.out.println("종료");
					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			keyboard.close();
			try {pstmt.close();} catch (Exception e) {}
			try {con.close();} catch (Exception e) {}
		}
		
	}

}
