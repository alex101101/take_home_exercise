package com.shutl.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.shutl.model.Carrier;
import com.shutl.model.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataServiceImpl implements DataService {
    private ObjectMapper mapper;
    private List<Carrier> carriers;
    private Map<String, Vehicle> vehicles;
    Logger logger = LoggerFactory.getLogger(DataServiceImpl.class);

    public DataServiceImpl() {
        this.mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        try {
            loadCarrierInformation();
            loadVehicleInformation();
        } catch (IOException e) {
            throw new BeanInitializationException(e.getMessage());
        }
        logger.info("Application data loaded");
    }

    private void loadCarrierInformation() throws IOException {
        carriers = mapper.readValue(new File("src/data/carrier_data.json"),
                new TypeReference<List<Carrier>>(){});
    }

    private void loadVehicleInformation() throws IOException {
        vehicles = new HashMap<>();
        List<Vehicle> vehicleList = mapper.readValue(new File("src/data/vehicle_data.json"),
                new TypeReference<List<Vehicle>>(){});

        for (Vehicle vehicle : vehicleList) {
            String vehicleName = vehicle.getVehicle();
            vehicles.put(vehicleName, vehicle);
        }
    }

    public Vehicle getVehicleByName(String vehicle) {
        return vehicles.get(vehicle);
    }

    public List<Carrier> getCarriers() {
        return carriers;
    }
}
