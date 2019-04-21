package com.shutl.service;

import com.shutl.model.Carrier;
import com.shutl.model.Vehicle;

import java.util.List;

/**
 * Data retrieval queries
 */
public interface DataService {
    /**
     * Loads the markup data for a vehicle
     * @param vehicle to search for
     */
    Vehicle getVehicleByName(String vehicle);

    /**
     * Loads the carrier pricing data
     */
    List<Carrier> getCarriers();
}
