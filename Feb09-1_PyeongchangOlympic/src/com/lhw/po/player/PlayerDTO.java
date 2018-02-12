package com.lhw.po.player;

public class PlayerDTO {
	private int no;
	private String name;
	private String from;
	private int gold;
	private int silver;
	private int bronze;
	
	public PlayerDTO() {
		// TODO Auto-generated constructor stub
	}
	public PlayerDTO(String name, String from) {
		super();
		this.name = name;
		this.from = from;
	}
	public PlayerDTO(String name, int gold, int silver, int bronze) {
		super();
		this.name = name;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}
	public PlayerDTO(int no, String name, String from, int gold, int silver, int bronze) {
		super();
		this.no = no;
		this.name = name;
		this.from = from;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
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
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getSilver() {
		return silver;
	}
	public void setSilver(int silver) {
		this.silver = silver;
	}
	public int getBronze() {
		return bronze;
	}
	public void setBronze(int bronze) {
		this.bronze = bronze;
	}
	public void playerInfo() {
		System.out.printf("번호 : %d\n", no);
		System.out.printf("이름 : %s\n", name);
		System.out.printf("국적 : %s\n", from);
		System.out.printf("금 : %d\n", gold);
		System.out.printf("은 : %d\n", silver);
		System.out.printf("동 : %d\n", bronze);
		System.out.println("--------------");
	}
}
