package com.lhw.po.nation;

public class NationDTO {
	private String name;
	private String continent;
	private int population;
	private int gold;
	private int silver;
	private int bronze;
	public NationDTO() {
		// TODO Auto-generated constructor stub
	}
	public NationDTO(String name, String continent, int population, int gold, int silver, int bronze) {
		super();
		this.name = name;
		this.continent = continent;
		this.population = population;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
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
	public void nationInfo() {
		System.out.printf("�̸� : %s\n", name);
		System.out.printf("��� : %s\n", continent);
		System.out.printf("�α� : %d\n", population);
		System.out.printf("�� : %d\n", gold);
		System.out.printf("�� : %d\n", silver);
		System.out.printf("�� : %d\n", bronze);
		System.out.println("----------");
	}
}
