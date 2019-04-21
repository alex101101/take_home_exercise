package com.shutl.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Carrier {
	@JsonProperty(value ="carrier_name")
	String carrier;
	Long basePrice;
	List<CarrierService> services;

	public Carrier() {}

	public Carrier(String carrier, Long basePrice, List<CarrierService> services) {
		this.carrier = carrier;
		this.basePrice = basePrice;
		this.services = services;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public Long getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Long basePrice) {
		this.basePrice = basePrice;
	}

	public List<CarrierService> getServices() {
		return services;
	}

	public void setServices(List<CarrierService> services) {
		this.services = services;
	}
}