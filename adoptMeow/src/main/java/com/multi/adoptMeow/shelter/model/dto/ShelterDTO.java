package com.multi.adoptMeow.shelter.model.dto;

public class ShelterDTO {
	
	private String id;
	private String name;
	private String addr;
	private int tel;
	private int lat;
	private int longt;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public int getTel() {
		return tel;
	}
	
	public void setTel(int tel) {
		this.tel = tel;
	}
	
	public int getLat() {
		return lat;
	}
	
	public void setLat(int lat) {
		this.lat = lat;
	}
	
	public int getLongt() {
		return longt;
	}
	
	public void setLongt(int longt) {
		this.longt = longt;
	}
	
	@Override
	public String toString() {
		return "ShelterDTO{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", addr='" + addr + '\'' +
				", tel=" + tel +
				", lat=" + lat +
				", longt=" + longt +
				'}';
	}
}
