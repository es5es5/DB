package com.lhw.po.sports;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.lhw.po.main.DBManager;

public class SportsDAO {
	public static void reg(SportsDTO s) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();
			String sql = "insert into FEB09_sports values(feb09_sports_seq.nextval, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getDetail());
			
			// INSERT
			if (pstmt.executeUpdate() == 1) {
				SportsController.goPrintRegResult("성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			SportsController.goPrintRegResult("망함~~~~~~~~~~~");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public static void update(SportsDTO s) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();
			String sql = "update feb09_sports " + 
					"set s_name =?, s_detail = ? " + 
					"where s_no=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getDetail());
			pstmt.setInt(3, s.getNo());
			
			// UPDATE
			if (pstmt.executeUpdate() == 1) {
				SportsController.goPrintUpdateResult("성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			SportsController.goPrintUpdateResult("ㄴㄴㄴㄴ");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public static void del(SportsDTO s) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();
			String sql = "delete from FEB09_SPORTS where s_name = ? and s_detail=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getDetail());
			
			// UPDATE
			if (pstmt.executeUpdate() == 1) {
				SportsController.goPrintDelResult("성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			SportsController.goPrintDelResult("ㄴㄴㄴㄴ");
		} finally {
			DBManager.close(con, pstmt, null);
		}		
	}

	public static void search(SportsDTO s) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 연결
			con = DBManager.connect();
			// sql
			
			// Java에서 Oracle 명령어 LIKE 쓸 때 사용 법... 거지같네요
			String sql = "select * from feb09_sports where s_name like '%'||?||'%' and s_detail like '%'||?||'%'";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getDetail());

			// SELECT
			rs = pstmt.executeQuery();
			
			ArrayList<SportsDTO> sports = new ArrayList<>();
			SportsDTO ss = null;
			
			while (rs.next()) {
				ss = new SportsDTO(rs.getInt("s_no"), rs.getString("s_name"), rs.getString("s_detail"));
				sports.add(ss);
			}
			
			if (sports.size() == 0) {
				SportsController.goPrintSearchResult("없는종목", null);
			} else {
				SportsController.goPrintSearchResult("성공", sports);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			SportsController.goPrintSearchResult("실패", null);
			
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

}
