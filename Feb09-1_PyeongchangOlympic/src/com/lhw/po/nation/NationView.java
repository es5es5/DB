package com.lhw.po.nation;

import java.util.ArrayList;

public class NationView {
	public static void printRegResult(String what) {
		if (what.equals("����")) {
			System.out.println("���� ��� ����");
		} else {
			System.out.println("���� ��� ����");
		}
	}

	public static void printUpdateResult(String what) {
		if (what.equals("����")) {
			System.out.println("���� �޴� �� ���� ����");
		} else {
			System.out.println("���� �޴� �� ���� ����");
		}
	}

	public static void printDelResult(String what) {
		if (what.equals("����")) {
			System.out.println("���� ���� ����");
		} else {
			System.out.println("���� ���� ����");
		}
	}
	public static void printSearchResult(String what, ArrayList<NationDTO> nations) {
		if (what.equals("����")){
			for (NationDTO nation : nations) {
				nation.nationInfo();
			}
		} else if (what.equals("���³���")){
			System.out.println("���� ���� �˻�");
		} else {
			System.out.println("���� �˻� ����");
		}
	}

}
