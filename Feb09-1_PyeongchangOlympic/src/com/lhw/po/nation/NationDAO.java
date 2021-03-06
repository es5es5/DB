package com.lhw.po.nation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.lhw.po.main.DBManager;

public class NationDAO {
	
	public static void reg(NationDTO n) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();
			String sql = "insert into FEB09_nation values(?, ?, ?, 0, 0, 0)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, n.getName());
			pstmt.setString(2, n.getContinent());
			pstmt.setInt(3, n.getPopulation());
			
			// INSERT
			if (pstmt.executeUpdate() == 1) {
				NationController.goPrintNationRegResult("失因");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			NationController.goPrintNationRegResult("叔鳶");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public static void updateMedal(NationDTO n) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 尻衣
			con = DBManager.connect();
			// sql
			String sql = "update feb09_nation " + 
					"set n_gold=?, n_silver=?, n_bronze=? " + 
					"where n_name=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(4, n.getName());
			pstmt.setInt(1, n.getGold());
			pstmt.setInt(2, n.getSilver());
			pstmt.setInt(3, n.getBronze());
			
			// UPDATE
			if (pstmt.executeUpdate() == 1) {
				NationController.goNationPrintUpdateResult("失因");
			} else {
				NationController.goNationPrintUpdateResult("いいいいい");
			}
			NationMenu.showNationMenu();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public static void delNation(NationDTO n) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 尻衣
			con = DBManager.connect();
			// sql
			String sql = "delete from feb09_nation where n_name = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, n.getName());
			
			// UPDATE
			if (pstmt.executeUpdate() == 1) {
				NationController.goNationPrintDelResult("失因");
			} else {
				NationController.goNationPrintDelResult("いいいいい");
			}
			NationMenu.showNationMenu();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public static void searchNationInfo(NationDTO n) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 尻衣
			con = DBManager.connect();
			// sql
			
			// Java拭辞 Oracle 誤敬嬢 LIKE 承 凶 紫遂 狛... 暗走旭革推
			String sql = "select * from feb09_nation where n_name like '%'||?||'%'";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, n.getName());

			// SELECT
			rs = pstmt.executeQuery();
			
			ArrayList<NationDTO> nations = new ArrayList<>();
			NationDTO nn = null;
			while (rs.next()) {
				nn = new NationDTO();
				nn.setName(rs.getString("n_name"));
				nn.setContinent(rs.getString("n_continent"));
				nn.setPopulation(rs.getInt("n_population"));
				nn.setGold(rs.getInt("n_gold"));
				nn.setSilver(rs.getInt("n_silver"));
				nn.setBronze(rs.getInt("n_Bronze"));
				
				nations.add(nn);
			}
			
			if (nations.size() == 0) {
				NationController.goNationPrintSearchResult("蒸澗蟹虞", null);
			} else {
				NationController.goNationPrintSearchResult("失因", nations);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			NationController.goNationPrintSearchResult("叔鳶", null);
			
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void searchNationMedelInfo(NationDTO n) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 尻衣
			con = DBManager.connect();
			// sql
			
			// Java拭辞 Oracle 誤敬嬢 LIKE 承 凶 紫遂 狛... 暗走旭革推 ( '%'||?||'%' )
			String sql = "select * from FEB09_NATION where n_name like '%'||?||'%'";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, n.getName());

			// SELECT
			rs = pstmt.executeQuery();
			
			ArrayList<NationDTO> nations = new ArrayList<>();
			NationDTO nn = null;
			while (rs.next()) {
				nn = new NationDTO();
				nn.setName(rs.getString("n_name"));
				nn.setGold(rs.getInt("n_gold"));
				nn.setSilver(rs.getInt("n_silver"));
				nn.setBronze(rs.getInt("n_Bronze"));
				
				nations.add(nn);
			}
			
			if (nations.size() == 0) {
				NationController.goNationPrintSearchMedalResult("蒸澗蟹虞", null);
			} else {
				NationController.goNationPrintSearchMedalResult("失因", nations);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			NationController.goNationPrintSearchMedalResult("叔鳶", null);
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void searchAllInfo() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 尻衣
			con = DBManager.connect();
			
			String sql = "select * from FEB09_NATION";
			
			pstmt = con.prepareStatement(sql);

			// SELECT
			rs = pstmt.executeQuery();
			
			ArrayList<NationDTO> nations = new ArrayList<>();
			NationDTO nn = null;
			while (rs.next()) {
				nn = new NationDTO();
				nn.setName(rs.getString("n_name"));
				nn.setGold(rs.getInt("n_gold"));
				nn.setSilver(rs.getInt("n_silver"));
				nn.setBronze(rs.getInt("n_Bronze"));
				nations.add(nn);
			}
			if (nations.size() == 0) {
				NationController.goNationPrintSearchMedalResult("蒸澗蟹虞", null);
			} else {
				NationController.goNationPrintSearchMedalResult("失因", nations);
			}
		} catch (Exception e) {
			e.printStackTrace();
			NationController.goNationPrintSearchMedalResult("叔鳶", null);
		} finally {
			DBManager.close(con, pstmt, rs);
		}		
	}
}

