package com.lhw.mvc.main;

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

// Ŭ������ �� �߿� �ϳ��� ���Ҹ� �ϰ�

public class C {
	public static void goResult(int result) {
		V.showResult(result); // 5.
	}
	
	public static void goCalculate(int x, String giho, int y) {
		if (giho.equals("+")) {
			// 3.
			M.sum(x, y);
		} else if (giho.equals("-")) {
			M.sub(x, y);
		} else if (giho.equals("*")) {
			M.mul(x, y);
		} else {
			M.div(x, y);
		}
	}

	public static void main(String[] args) {
		V.doInput(); // 1.
	}
}
