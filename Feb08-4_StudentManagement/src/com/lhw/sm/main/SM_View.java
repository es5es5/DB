package com.lhw.sm.main;

import java.util.ArrayList;

import com.lhw.sm.student.StudentDTO;

public class SM_View {

	public static void printRegStudentResult(int what) {
		if (what == 1) {
			System.out.println("�л� ��� ����");
		} else {
			System.out.println("�л� ��� ����");
		}
		SM_MainController.main(null);
	}
	
	public static void printUpdateStudentResult(int what) {
		if (what == 1) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
		SM_MainController.main(null);
	}
	
	public static void printDelStudentResult(int what) {
		if (what == 1) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
		SM_MainController.main(null);
	}
	
	public static void printShoAllResult(int what, ArrayList<StudentDTO> students) {
		if (what == 0) {
			System.out.println("��ϵ� �л��� �����ϴ�.");
		} else if (what == -1) {
			System.out.println("�л� ���� �޾ƿ��� ����");
		} else if (what == 1) {
			for (StudentDTO s : students) {
				s.info();
			}
		}
		SM_MainController.main(null);
	}


	
}
