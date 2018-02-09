package com.lhw.po.main;

import java.util.Scanner;

public class MainMenu {
	public static void showMainMenu() {
		Scanner keyboard = null;
		
		try {
			keyboard = new Scanner(System.in);
			System.out.println("1. 나라");
			System.out.println("2. 선수");
			System.out.println("3. 종목");
			System.out.println("9. 종료");
			System.out.println("-----------");
			System.out.print("뭐 : ");
			int menu = keyboard.nextInt();
			MainController.goSubMenu(menu);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("다시");
			MainController.main(null);
		} finally {
			
		}
	}

}
