package com.shutl.model;

public class ServicePrice {
    String service;
    Long price;
    int deliveryTime;

    public ServicePrice() { }

    public ServicePrice(String service, Long price, int deliveryTime) {
        this.service = service;
        this.price = price;
        this.deliveryTime = deliveryTime;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
