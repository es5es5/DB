package com.lhw.po.main;

import java.util.Scanner;

public class MainMenu {
	public static void showMainMenu() {
		Scanner keyboard = null;
		
		try {
			keyboard = new Scanner(System.in);
			System.out.println("1. ����");
			System.out.println("2. ����");
			System.out.println("3. ����");
			System.out.println("9. ����");
			System.out.println("-----------");
			System.out.print("�� : ");
			int menu = keyboard.nextInt();
			MainController.goSubMenu(menu);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ٽ�");
			MainController.main(null);
		} finally {
			
		}
	}

}
