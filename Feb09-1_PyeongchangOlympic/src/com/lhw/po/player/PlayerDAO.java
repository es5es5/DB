package com.lhw.po.player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.lhw.po.main.DBManager;

public class PlayerDAO {

	public static void reg(PlayerDTO player) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();
			String sql = "insert into FEB09_player values(feb09_player_seq.nextval, ?, ?, 0, 0, 0)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, player.getName());
			pstmt.setString(2, player.getFrom());
			
			// INSERT
			if (pstmt.executeUpdate() == 1) {
				PlayerController.goPrintPlayerRegResult("����");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			PlayerController.goPrintPlayerRegResult("����~~~~~~~~~~~");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public static void updatePlayerMedal(PlayerDTO player) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();
			String sql = "update FEB09_PLAYER " + 
					"set p_gold=?, p_silver=?, p_bronze=? " + 
					"where p_name =?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, player.getGold());
			pstmt.setInt(2, player.getSilver());
			pstmt.setInt(3, player.getBronze());
			pstmt.setString(4, player.getName());
			
			// UPDATE
			if (pstmt.executeUpdate() == 1) {
				PlayerController.goPrintPlayerUpdateResult("����");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			PlayerController.goPrintPlayerUpdateResult("����~~~~~~~~~~~");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public static void delPlayer(PlayerDTO player) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();
			String sql = "delete from FEB09_PLAYER where p_name = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, player.getName());
			
			// DELETE
			if (pstmt.executeUpdate() == 1) {
				PlayerController.goPrintPlayerDelResult("����");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			PlayerController.goPrintPlayerUpdateResult("����~~~~~~~~~~~");
		} finally {
			DBManager.close(con, pstmt, null);
		}		
	}

	public static void searchPlayer(PlayerDTO player) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// ����
			con = DBManager.connect();
			
			// Java���� Oracle ��ɾ� LIKE �� �� ��� ��... �������׿�
			String sql = "select * from feb09_player where p_name like '%'||?||'%'";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, player.getName());

			// SELECT
			rs = pstmt.executeQuery();
			
			ArrayList<PlayerDTO> players = new ArrayList<>();
			PlayerDTO pp = null;
			while (rs.next()) {
				pp = new PlayerDTO();
				pp.setName(rs.getString("p_name"));
				pp.setFrom(rs.getString("p_from"));
				pp.setGold(rs.getInt("p_gold"));
				pp.setSilver(rs.getInt("p_silver"));
				pp.setBronze(rs.getInt("p_bronze"));
				
				players.add(pp);
			}
			if (players.size() == 0) {
				PlayerController.goPrintPlayerSearchResult("���¼���", null);
			} else {
				PlayerController.goPrintPlayerSearchResult("����", players);
			}
		} catch (Exception e) {
			e.printStackTrace();
			PlayerController.goPrintPlayerSearchResult("����", null);
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
}
