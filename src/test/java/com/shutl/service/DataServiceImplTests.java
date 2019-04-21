package com.shutl.service;

import com.shutl.model.Carrier;
import com.shutl.model.Vehicle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DataServiceImplTests {
    @Test
    public void testGetVehicleByName() {
        DataServiceImpl dataService = new DataServiceImpl();
        Vehicle vehicle = dataService.getVehicleByName("large_van");
        assertEquals("large_van", vehicle.getVehicle());
        assertEquals(40, vehicle.getMarkup());
    }

    @Test
    public void testGetCarriers() {
        DataServiceImpl dataService = new DataServiceImpl();
        List<Carrier> carriers = dataService.getCarriers();
        assertEquals("CollectTimes", carriers.get(0).getCarrier());
        assertEquals(new Long(50), carriers.get(0).getBasePrice());
        assertEquals(1, carriers.get(0).getServices().get(0).getDeliveryTime());
        assertEquals(20, carriers.get(0).getServices().get(0).getMarkup());
        assertEquals("parcel_car", carriers.get(0).getServices().get(0).getVehicles().get(0));
    }
}
