package com.shutl.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class Quote {
    
    String pickupPostcode;
    String deliveryPostcode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String vehicle;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Long price;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<ServicePrice> priceList;


    public Quote() {}

    public Quote(String pickupPostcode, String deliveryPostcode) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
    }

    public Quote(String pickupPostcode, String deliveryPostcode, String vehicle) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
        this.vehicle = vehicle;
    }

    public Quote(String pickupPostcode, String deliveryPostcode, String vehicle, Long price) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
        this.vehicle = vehicle;
        this.price = price;
    }

    public Quote(String pickupPostcode, String deliveryPostcode, String vehicle, List<ServicePrice> priceList) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
        this.vehicle = vehicle;
        this.priceList = priceList;
    }

    public String getPickupPostcode() {
        return pickupPostcode;
    }

    public void setPickupPostcode(String pickupPostcode) {
        this.pickupPostcode = pickupPostcode;
    }

    public String getDeliveryPostcode() {
        return deliveryPostcode;
    }

    public void setDeliveryPostcode(String deliveryPostcode) {
        this.deliveryPostcode = deliveryPostcode;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public List<ServicePrice> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<ServicePrice> priceList) {
        this.priceList = priceList;
    }
}
