package com.renault.mobility.garage.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.renault.mobility.garage.mock.AccessoryMock.getAccessory;
import static com.renault.mobility.garage.mock.AccessoryMock.getAccessoryDto;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AccessoryMapperTest {

    @Test
    public void shouldMapToAccessory() {
        assertEquals(getAccessory(), AccessoryMapper.mapToAccessory(getAccessoryDto()));
    }

    @Test
    public void shouldMapToAccessoryDto() {
        assertEquals(getAccessoryDto(), AccessoryMapper.mapToAccessoryDto(getAccessory()));
    }

}