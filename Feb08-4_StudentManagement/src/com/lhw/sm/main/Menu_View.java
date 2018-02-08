// View : ��� ���� �������� ����
//			�Է¹ޱ�
//			������
//		�����̳�

package com.lhw.sm.main;

import java.util.Scanner;

import com.lhw.sm.student.StudentDTO;

// View
public class Menu_View {
	public static void showMainMenu() {
		Scanner keyboard = null;
		
		try {
			keyboard = new Scanner(System.in);
			System.out.println("1. �л� ���");
			System.out.println("2. �л� ��ȸ");
			System.out.println("3. ���� ����");
			System.out.println("4. �̸� ����");
			System.out.println("5. �л� ����");
			System.out.println("6. ����");
			System.out.println("-----------");
			System.out.print("�� : ");
			int menu = keyboard.nextInt();
			SMMain_C_Main.go(menu);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
	public static void showInsertStudentMenu() {
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);
			System.out.print("�̸� : ");
			String name = keyboard.next();
			System.out.print("����(YYYYMMDD) : ");
			String birthday2 = keyboard.next();
			System.out.print("�߰� : ");
			double mid = keyboard.nextDouble();
			System.out.print("�⸻ : ");
			double fin = keyboard.nextDouble();
			
			// INSERT��ų ������ �� ������ �ִ� �л� ��ü
			StudentDTO s = new StudentDTO();
			s.setName(name);
			s.setMid(mid);
			s.setFin(fin);
			s.setBirthday2(birthday2);
			
			SMMain_C_Main.goDBWork(1, s);;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void showDelStudentMenu() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);
			
			System.out.print("������ �л� ��ȣ : ");
			int no = keyboard.nextInt();
			
			// �ڹٺ� DTO
			StudentDTO s = new StudentDTO();
			s.setNo(no);
			
			SMMain_C_Main.goDBWork(5, s);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void showUpdateStudentMenu() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);
			
			System.out.print("������ �л� ��ȣ : ");
			int no = keyboard.nextInt();
			System.out.print("�߰� ���� : ");
			double mid = keyboard.nextDouble();
			System.out.print("�⸻ ���� : ");
			double fin = keyboard.nextDouble();
			
			// �ڹٺ� DTO
			StudentDTO s = new StudentDTO();
			s.setNo(no);
			s.setMid(mid);
			s.setFin(fin);
			
			SMMain_C_Main.goDBWork(3, s);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
