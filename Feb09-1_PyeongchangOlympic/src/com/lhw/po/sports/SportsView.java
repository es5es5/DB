package com.lhw.po.sports;

import java.util.ArrayList;

import com.lhw.po.main.MainMenu;

public class SportsView {
	public static void printRegResult(String what) {
		try {
			if (what.equals("����")) {
				System.out.println("���� ��� ����");
			} else {
				System.out.println("���� ��� ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MainMenu.showMainMenu();
		}
	}

	public static void printUpdateResult(String what) {
		try {
			if (what.equals("����")) {
				System.out.println("���� ���� ����");
			} else {
				System.out.println("���� ���� ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MainMenu.showMainMenu();
		}
	}

	public static void printDelResult(String what) {
		try {
			if (what.equals("����")) {
				System.out.println("���� ���� ����");
			} else {
				System.out.println("���� ���� ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MainMenu.showMainMenu();
		}
	}

	public static void printSearchResult(String what, ArrayList<SportsDTO> sports) {
		try {
			if (what.equals("����")) {
				for (SportsDTO s : sports) {
					s.sportsInfo();
				}
			} else if (what.equals("��������")) {
				System.out.println("���� ���� �˻�");
			} else {
				System.out.println("���� �˻� ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MainMenu.showMainMenu();
		}

	}
}
