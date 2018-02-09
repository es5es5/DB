package com.lhw.po.sports;

import com.lhw.po.main.MainController;

public class SportsController {
	public static void goSportsMenu() {
		SportsMenu.show();
	}

	public static void goSubMenu(int menu) {
		if (menu == 1) { // 종목 등록
			SportsMenu.showRegMenu();
		} else if (menu == 2) { // 종목 조회

		} else if (menu == 3) { // 종목 수정
			SportsMenu.showUpdateMenu();
		} else if (menu == 4) { // 종목 삭제

		} else {
			MainController.main(null);
		}
	}

	public static void doDBWork(String what, SportsDTO s) {
		if (what.equals("등록")) {
			SportsDAO.reg(s);
		} else if (what.equals("수정")) {
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
