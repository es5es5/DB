// Model : ����Ͻ� ����
//			���(���� ����)
//		������, ��

// View : ��� ���� �������� ����
//			�Է¹ޱ�
//			������
//		�����̳�

// Controller : 
//			��Ȳ �Ǵ�/ �ʿ��� ��� �θ���
//		������


package com.lhw.mvc.main;

import java.util.Scanner;

public class V {
	
	public static void showResult(int result) {
		System.out.println("���� " + result);
	}

	public static void doInput() {
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);
			System.out.print("x : ");	int x = keyboard.nextInt();
			System.out.print("�� : ");	String giho = keyboard.next();
			System.out.print("y : ");	int y = keyboard.nextInt();
			C.goCalculate(x, giho, y); // 2.
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			keyboard.close();
		}
	}
}












