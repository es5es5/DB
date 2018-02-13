package com.lhw.po.nation;

import java.util.ArrayList;

import com.lhw.po.main.MainController;

public class NationController {
	public static void goNationMenu() {
		NationMenu.showNationMenu();
	}
	public static void doNationDBWork(String what, NationDTO n) {
		if (what.equals("���")) {
			NationDAO.reg(n);
		} else if (what.equals("�޴޼���")) {
			NationDAO.updateMedal(n);
		} else if (what.equals("�������")) {
			NationDAO.delNation(n);
		} else if (what.equals("������ȸ")) {
			NationDAO.searchNationInfo(n);
		} else if (what.equals("�޴���ȸ")) {
			NationDAO.searchNationMedelInfo(n);
		} else if (what.equals("��ü��ȸ")) {
			NationDAO.searchAllInfo();
		}
	}
	public static void goPrintNationRegResult(String what) {
		NationView.printRegResult(what);
	}
	public static void goNationSubMenu(int menu) {
		if (menu == 1) { // ���� ���
			NationMenu.showRegMenu();
		} else if (menu == 2) { // ���� ���� ��ȸ
			NationMenu.searchNationInfoMenu();
		} else if (menu == 3) { // �޴� ���� ��ȸ
			NationMenu.searchNationMedalMenu();
		} else if (menu == 4) { // �޴� ���� ����
			NationMenu.showUpdateMedal();
		} else if (menu == 5) { // ���� ����
			NationMenu.showDelMenu();
		} else {
			MainController.main(null);
		}
	}
	public static void goNationPrintUpdateResult(String what) {
		NationView.printUpdateResult(what);
	}
	public static void goNationPrintDelResult(String what) {
		NationView.printDelResult(what);
	}
	public static void goNationPrintSearchResult(String what, ArrayList<NationDTO> nations) {
		NationView.printSearchResult(what, nations);
	}
	public static void goNationPrintSearchMedalResult(String what, ArrayList<NationDTO> nations) {
		NationView.printSearchMedalResult(what, nations);
	}
}
