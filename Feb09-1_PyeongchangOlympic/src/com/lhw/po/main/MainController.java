package com.lhw.po.main;

import com.lhw.po.nation.NationController;
import com.lhw.po.player.PlayerController;
import com.lhw.po.sports.SportsController;

public class MainController {
	public static void goSubMenu(int menu) {
		if (menu == 1) { // ���� �޴�
			NationController.goNationMenu();
		} else if (menu == 2) { // ���� �޴�
			PlayerController.goPlayerMenu();
		} else if (menu == 3) { // ���� �޴�
			SportsController.goSportsMenu();
		} else { // ����
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
