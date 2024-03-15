package com.Shubham.SolarPanelsGRX10.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SolarPanelData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private double bill;
	private int area;
	private String phoneNo;

	public SolarPanelData(long id, double bill, int area, String phoneNo) {
		super();
		this.id = id;
		this.bill = bill;
		this.area = area;
		this.phoneNo = phoneNo;
	}
	
	

	public SolarPanelData() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getBill() {
		return bill;
	}
	public void setBill(double bill) {
		this.bill = bill;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "SolarPanelData [id=" + id + ", bill=" + bill + ", area=" + area + ", phoneNo=" + phoneNo + "]";
	}
}
