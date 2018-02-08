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
