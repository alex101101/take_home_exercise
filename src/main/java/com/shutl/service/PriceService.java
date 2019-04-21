package com.shutl.service;

import com.shutl.model.Carrier;
import com.shutl.model.Quote;
import com.shutl.model.ServicePrice;
import com.shutl.model.Vehicle;

import java.util.List;

/**
 * Calculate delivery prices depending on the quote request input
 */
public interface PriceService {
    Long getSimplePostcodePrice(Quote quote);
    Long getSimplePostcodePriceWithVehicleMarkup(Quote quote, Vehicle vehicle);
    List<ServicePrice> getCarrierPriceList(Quote quote, Vehicle vehicle, List<Carrier> carriers);
}
