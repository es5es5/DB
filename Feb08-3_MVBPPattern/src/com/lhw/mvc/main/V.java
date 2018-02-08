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

import java.util.Scanner;

public class V {
	
	public static void showResult(int result) {
		System.out.println("답은 " + result);
	}

	public static void doInput() {
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);
			System.out.print("x : ");	int x = keyboard.nextInt();
			System.out.print("뭐 : ");	String giho = keyboard.next();
			System.out.print("y : ");	int y = keyboard.nextInt();
			C.goCalculate(x, giho, y); // 2.
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			keyboard.close();
		}
	}
}












