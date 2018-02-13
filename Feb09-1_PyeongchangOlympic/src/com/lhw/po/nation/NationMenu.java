package com.lhw.po.nation;

import java.util.Scanner;

import com.lhw.po.main.MainView;

public class NationMenu {
	public static void showNationMenu() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);

			System.out.println("★ N A T I O N  M E N U★");
			System.out.println("    1. 나라 등록");
			System.out.println("    2. 나라 조회");
			System.out.println("    3. 메달 조회");
			System.out.println("    4. 메달 정보 수정");
			System.out.println("    5. 나라 삭제");
			System.out.println("    0. 메인 메뉴로");
			System.out.println("------------");
			System.out.print("선택 ☞ ");
			int menu = keyboard.nextInt();
			NationController.goNationSubMenu(menu);
		} catch (Exception e) {
			MainView.reEnter();
			NationController.goNationMenu();
		} finally {

		}
	}

	public static void showRegMenu() {
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);

			System.out.print("이름 : ");
			String name = keyboard.next();
			System.out.print("소속 대륙 : ");
			String continent = keyboard.next();
			System.out.print("인구 수 : ");
			int population = keyboard.nextInt();

			NationDTO nation = new NationDTO(name, continent, population, 0, 0, 0);

			NationController.doNationDBWork("등록", nation);
		} catch (Exception e) {
			NationController.goNationMenu();
		}

	}

	public static void showUpdateMedal() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);

			System.out.print("수정할 나라 이름 : ");
			String name = keyboard.next();
			System.out.print("수정할 금메달 수 : ");
			int gold = keyboard.nextInt();
			System.out.print("수정할 은메달 수 : ");
			int silver = keyboard.nextInt();
			System.out.print("수정할 동메달 수 : ");
			int bronze = keyboard.nextInt();

			NationDTO n = new NationDTO();
			n.setName(name);
			n.setGold(gold);
			n.setSilver(silver);
			n.setBronze(bronze);

			NationController.doNationDBWork("메달수정", n);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showDelMenu() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);
			System.out.print("삭제할 나라 이름 : ");
			String name = keyboard.next();

			NationDTO n = new NationDTO();
			n.setName(name);

			NationController.doNationDBWork("나라삭제", n);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void searchNationInfoMenu() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);
			System.out.println("\"전체\" 입력시 전체 나라 출력");
			System.out.print("조회할 나라 이름 : ");
			String name = keyboard.next();
			
			NationDTO n = new NationDTO(name, null, 0, 0, 0, 0);
			
			if (name.equals("전체")) {
				NationController.doNationDBWork("전체조회", n);
			}
			NationController.doNationDBWork("나라조회", n);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void searchNationMedalMenu() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);
			System.out.print("조회할 나라 이름 : ");
			String name = keyboard.next();
			
			NationDTO n = new NationDTO(name, null, 0, 0, 0, 0);
			
			NationController.doNationDBWork("메달조회", n);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
