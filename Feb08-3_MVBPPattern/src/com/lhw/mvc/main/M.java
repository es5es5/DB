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

public class M {

	public static void sum(int x, int y) {
		int result = x + y;
		C.goResult(result); // 4.
	}
	
	public static void sub(int x, int y) {
		int result = x - y;
		C.goResult(result);
	}
	
	public static void mul(int x, int y) {
		int result = x * y;
		C.goResult(result);
	}
	
	public static void div(int x, int y) {
		int result = x / y;
		C.goResult(result);
	}
}
