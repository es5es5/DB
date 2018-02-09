package com.lhw.po.nation;

import java.util.Scanner;

public class NationMenu {
	public static void show() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);
			System.out.println("1. ���� ���");
			System.out.println("2. ���� ���� ��ȸ");
			System.out.println("3. �޴� ���� ��ȸ");
			System.out.println("4. �޴� ���� ����");
			System.out.println("5. ���� ����");
			System.out.println("9. ���� �޴���");
			System.out.println("------------");
			System.out.print("�� : ");
			int menu = keyboard.nextInt();
			NationController.goSubMenu(menu);

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

			System.out.print("�̸� : ");
			String name = keyboard.next();
			System.out.print("�Ҽ� ��� : ");
			String continent = keyboard.next();
			System.out.print("�α� �� : ");
			int population = keyboard.nextInt();

			NationDTO nation = new NationDTO(name, continent, population, 0, 0, 0);

			NationController.doDBWork("���", nation);
		} catch (Exception e) {
			NationController.goNationMenu();
		}

	}

	public static void showUpdateMedal() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);

			System.out.print("������ ���� �̸� : ");
			String name = keyboard.next();
			System.out.print("������ �ݸ޴� �� : ");
			int gold = keyboard.nextInt();
			System.out.print("������ ���޴� �� : ");
			int silver = keyboard.nextInt();
			System.out.print("������ ���޴� �� : ");
			int bronze = keyboard.nextInt();

			NationDTO n = new NationDTO();
			n.setName(name);
			n.setGold(gold);
			n.setSilver(silver);
			n.setBronze(bronze);

			NationController.doDBWork("�޴޼���", n);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void showDelMenu() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);
			System.out.print("������ ���� �̸� : ");
			String name = keyboard.next();

			NationDTO n = new NationDTO();
			n.setName(name);

			NationController.doDBWork("�������", n);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void searchNationMenu() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);
			System.out.print("��ȸ�� ���� �̸� : ");
			String name = keyboard.next();
			
			NationDTO n = new NationDTO(name, null, 0, 0, 0, 0);
			
			NationController.doDBWork("��ȸ", n);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
