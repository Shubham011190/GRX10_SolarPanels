package com.Shubham.SolarPanelsGRX10.model;

public class OutputData {

	private int noOfPanels;
	private int areaNeeded;
	private long capitalneeded;
	private double breakEvenYears;
	private double next25Earnings;
	
	public OutputData(int noOfPanels, int areaNeeded, long capitalneeded, double breakEvenYears,
			double next25Earnings) {
		super();
		this.noOfPanels = noOfPanels;
		this.areaNeeded = areaNeeded;
		this.capitalneeded = capitalneeded;
		this.breakEvenYears = breakEvenYears;
		this.next25Earnings = next25Earnings;
	}

	public int getNoOfPanels() {
		return noOfPanels;
	}

	public void setNoOfPanels(int noOfPanels) {
		this.noOfPanels = noOfPanels;
	}

	public int getAreaNeeded() {
		return areaNeeded;
	}

	public void setAreaNeeded(int areaNeeded) {
		this.areaNeeded = areaNeeded;
	}

	public long getCapitalneeded() {
		return capitalneeded;
	}

	public void setCapitalneeded(long capitalneeded) {
		this.capitalneeded = capitalneeded;
	}

	public double getBreakEvenYears() {
		return breakEvenYears;
	}

	public void setBreakEvenYears(double breakEvenYears) {
		this.breakEvenYears = breakEvenYears;
	}


	public double getNext25Earnings() {
		return next25Earnings;
	}

	public void setNext25Earnings(double next25Earnings) {
		this.next25Earnings = next25Earnings;
	}
	
	
	
}
