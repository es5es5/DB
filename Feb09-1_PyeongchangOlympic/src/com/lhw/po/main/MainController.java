package com.lhw.po.main;

import com.lhw.po.nation.NationController;
import com.lhw.po.player.PlayerController;
import com.lhw.po.sports.SportsController;

public class MainController {
	public static void goSubMenu(int menu) {
		if (menu == 1) { // 나라 메뉴
			NationController.goNationMenu();
		} else if (menu == 2) { // 선수 메뉴
			PlayerController.goPlayerMenu();
		} else if (menu == 3) { // 종목 메뉴
			SportsController.goSportsMenu();
		} else { // 종료
			MainController.goExitMenu();
		}			
	}
	public static void goExitMenu() {
		MainView.showExit();
	}
	public static void main(String[] args) {
		MainView.showMainMenu();
	}
}
