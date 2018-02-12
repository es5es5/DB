package com.lhw.po.sports;

import java.util.ArrayList;

import com.lhw.po.main.MainController;

public class SportsController {
	public static void goSportsMenu() {
		SportsMenu.show();
	}

	public static void goSportsSubMenu(int menu) {
		if (menu == 1) { // ���� ���
			SportsMenu.showRegSportsMenu();
		} else if (menu == 2) { // ���� ��ȸ
			SportsMenu.showSearchSportsMenu();
		} else if (menu == 3) { // ���� ����
			SportsMenu.showUpdateSportsMenu();
		} else if (menu == 4) { // ���� ����
			SportsMenu.showDelSportsMenu();
		} else {
			MainController.main(null);
		}
	}

	public static void doSportsDBWork(String what, SportsDTO s) {
		if (what.equals("���")) {
			SportsDAO.reg(s);
		} else if (what.equals("����")) {
			SportsDAO.update(s);
		} else if (what.equals("�������")) {
			SportsDAO.del(s);
		} else if (what.equals("����˻�")) {
			SportsDAO.search(s);
		} 

	}

	public static void goPrintRegResult(String what) {
		SportsView.printRegResult(what);
	}

	public static void goPrintUpdateResult(String what) {
		SportsView.printUpdateResult(what);

	}

	public static void goPrintDelResult(String what) {
		SportsView.printDelResult(what);		
	}

	public static void goPrintSearchResult(String what, ArrayList<SportsDTO> sports) {
		SportsView.printSearchResult(what, sports);
	}
}
