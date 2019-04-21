package com.shutl.controller;

import com.shutl.model.Carrier;
import com.shutl.model.Quote;
import com.shutl.model.ServicePrice;
import com.shutl.model.Vehicle;
import com.shutl.service.DataService;
import com.shutl.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class QuoteController {
    @Autowired
    PriceService priceService;

    @Autowired
    DataService dataService;

    /**
     * Returns a simple quote if vehicle not specified.
     * Returns a quote with different carrier options if vehicle is specified.
     * @param quote quote request body
     * @return the calculated quote
     */
    @CrossOrigin
    @RequestMapping(value = "/quote", method = POST)
    public @ResponseBody Quote quote(@RequestBody Quote quote) {
        if (quote.getVehicle() != null) {
            // Return empty list if no carrier price options found
            List<ServicePrice> priceList = Collections.emptyList();
            Vehicle vehicle = dataService.getVehicleByName(quote.getVehicle());
            if (vehicle != null) {
                List<Carrier> carriers = dataService.getCarriers();
                priceList = priceService.getCarrierPriceList(quote,
                        vehicle, carriers);
            }
            return new Quote(quote.getPickupPostcode(), quote.getDeliveryPostcode(), quote.getVehicle(), priceList);
        }

        Long price = priceService.getSimplePostcodePrice(quote);
        return new Quote(quote.getPickupPostcode(), quote.getDeliveryPostcode(), quote.getVehicle(), price);
    }
}
