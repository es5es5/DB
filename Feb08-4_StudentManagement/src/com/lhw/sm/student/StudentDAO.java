// DAO/DTO 패턴
// Model
// 		Data Access Object : DB에 관련된 작업 전담할 클래스
//		Data Transfer/Temp Object : 작업 결과를 저장할 클래스

package com.lhw.sm.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.lhw.sm.main.SM_MainController;
import com.lhw.sm.main.SM_View;

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
			
			SM_MainController.main(null);
			
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
				SM_View.printRegStudentResult(1);
			} else {
				SM_View.printRegStudentResult(0);
			}
			
			SM_MainController.main(null);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bye(con, pstmt, null);
		}
	}
	public static void updateScore(StudentDTO s) {
		Connection con = null;
		PreparedStatement pstmt = null;
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
				SM_View.printUpdateStudentResult(1);
			} else {
				SM_View.printUpdateStudentResult(0);
			}
			
			SM_MainController.main(null);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bye(con, pstmt, null);
		}
		
	}
	public static void updateName(StudentDTO s) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 연결
			con = connect();
			
			// sql
			String sql = "update fed08_student " + 
					"set s_name = ? " + 
					"where s_no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setInt(2, s.getNo());
			
			// UPDATE
			if (pstmt.executeUpdate() == 1) {
				SM_View.printUpdateStudentResult(1);
			} else {
				SM_View.printUpdateStudentResult(0);
			}
			
			SM_MainController.main(null);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bye(con, pstmt, null);
		}
	}
	public static void showAll() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 학생들
		// [] or List or Set or Map
		// ResultSet -> ArrayList<DTO>
		ArrayList<StudentDTO> students = new ArrayList<>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			int birthYear = 0;
			int nowYear = 0;
			
			con = connect();
			String sql = "select s_no, s_name, s_birthday, "
					+ "(s_mid + s_fin) / 2 as s_avg "
					+ "from feb08_student"
					+ " order by s_no";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			StudentDTO s = null;
			while (rs.next()) {
				s = new StudentDTO();
				s.setName(rs.getString("s_name"));
				s.setBirthday(rs.getDate("s_birthday"));
				s.setNo(rs.getInt("s_no"));
				birthYear = Integer.parseInt(sdf.format(rs.getDate("s_birthday")));
				nowYear = Integer.parseInt(sdf.format(new Date()));
				s.setAge(nowYear - birthYear + 1);
				students.add(s);
			}
			
			if(students.size() == 0) {
				SM_MainController.goShowAll(0, null);
			} else {
				SM_MainController.goShowAll(1, students);
			}
			
			
		} catch (Exception e) {
			SM_MainController.goShowAll(-1, null);
		} finally {
			bye(con, pstmt, rs);
		}
	}
}


