package com.lhw.po.sports;

import com.lhw.po.main.MainController;

public class SportsController {
	public static void goSportsMenu() {
		SportsMenu.show();
	}

	public static void goSubMenu(int menu) {
		if (menu == 1) { // ���� ���
			SportsMenu.showRegMenu();
		} else if (menu == 2) { // ���� ��ȸ

		} else if (menu == 3) { // ���� ����
			SportsMenu.showUpdateMenu();
		} else if (menu == 4) { // ���� ����

		} else {
			MainController.main(null);
		}
	}

	public static void doDBWork(String what, SportsDTO s) {
		if (what.equals("���")) {
			SportsDAO.reg(s);
		} else if (what.equals("����")) {
			SportsDAO.update(s);
		}

	}

	public static void goPrintRegResult(String what) {
		SportsView.printRegResult(what);
	}

	public static void goPrintUpdateResult(String what) {
		SportsView.printUpdateResult(what);

	}
}
