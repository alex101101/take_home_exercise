package com.shutl.service;

import com.shutl.model.Carrier;
import com.shutl.model.CarrierService;
import com.shutl.model.Quote;
import com.shutl.model.ServicePrice;
import com.shutl.model.Vehicle;
import com.shutl.utils.PriceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    DataService dataService;

    public Long getSimplePostcodePrice(Quote quote) {
        return PriceUtils.getPriceByPostcode(quote.getDeliveryPostcode(), quote.getPickupPostcode());
    }

    public Long getSimplePostcodePriceWithVehicleMarkup(Quote quote, Vehicle vehicle) {
        Long simplePrice = getSimplePostcodePrice(quote);
        return PriceUtils.getMarkedUpPrice(simplePrice, vehicle.getMarkup());
    }

    public List<ServicePrice> getCarrierPriceList(Quote quote, Vehicle vehicle, List<Carrier> carriers) {
        Long internalPrice = getSimplePostcodePriceWithVehicleMarkup(quote, vehicle);
        List<ServicePrice> priceList = new ArrayList<>();
        for (Carrier carrier : carriers) {
            for (CarrierService carrierService : carrier.getServices()) {
                if (carrierService.getVehicles().contains(quote.getVehicle())) {
                    Long totalPrice = internalPrice
                            + PriceUtils.getMarkedUpPrice(carrier.getBasePrice(), carrierService.getMarkup());
                    priceList.add(new ServicePrice(carrier.getCarrier(), totalPrice, carrierService.getDeliveryTime()));
                }
            }
        }
        priceList.sort(Comparator.comparing(o -> o.getPrice()));
        return priceList;
    }
}
