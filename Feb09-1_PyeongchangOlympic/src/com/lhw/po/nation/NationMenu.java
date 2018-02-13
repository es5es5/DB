package com.lhw.po.nation;

import java.util.Scanner;

import com.lhw.po.main.MainView;

public class NationMenu {
	public static void showNationMenu() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);

			System.out.println("�� N A T I O N  M E N U��");
			System.out.println("    1. ���� ���");
			System.out.println("    2. ���� ��ȸ");
			System.out.println("    3. �޴� ��ȸ");
			System.out.println("    4. �޴� ���� ����");
			System.out.println("    5. ���� ����");
			System.out.println("    0. ���� �޴���");
			System.out.println("------------");
			System.out.print("���� �� ");
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

			System.out.print("�̸� : ");
			String name = keyboard.next();
			System.out.print("�Ҽ� ��� : ");
			String continent = keyboard.next();
			System.out.print("�α� �� : ");
			int population = keyboard.nextInt();

			NationDTO nation = new NationDTO(name, continent, population, 0, 0, 0);

			NationController.doNationDBWork("���", nation);
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

			NationController.doNationDBWork("�޴޼���", n);
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

			NationController.doNationDBWork("�������", n);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void searchNationInfoMenu() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);
			System.out.println("\"��ü\" �Է½� ��ü ���� ���");
			System.out.print("��ȸ�� ���� �̸� : ");
			String name = keyboard.next();
			
			NationDTO n = new NationDTO(name, null, 0, 0, 0, 0);
			
			if (name.equals("��ü")) {
				NationController.doNationDBWork("��ü��ȸ", n);
			}
			NationController.doNationDBWork("������ȸ", n);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void searchNationMedalMenu() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);
			System.out.print("��ȸ�� ���� �̸� : ");
			String name = keyboard.next();
			
			NationDTO n = new NationDTO(name, null, 0, 0, 0, 0);
			
			NationController.doNationDBWork("�޴���ȸ", n);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
