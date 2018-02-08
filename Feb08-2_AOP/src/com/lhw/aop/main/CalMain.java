package com.lhw.aop.main;

import java.util.Scanner;

import com.lhw.aop.Cal.Calculator;

public class CalMain {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Calculator c1 = new Calculator();
		try {
			System.out.print("x : ");
			int x = keyboard.nextInt();
			System.out.print("¹¹ : ");
			String what = keyboard.next();
			System.out.print("y : ");
			int y = keyboard.nextInt();

			if (what.equals("+")) {
				System.out.println(c1.sum(x, y));
			} else if (what.equals("-")) {
				System.out.println(c1.sub(x, y));
			} else if (what.equals("*")) {
				System.out.println(c1.mul(x, y));
			} else if (what.equals("/")){
				System.out.println(c1.div(x, y));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			keyboard.close();
		}
	}

}
