// DAO/DTO 패턴
// Model
// 		Data Access Object : DB에 관련된 작업 전담할 클래스
//		Data Transfer/Temp Object : 작업 결과를 저장할 클래스

package com.lhw.sm.student;

import java.util.Date;


// DTO
public class StudentDTO {
	private String name;
	private int no;
	private Date birthday;
	private String birthday2;
	private double mid;
	private double fin;
	private double avg;
	private int age;

	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}
	public String getBirthday2() {
		return birthday2;
	}
	public void setBirthday2(String birthday2) {
		this.birthday2 = birthday2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public double getMid() {
		return mid;
	}
	public void setMid(double mid) {
		this.mid = mid;
	}
	public double getFin() {
		return fin;
	}
	public void setFin(double fin) {
		this.fin = fin;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public StudentDTO(String name, int no, Date birthday, double mid, double fin, double avg, int age) {
		super();
		this.name = name;
		this.no = no;
		this.birthday = birthday;
		this.mid = mid;
		this.fin = fin;
		this.avg = avg;
		this.age = age;
	}
	public void info() {
		System.out.printf("%d)\n", no);
		System.out.printf("이름 : %s\n", name);
		System.out.println("생년월일 : " + birthday);
		System.out.printf("나이 : %d\n", age);
		System.out.printf("평균 점수 : %.1f\n", avg);
	}
}
