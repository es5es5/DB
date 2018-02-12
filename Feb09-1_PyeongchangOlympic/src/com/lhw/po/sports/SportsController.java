package com.lhw.po.sports;

import java.util.ArrayList;

import com.lhw.po.main.MainController;

public class SportsController {
	public static void goSportsMenu() {
		SportsMenu.show();
	}

	public static void goSportsSubMenu(int menu) {
		if (menu == 1) { // 종목 등록
			SportsMenu.showRegSportsMenu();
		} else if (menu == 2) { // 종목 조회
			SportsMenu.showSearchSportsMenu();
		} else if (menu == 3) { // 종목 수정
			SportsMenu.showUpdateSportsMenu();
		} else if (menu == 4) { // 종목 삭제
			SportsMenu.showDelSportsMenu();
		} else {
			MainController.main(null);
		}
	}

	public static void doSportsDBWork(String what, SportsDTO s) {
		if (what.equals("등록")) {
			SportsDAO.reg(s);
		} else if (what.equals("수정")) {
			SportsDAO.update(s);
		} else if (what.equals("종목삭제")) {
			SportsDAO.del(s);
		} else if (what.equals("종목검색")) {
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
