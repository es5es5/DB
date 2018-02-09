package com.lhw.po.sports;

public class SportsDTO {
	private int no;
	private String name;
	private String detail;
	public SportsDTO() {
		// TODO Auto-generated constructor stub
	}
	public SportsDTO(int no, String name, String detail) {
		super();
		this.no = no;
		this.name = name;
		this.detail = detail;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public void sportsInfo() {
		System.out.printf("%d)", no);
		System.out.printf("종목 이름 : %s", name);
		System.out.printf("상세  : %s", detail);
	}
}
