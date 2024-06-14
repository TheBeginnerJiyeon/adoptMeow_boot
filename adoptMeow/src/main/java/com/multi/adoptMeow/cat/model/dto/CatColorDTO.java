package com.multi.adoptMeow.cat.model.dto;

public class CatColorDTO {
	
	int id;
	int colorId1;
	int colorId2;
	String name;
	
	public int getColorId1() {
		return colorId1;
	}
	
	public void setColorId1(int colorId1) {
		this.colorId1 = colorId1;
	}
	
	public int getColorId2() {
		return colorId2;
	}
	
	public void setColorId2(int colorId2) {
		this.colorId2 = colorId2;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "CatColorDTO{" +
				"id=" + id +
				", colorId1=" + colorId1 +
				", colorId2=" + colorId2 +
				", name='" + name + '\'' +
				'}';
	}
}
