package com.lhw.po.player;

import java.util.ArrayList;

import com.lhw.po.main.MainMenu;

public class PlayerView {

	public static void printRegResult(String what) {
		try {
			if (what.equals("성공")) {
				System.out.println("선수 등록 성공");
			} else {
				System.out.println("선수 등록 실패");
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
				System.out.println("선수 수정 성공");
			} else {
				System.out.println("선수 수정 실패");
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
				System.out.println("선수 삭제 성공");
			} else {
				System.out.println("선수 삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MainMenu.showMainMenu();
		}
	}

	public static void printSerchResult(String what, ArrayList<PlayerDTO> players) {
		try {
			if (what.equals("성공")) {
				for (PlayerDTO player : players) {
					player.playerInfo();
				}
			} else if (what.equals("없는선수")) {
				System.out.println("없는 선수 검색");
			} else {
				System.out.println("선수 검색 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MainMenu.showMainMenu();
		}
	}
}
