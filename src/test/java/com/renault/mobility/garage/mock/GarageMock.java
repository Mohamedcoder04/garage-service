package com.renault.mobility.garage.mock;

import com.renault.mobility.garage.domain.Accessory;
import com.renault.mobility.garage.domain.Garage;
import com.renault.mobility.garage.domain.Vehicle;
import com.renault.mobility.garage.dto.AccessoryDto;
import com.renault.mobility.garage.dto.GarageDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import static com.renault.mobility.garage.mock.AccessoryMock.ACCESSORY_ID;
import static com.renault.mobility.garage.mock.VehicleMock.VEHICLE_ID;

public class GarageMock {

    public static final Long GARAGE_ID = 1L;
    public static final String GARAGE_NAME = "GARAGE_NAME";
    public static final String GARAGE_ADDRESS = "GARAGE_ADDRESS";
    public static final String GARAGE_TELEPHONE = "GARAGE_TELEPHONE";
    public static final String GARAGE_EMAIL = "GARAGE_EMAIL";

    public static Garage getGarage() {
        return Garage.builder()
                .id(GARAGE_ID)
                .name(GARAGE_NAME)
                .address(GARAGE_ADDRESS)
                .telephone(GARAGE_TELEPHONE)
                .email(GARAGE_EMAIL)
                .build();
    }

    public static GarageDTO getGarageDto() {
        return new GarageDTO(
                GARAGE_ID,
                GARAGE_NAME,
                GARAGE_ADDRESS,
                GARAGE_TELEPHONE,
                GARAGE_EMAIL,
                new HashMap<>(),
                new ArrayList<>()
        );
    }

}
