package com.lhw.po.player;

import java.util.Scanner;

import com.lhw.po.main.MainView;

public class PlayerMenu {
	public static void showPlayerMenu() {
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);
			System.out.println("1. 선수 등록");
			System.out.println("2. 선수 정보 조회");
			System.out.println("3. 선수 수정");
			System.out.println("4. 선수 삭제");
			System.out.println("9. 메인 메뉴로");
			System.out.println("------------");
			System.out.print("뭐 : ");
			int menu = keyboard.nextInt();
			PlayerController.goPlayerSubMenu(menu);

		} catch (Exception e) {
			MainView.reEnter();
			PlayerController.goPlayerMenu();
		} finally {}
	}

	public static void showRegMenu() {
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);

			System.out.print("이름 : ");
			String name = keyboard.next();
			System.out.print("나라 : ");
			String from = keyboard.next();

			PlayerDTO player = new PlayerDTO(name, from);
			PlayerController.doPlayerDBWork("등록", player);
		} catch (Exception e) {
			PlayerController.goPlayerMenu();
		}
	}

	public static void showUpdatePlayerMedalMenu() {
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);

			System.out.print("수정할 선수 이름 : ");
			String name = keyboard.next();
			System.out.print("금 : ");
			int gold = keyboard.nextInt();
			System.out.print("은 : ");
			int silver = keyboard.nextInt();
			System.out.print("동 : ");
			int bronze = keyboard.nextInt();

			PlayerDTO player = new PlayerDTO(name, gold, silver, bronze);

			PlayerController.doPlayerDBWork("선수수정", player);
		} catch (Exception e) {
			PlayerController.goPlayerMenu();
		}
		
	}

	public static void showDelMenu() {
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);

			System.out.print("삭제할 선수 이름 : ");
			String name = keyboard.next();

			PlayerDTO player = new PlayerDTO();
			player.setName(name);

			PlayerController.doPlayerDBWork("선수삭제", player);
		} catch (Exception e) {
			PlayerController.goPlayerMenu();
		}
	}

	public static void searchPlayerMenu() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);
			System.out.print("조회할 선수 이름 : ");
			String name = keyboard.next();
			
			PlayerDTO player = new PlayerDTO();
			player.setName(name);
			
			PlayerController.doPlayerDBWork("조회", player);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
