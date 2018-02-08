package com.lhw.mvc.main;

// Model : 비즈니스 로직
//			계산(실제 업무)
//		개발자, 고객

// View : 사람 눈에 보여지는 영역
//			입력받기
//			결과출력
//		디자이너

// Controller : 
//			상황 판단/ 필요한 기능 부르기
//		개발자

// 클래스가 저 중에 하나의 역할만 하게

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
