package com.lhw.po.sports;

import java.util.Scanner;

import com.lhw.po.nation.NationController;

public class SportsMenu {
	public static void show() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);
			System.out.println("1. 종목 등록");
			System.out.println("2. 종목 조회");
			System.out.println("3. 종목 수정");
			System.out.println("4. 종목 삭제");
			System.out.println("9. 메인 메뉴로");
			System.out.println("-----------");
			System.out.print("뭐 : ");
			int menu = keyboard.nextInt();
			SportsController.goSubMenu(menu);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("다시");
		} finally {

		}
	}
	
	public static void showRegMenu() {
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);
			
			System.out.print("종목 이름 : ");
			String name = keyboard.next();
			System.out.print("상세 내용 : ");
			String detail = keyboard.next();
			
			SportsDTO s = new SportsDTO();
			s.setName(name);
			s.setDetail(detail);
			
			SportsController.doDBWork("등록", s);
		} catch (Exception e) {
			NationController.goNationMenu();
		}
	}

	public static void showUpdateMenu() {
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);
			
			System.out.print("바꿀 종목 번호 : ");
			int no = keyboard.nextInt();
			System.out.print("바꿀 종목 이름 : ");
			String name = keyboard.next();
			System.out.print("바꿀 상세 내용 : ");
			String detail = keyboard.next();
			
			SportsDTO s = new SportsDTO();
			s.setNo(no);
			s.setName(name);
			s.setDetail(detail);
			
			SportsController.doDBWork("수정", s);
		} catch (Exception e) {
			NationController.goNationMenu();
		}
	}
}
