package com.lhw.po.sports;

import java.util.Scanner;

import com.lhw.po.nation.NationController;

public class SportsMenu {
	public static void show() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);
			System.out.println("1. ���� ���");
			System.out.println("2. ���� ��ȸ");
			System.out.println("3. ���� ����");
			System.out.println("4. ���� ����");
			System.out.println("9. ���� �޴���");
			System.out.println("-----------");
			System.out.print("�� : ");
			int menu = keyboard.nextInt();
			SportsController.goSubMenu(menu);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ٽ�");
		} finally {

		}
	}
	
	public static void showRegMenu() {
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);
			
			System.out.print("���� �̸� : ");
			String name = keyboard.next();
			System.out.print("�� ���� : ");
			String detail = keyboard.next();
			
			SportsDTO s = new SportsDTO();
			s.setName(name);
			s.setDetail(detail);
			
			SportsController.doDBWork("���", s);
		} catch (Exception e) {
			NationController.goNationMenu();
		}
	}

	public static void showUpdateMenu() {
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);
			
			System.out.print("�ٲ� ���� ��ȣ : ");
			int no = keyboard.nextInt();
			System.out.print("�ٲ� ���� �̸� : ");
			String name = keyboard.next();
			System.out.print("�ٲ� �� ���� : ");
			String detail = keyboard.next();
			
			SportsDTO s = new SportsDTO();
			s.setNo(no);
			s.setName(name);
			s.setDetail(detail);
			
			SportsController.doDBWork("����", s);
		} catch (Exception e) {
			NationController.goNationMenu();
		}
	}
}
