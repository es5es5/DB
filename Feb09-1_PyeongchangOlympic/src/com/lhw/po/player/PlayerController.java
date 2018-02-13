package com.lhw.po.player;

import java.util.ArrayList;

import com.lhw.po.main.MainController;

public class PlayerController {
	public static void goPlayerSubMenu(int menu) {
		if (menu == 1) { // 선수 등록
			PlayerMenu.showRegMenu();
		} else if (menu == 2) { // 선수 정보 조회
			PlayerMenu.searchPlayerMenu();
		} else if (menu == 3) { // 선수 수정
			PlayerMenu.showUpdatePlayerMedalMenu();
		} else if (menu == 4) { // 선수 삭제
			PlayerMenu.showDelMenu();
		} else {
			MainController.main(null);
		}
	}
	public static void doPlayerDBWork(String what, PlayerDTO player) {
		if (what.equals("등록")) {
			PlayerDAO.reg(player);
		} else if (what.equals("선수수정")) {
			PlayerDAO.updatePlayerMedal(player);
		} else if (what.equals("선수삭제")) {
			PlayerDAO.delPlayer(player);
		} else if (what.equals("조회")) {
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
