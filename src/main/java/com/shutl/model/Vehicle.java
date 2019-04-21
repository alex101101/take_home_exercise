package com.shutl.model;

public class Vehicle {
	String vehicle;
	int markup;

	public Vehicle() {}

	public Vehicle(String vehicle, int markup) {
		this.vehicle = vehicle;
		this.markup = markup;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public int getMarkup() {
		return markup;
	}

	public void setMarkup(int markup) {
		this.markup = markup;
	}
}