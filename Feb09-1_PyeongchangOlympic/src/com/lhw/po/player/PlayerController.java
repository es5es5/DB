package com.lhw.po.player;

import java.util.ArrayList;

import com.lhw.po.main.MainController;

public class PlayerController {
	public static void goPlayerSubMenu(int menu) {
		if (menu == 1) { // ���� ���
			PlayerMenu.showRegMenu();
		} else if (menu == 2) { // ���� ���� ��ȸ
			PlayerMenu.searchPlayerMenu();
		} else if (menu == 3) { // ���� ����
			PlayerMenu.showUpdatePlayerMedalMenu();
		} else if (menu == 4) { // ���� ����
			PlayerMenu.showDelMenu();
		} else {
			MainController.main(null);
		}
	}
	public static void doPlayerDBWork(String what, PlayerDTO player) {
		if (what.equals("���")) {
			PlayerDAO.reg(player);
		} else if (what.equals("��������")) {
			PlayerDAO.updatePlayerMedal(player);
		} else if (what.equals("��������")) {
			PlayerDAO.delPlayer(player);
		} else if (what.equals("��ȸ")) {
			PlayerDAO.searchPlayer(player);
		}
	}
	public static void goPrintPlayerRegResult(String what) {
		PlayerView.printRegResult(what);
	}
	public static void goPlayerMenu() {
		PlayerMenu.showPlayerMenu();
	}
	public static void goPrintPlayerUpdateResult(String what) {
		PlayerView.printUpdateResult(what);
	}
	public static void goPrintPlayerDelResult(String what) {
		PlayerView.printDelResult(what);		
	}
	public static void goPrintPlayerSearchResult(String what, ArrayList<PlayerDTO> players) {
		PlayerView.printSerchResult(what, players);
	}
}
