package com.lhw.po.main;

import java.util.Scanner;

public class MainView {
	public static void showMainMenu() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);
			System.out.println("�� M A I N  M E N U��");
			System.out.println("    1. ����");
			System.out.println("    2. ����");
			System.out.println("    3. ����");
			System.out.println("    0. ����");
			System.out.println("-------------");
			System.out.print("���� �� ");
			int menu = keyboard.nextInt();
			MainController.goSubMenu(menu);
		} catch (Exception e) {
			MainView.reEnter();
			MainController.main(null);
		} finally {}
	}
	public static void showExit() {
		System.out.println("���α׷� �����մϴ�.");
		System.exit(0);
	}
	public static void reEnter() {
		System.out.println("�� WARNING  �ٽ� �Է����ּ���.");
	}
}
