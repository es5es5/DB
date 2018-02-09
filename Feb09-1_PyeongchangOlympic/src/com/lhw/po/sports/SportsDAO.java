package com.lhw.po.sports;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
				SportsController.goPrintRegResult("撩奢");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			SportsController.goPrintRegResult("蜂л~~~~~~~~~~~");
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
				SportsController.goPrintUpdateResult("撩奢");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			SportsController.goPrintUpdateResult("中中中中");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

}
