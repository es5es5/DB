package com.lhw.po.player;

import java.util.ArrayList;

import com.lhw.po.main.MainView;

public class PlayerView {

	public static void printRegResult(String what) {
		try {
			if (what.equals("����")) {
				System.out.println("���� ��� ����");
			} else {
				System.out.println("���� ��� ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MainView.showMainMenu();
		}
	}

	public static void printUpdateResult(String what) {
		try {

			if (what.equals("����")) {
				System.out.println("���� ���� ����");
			} else {
				System.out.println("���� ���� ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MainView.showMainMenu();
		}
	}

	public static void printDelResult(String what) {
		try {
			if (what.equals("����")) {
				System.out.println("���� ���� ����");
			} else {
				System.out.println("���� ���� ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MainView.showMainMenu();
		}
	}

	public static void printSerchResult(String what, ArrayList<PlayerDTO> players) {
		try {
			if (what.equals("����")) {
				for (PlayerDTO player : players) {
					player.playerInfo();
				}
			} else if (what.equals("���¼���")) {
				System.out.println("���� ���� �˻�");
			} else {
				System.out.println("���� �˻� ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MainView.showMainMenu();
		}
	}
}
