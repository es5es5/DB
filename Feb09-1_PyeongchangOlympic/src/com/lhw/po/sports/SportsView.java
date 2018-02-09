package com.lhw.po.sports;

public class SportsView {
	public static void printRegResult(String what) {
		if (what.equals("성공")) {
			System.out.println("종목 등록 성공");
		} else {
			System.out.println("종목 등록 실패");
		}
	}

	public static void printUpdateResult(String what) {
		if (what.equals("성공")) { 
			System.out.println("종목 수정 성공");
		} else {
			System.out.println("종목 수정 실패");
		}
	}
}
