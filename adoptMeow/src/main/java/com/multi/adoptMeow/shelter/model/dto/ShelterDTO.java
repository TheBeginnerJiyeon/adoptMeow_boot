package com.multi.adoptMeow.shelter.model.dto;

public class ShelterDTO {
	
	private String id;
	private String name;
	private String addr;
	private String tel;
	private Double lat;
	private Double longt;
	
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
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public Double getLat() {
		return lat;
	}
	
	public void setLat(Double lat) {
		this.lat = lat;
	}
	
	public Double getLongt() {
		return longt;
	}
	
	public void setLongt(Double longt) {
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
