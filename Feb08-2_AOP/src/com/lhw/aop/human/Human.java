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
		System.out.println("�� Ÿ�� ���� ��");
	}
	
	private void parking() {
		System.out.println("���� ��");
	}
	
	public void goSchool() {
		this.getCar();
		parking();
		System.out.println("�б� ����");
	}

	public void goAcademy() {
		this.getCar();
		parking();
		System.out.println("�п� ��������");
	}
	
	public void goPlayground() {
		this.getCar();
		parking();
		System.out.println("���̵��� ����������������������!!");
	}
}
