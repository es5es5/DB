package com.lhw.sm.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lhw.sm.main.SMMain_C_Main;

public class StudentDAO {
	public static Connection connect() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		return (DriverManager.getConnection(url, "lhw", "lhw"));
	}
	public static void bye(
			Connection con
			, PreparedStatement pstmt
			, ResultSet rs) {
		try {rs.close();} catch (Exception e) {}
		try {pstmt.close();} catch (Exception e) {}
		try {con.close();} catch (Exception e) {}
	}
	public static void reg(StudentDTO s) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 연결
			con = connect();
			
			// sql
			String sql = "insert into feb08_student values("
					+ "feb08_student_seq.nextval, ?, to_date(?,'YYYYMMDD'), ?,?" 
					+ ")";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getBirthday2());
			pstmt.setDouble(3, s.getMid());
			pstmt.setDouble(4, s.getFin());
			
			// INSERT
			if (pstmt.executeUpdate() == 1) {
				System.out.println("성공");
			}
			
			SMMain_C_Main.main(null);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bye(con, pstmt, null);
		}
		System.out.println("등록 완료");
	}
	public static void get() {

	}
	public static void insert() {
	}
	public static void del(StudentDTO s) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 연결
			con = connect();
			
			// sql
			String sql = "delete from FEB08_STUDENT " + 
					"where s_no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s.getNo());
			
			// INSERT
			if (pstmt.executeUpdate() == 1) {
				System.out.println("성공");
			}
			
			SMMain_C_Main.main(null);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bye(con, pstmt, null);
		}
	}
	public static void update(StudentDTO s) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 연결
			con = connect();
			
			// sql
			String sql = "update feb08_student " + 
					"set s_mid=?, s_fin=? " + 
					"where s_no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, s.getMid());
			pstmt.setDouble(2, s.getFin());
			pstmt.setInt(3, s.getNo());
			
			// UPDATE
			if (pstmt.executeUpdate() == 1) {
				System.out.println("성공");
			}
			
			SMMain_C_Main.main(null);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bye(con, pstmt, rs);
		}
	}
}


