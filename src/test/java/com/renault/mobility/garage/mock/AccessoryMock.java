package com.renault.mobility.garage.mock;

import com.renault.mobility.garage.domain.Accessory;
import com.renault.mobility.garage.domain.Vehicle;
import com.renault.mobility.garage.dto.AccessoryDto;

import java.math.BigDecimal;

import static com.renault.mobility.garage.mock.VehicleMock.VEHICLE_ID;

public class AccessoryMock {

    public static final Long ACCESSORY_ID = 1L;
    public static final String ACCESSORY_NAME = "ACCESSORY_NAME";
    public static final String ACCESSORY_DESCRIPTION = "DESCRIPTION";
    public static final BigDecimal ACCESSORY_PRIX = BigDecimal.ONE;
    public static final String ACCESSORY_TYPE = "ACCESSORY_TYPE";

    public static Accessory getAccessory() {
        return Accessory.builder()
                .id(ACCESSORY_ID)
                .nom(ACCESSORY_NAME)
                .description(ACCESSORY_DESCRIPTION)
                .prix(ACCESSORY_PRIX)
                .type(ACCESSORY_TYPE)
                .vehicle(Vehicle.builder().id(VEHICLE_ID).build())
                .build();
    }

    public static AccessoryDto getAccessoryDto() {
        return new AccessoryDto(
                ACCESSORY_ID,
                ACCESSORY_NAME,
                ACCESSORY_DESCRIPTION,
                ACCESSORY_PRIX,
                ACCESSORY_TYPE,
                VEHICLE_ID
        );
    }

}
