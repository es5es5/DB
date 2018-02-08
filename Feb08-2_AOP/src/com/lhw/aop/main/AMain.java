package com.lhw.aop.main;

import com.lhw.aop.human.Human;

public class AMain {

	public static void main(String[] args) {
		// AOP (Aspect Oriented Programming)
		// 관점 지향 프로그래밍
		
		Human h1 = new Human("이웅", 26);
		
		h1.goSchool();
	}

}
