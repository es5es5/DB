package com.lhw.po.nation;

import java.util.ArrayList;

import com.lhw.po.main.MainController;

public class NationController {
	public static void goNationMenu() {
		NationMenu.showNationMenu();
	}
	public static void doNationDBWork(String what, NationDTO n) {
		if (what.equals("등록")) {
			NationDAO.reg(n);
		} else if (what.equals("메달수정")) {
			NationDAO.updateMedal(n);
		} else if (what.equals("나라삭제")) {
			NationDAO.delNation(n);
		} else if (what.equals("나라조회")) {
			NationDAO.searchNationInfo(n);
		} else if (what.equals("메달조회")) {
			NationDAO.searchNationMedelInfo(n);
		}
	}
	public static void goPrintRegResult(String what) {
		NationView.printRegResult(what);
	}
	public static void goSubMenu(int menu) {
		if (menu == 1) { // 나라 등록
			NationMenu.showRegMenu();
		} else if (menu == 2) { // 나라 정보 조회
			NationMenu.searchNationInfoMenu();
		} else if (menu == 3) { // 메달 정보 조회
			NationMenu.searchNationMedalMenu();
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
	public static void goPrintSearchMedalResult(String what, ArrayList<NationDTO> nations) {
		NationView.printSearchMedalResult(what, nations);
	}
}
