package com.renault.mobility.garage.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.renault.mobility.garage.mock.VehicleMock.getVehicle;
import static com.renault.mobility.garage.mock.VehicleMock.getVehicleDto;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VehicleMapperTest {

    @Test
    public void shouldMapToVehicle() {
        assertEquals(getVehicle(), VehicleMapper.mapToVehicle(getVehicleDto()));
    }

    @Test
    public void shouldMapToVehicleDto() {
        assertEquals(getVehicleDto(), VehicleMapper.maptoVehicleDto(getVehicle()));
    }

}