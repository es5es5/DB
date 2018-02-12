package com.lhw.po.sports;

import java.util.ArrayList;

import com.lhw.po.main.MainMenu;

public class SportsView {
	public static void printRegResult(String what) {
		try {
			if (what.equals("성공")) {
				System.out.println("종목 등록 성공");
			} else {
				System.out.println("종목 등록 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MainMenu.showMainMenu();
		}
	}

	public static void printUpdateResult(String what) {
		try {
			if (what.equals("성공")) {
				System.out.println("종목 수정 성공");
			} else {
				System.out.println("종목 수정 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MainMenu.showMainMenu();
		}
	}

	public static void printDelResult(String what) {
		try {
			if (what.equals("성공")) {
				System.out.println("종목 삭제 성공");
			} else {
				System.out.println("종목 삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MainMenu.showMainMenu();
		}
	}

	public static void printSearchResult(String what, ArrayList<SportsDTO> sports) {
		try {
			if (what.equals("성공")) {
				for (SportsDTO s : sports) {
					s.sportsInfo();
				}
			} else if (what.equals("없는종목")) {
				System.out.println("없는 종목 검색");
			} else {
				System.out.println("종목 검색 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MainMenu.showMainMenu();
		}

	}
}
