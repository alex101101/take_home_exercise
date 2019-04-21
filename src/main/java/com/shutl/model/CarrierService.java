package com.shutl.model;

import java.util.List;

public class CarrierService {
	int deliveryTime;
	int markup;
	List<String> vehicles;

	public CarrierService() { }

	public CarrierService(int deliveryTime, int markup, List<String> vehicles) {
		this.deliveryTime = deliveryTime;
		this.markup = markup;
		this.vehicles = vehicles;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public int getMarkup() {
		return markup;
	}

	public void setMarkup(int markup) {
		this.markup = markup;
	}

	public List<String> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<String> vehicles) {
		this.vehicles = vehicles;
	}
}