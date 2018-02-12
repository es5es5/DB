package com.lhw.po.main;

import com.lhw.po.nation.NationController;
import com.lhw.po.player.PlayerController;
import com.lhw.po.sports.SportsController;

public class MainController {
	

	public static void goSubMenu(int menu) {
		if (menu == 1) {
			NationController.goNationMenu();
		} else if (menu == 2) {
			PlayerController.goPlayerMenu();
		} else if (menu == 3) {
			SportsController.goSportsMenu();
		} else {
			System.out.println("Á¾·á");
		}			
	}
	
	public static void main(String[] args) {
		MainMenu.showMainMenu();
	}

}
