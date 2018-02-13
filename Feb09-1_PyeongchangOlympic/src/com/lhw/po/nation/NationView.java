package com.lhw.po.nation;

import java.util.ArrayList;

import com.lhw.po.main.MainView;

public class NationView {
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
				System.out.println("���� �޴� �� ���� ����");
			} else {
				System.out.println("���� �޴� �� ���� ����");
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

	public static void printSearchResult(String what, ArrayList<NationDTO> nations) {
		try {
			if (what.equals("����")) {
				for (NationDTO nation : nations) {
					nation.nationInfo();
				}
			} else if (what.equals("���³���")) {
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

	public static void printSearchMedalResult(String what, ArrayList<NationDTO> nations) {
		try {
			if (what.equals("����")) {
				for (NationDTO nation : nations) {
					nation.nationMedalInfo();
				}
			} else if (what.equals("���³���")) {
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
