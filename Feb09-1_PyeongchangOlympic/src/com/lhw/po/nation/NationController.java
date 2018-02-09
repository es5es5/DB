package com.lhw.po.nation;

import java.util.ArrayList;

import com.lhw.po.main.MainController;

import oracle.net.resolver.NavAddress;

public class NationController {
	public static void goNationMenu() {
		NationMenu.show();
	}

	public static void doDBWork(String what, NationDTO n) {
		if (what.equals("등록")) {
			NationDAO.reg(n);
		} else if (what.equals("메달수정")) {
			NationDAO.updateMedal(n);
		} else if (what.equals("나라삭제")) {
			NationDAO.delNation(n);
		} else if (what.equals("조회")) {
			NationDAO.searchNation(n);
		}
	}

	public static void goPrintRegResult(String what) {
		NationView.printRegResult(what);
	}

	public static void goSubMenu(int menu) {
		if (menu == 1) { // 나라 등록
			NationMenu.showRegMenu();
		} else if (menu == 2) { // 나라 정보 조회
			NationMenu.searchNationMenu();
		} else if (menu == 3) { // 메달 정보 조회

		} else if (menu == 4) { // 메달 정보 수정
			NationMenu.showUpdateMedal();
		} else if (menu == 5) { // 나라 삭제
			NationMenu.showDelMenu();
		} else {
			MainController.main(null);
		}
	}

	public static void goPrintUpdateResult(String what) {
		NationView.printUpdateResult(what);

	}

	public static void goPrintDelResult(String what) {
		NationView.printDelResult(what);

	}

	public static void goPrintSearchResult(String what, ArrayList<NationDTO> nations) {
		NationView.printSearchResult(what, nations);
	}
}
