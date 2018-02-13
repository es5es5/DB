package com.lhw.po.player;

import java.util.Scanner;

import com.lhw.po.main.MainView;

public class PlayerMenu {
	public static void showPlayerMenu() {
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);
			System.out.println("1. ���� ���");
			System.out.println("2. ���� ���� ��ȸ");
			System.out.println("3. ���� ����");
			System.out.println("4. ���� ����");
			System.out.println("9. ���� �޴���");
			System.out.println("------------");
			System.out.print("�� : ");
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

			System.out.print("�̸� : ");
			String name = keyboard.next();
			System.out.print("���� : ");
			String from = keyboard.next();

			PlayerDTO player = new PlayerDTO(name, from);
			PlayerController.doPlayerDBWork("���", player);
		} catch (Exception e) {
			PlayerController.goPlayerMenu();
		}
	}

	public static void showUpdatePlayerMedalMenu() {
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);

			System.out.print("������ ���� �̸� : ");
			String name = keyboard.next();
			System.out.print("�� : ");
			int gold = keyboard.nextInt();
			System.out.print("�� : ");
			int silver = keyboard.nextInt();
			System.out.print("�� : ");
			int bronze = keyboard.nextInt();

			PlayerDTO player = new PlayerDTO(name, gold, silver, bronze);

			PlayerController.doPlayerDBWork("��������", player);
		} catch (Exception e) {
			PlayerController.goPlayerMenu();
		}
		
	}

	public static void showDelMenu() {
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);

			System.out.print("������ ���� �̸� : ");
			String name = keyboard.next();

			PlayerDTO player = new PlayerDTO();
			player.setName(name);

			PlayerController.doPlayerDBWork("��������", player);
		} catch (Exception e) {
			PlayerController.goPlayerMenu();
		}
	}

	public static void searchPlayerMenu() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);
			System.out.print("��ȸ�� ���� �̸� : ");
			String name = keyboard.next();
			
			PlayerDTO player = new PlayerDTO();
			player.setName(name);
			
			PlayerController.doPlayerDBWork("��ȸ", player);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
