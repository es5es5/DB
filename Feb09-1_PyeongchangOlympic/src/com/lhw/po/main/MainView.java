package com.lhw.po.main;

import java.util.Scanner;

public class MainView {
	public static void showMainMenu() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);
			System.out.println("★ M A I N  M E N U★");
			System.out.println("    1. 나라");
			System.out.println("    2. 선수");
			System.out.println("    3. 종목");
			System.out.println("    0. 종료");
			System.out.println("-------------");
			System.out.print("선택 ☞ ");
			int menu = keyboard.nextInt();
			MainController.goSubMenu(menu);
		} catch (Exception e) {
			MainView.reEnter();
			MainController.main(null);
		} finally {}
	}
	public static void showExit() {
		System.out.println("프로그램 종료합니다.");
		System.exit(0);
	}
	public static void reEnter() {
		System.out.println("※ WARNING  다시 입력해주세요.");
	}
}
