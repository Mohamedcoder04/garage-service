package com.renault.mobility.garage.mock;

import com.renault.mobility.garage.domain.Accessory;
import com.renault.mobility.garage.domain.Vehicle;
import com.renault.mobility.garage.dto.AccessoryDto;
import com.renault.mobility.garage.dto.VehicleDto;

import java.math.BigDecimal;

public class VehicleMock {
    public static final Long VEHICLE_ID = 1L;
    public static final String VEHICLE_BRAND = "VEHICLE_BRAND";
    public static final String VEHICLE_MODEL_NAME = "VEHICLE_MODEL_NAME";
    public static final int VEHICLE_ANNEE_FABRICATION = 1990;
    public static final String VEHICLE_TYPE_CARBURANT = "VEHICLE_TYPE_CARBURANT";


    public static Vehicle getVehicle() {
        return Vehicle.builder()
                .id(VEHICLE_ID)
                .brand(VEHICLE_BRAND)
                .modelName(VEHICLE_MODEL_NAME)
                .anneeFabrication(VEHICLE_ANNEE_FABRICATION)
                .typeCarburant(VEHICLE_TYPE_CARBURANT)
                .build();
    }

    public static VehicleDto getVehicleDto() {
        return new VehicleDto(
                VEHICLE_ID,
                VEHICLE_BRAND,
                VEHICLE_MODEL_NAME,
                VEHICLE_ANNEE_FABRICATION,
                VEHICLE_TYPE_CARBURANT,
                null,
                null
        );
    }


}
