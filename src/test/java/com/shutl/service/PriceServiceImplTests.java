package com.shutl.service;

import com.shutl.model.Carrier;
import com.shutl.model.CarrierService;
import com.shutl.model.Quote;
import com.shutl.model.ServicePrice;
import com.shutl.model.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PriceServiceImplTests {
    @Mock
    private DataService dataService;

    private PriceService priceService = new PriceServiceImpl();

    @Test
    public void testGetSimplePostcodePrice() {
        Quote quoteRequest = new Quote("SW1A1AA", "EC2A3LT");
        Long price = priceService.getSimplePostcodePrice(quoteRequest);
        assertEquals(new Long(316), price);
    }

    @Test
    public void testGetSimplePostcodePriceWithVehicleMarkup() {
        when(dataService.getVehicleByName("bicycle")).thenReturn(new Vehicle("bicycle", 10));
        Quote quoteRequest = new Quote("SW1A1AA", "EC2A3LT", "bicycle");
        Long price = priceService.getSimplePostcodePriceWithVehicleMarkup(quoteRequest,
                dataService.getVehicleByName("bicycle"));
        assertEquals(new Long(348), price);
    }

    @Test
    public void testGetCarrierPriceList() {
        // Ideally need fluent builders
        List<String> vehicles = new ArrayList<>();
        vehicles.add("bicycle");
        vehicles.add("motorbike");
        CarrierService carrierService = new CarrierService(5, 5, vehicles);
        List<CarrierService> carrierServices = new ArrayList<>();
        carrierServices.add(carrierService);
        Carrier carrier = new Carrier("CollectTimes", new Long(50), carrierServices);
        List<Carrier> carriersExpected = new ArrayList<>();
        carriersExpected.add(carrier);

        when(dataService.getCarriers()).thenReturn(carriersExpected);
        when(dataService.getVehicleByName("bicycle")).thenReturn(new Vehicle("bicycle", 10));
        Quote quoteRequest = new Quote("SW1A1AA", "EC2A3LT", "bicycle");

        List<ServicePrice> servicePrices = priceService.getCarrierPriceList(quoteRequest,
                dataService.getVehicleByName("bicycle"), dataService.getCarriers());

        assertEquals("CollectTimes", servicePrices.get(0).getService());
        assertEquals(5, servicePrices.get(0).getDeliveryTime());
        assertEquals(new Long(401), servicePrices.get(0).getPrice());
    }
}
