package com.lhw.aop.human;

public class Human {
	private String name;
	private int age;
	
	public Human() {
		// TODO Auto-generated constructor stub
	}
	
	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	private void getCar() {
		System.out.println("차 타고 가는 중");
	}
	
	private void parking() {
		System.out.println("주차 함");
	}
	
	public void goSchool() {
		this.getCar();
		parking();
		System.out.println("학교 ㄱㄱ");
	}

	public void goAcademy() {
		this.getCar();
		parking();
		System.out.println("학원 ㄱㄱㄱㄱ");
	}
	
	public void goPlayground() {
		this.getCar();
		parking();
		System.out.println("놀이동산 ㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱ!!");
	}
}
