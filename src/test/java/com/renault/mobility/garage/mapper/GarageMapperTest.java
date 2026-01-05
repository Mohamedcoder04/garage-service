package com.renault.mobility.garage.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.renault.mobility.garage.mock.GarageMock.getGarage;
import static com.renault.mobility.garage.mock.GarageMock.getGarageDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class GarageMapperTest {

    @Test
    public void shouldMapToGarage() {
        assertEquals(getGarage(), GarageMapper.mapToGarage(getGarageDto()));
    }

    @Test
    public void shouldMapToAccessoryDto() {
        assertEquals(getGarageDto(), GarageMapper.mapToGarageDto(getGarage()));
    }

    @Test
    public void shouldReturnNullWhenAccessoryIsNull() {
        assertNull(AccessoryMapper.mapToAccessory(null));
    }

    @Test
    public void shouldReturnNullWhenAccessoryDtoIsNull() {
        assertNull(AccessoryMapper.mapToAccessoryDto(null));
    }

}