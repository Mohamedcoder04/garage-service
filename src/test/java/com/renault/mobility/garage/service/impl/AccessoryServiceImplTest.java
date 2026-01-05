package com.renault.mobility.garage.service.impl;

import com.renault.mobility.garage.domain.Accessory;
import com.renault.mobility.garage.dto.AccessoryDto;
import com.renault.mobility.garage.repository.AccessoryRepository;
import com.renault.mobility.garage.service.IAccessoryService;
import com.renault.mobility.garage.service.IVehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.renault.mobility.garage.mock.AccessoryMock.*;
import static com.renault.mobility.garage.mock.VehicleMock.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccessoryServiceImplTest {

    private IAccessoryService accessoryService;

    @Mock
    private AccessoryRepository accessoryRepository;
    @Mock
    private IVehicleService vehicleService;

    @BeforeEach
    public void setUp() {
        accessoryService = new AccessoryServiceImpl(accessoryRepository, vehicleService);
    }


    @Test
    public void shouldAddAccessoryToVehicle() {
        AccessoryDto dto = new AccessoryDto(null, ACCESSORY_NAME, ACCESSORY_DESCRIPTION, ACCESSORY_PRIX, ACCESSORY_TYPE, null);
        when(vehicleService.findVehicleEntityByIdOrThrow(VEHICLE_ID)).thenReturn(getVehicle());
        when(accessoryRepository.save(any(Accessory.class))).thenReturn(getAccessory());

        AccessoryDto result = accessoryService.addAccessoryToVehicle(VEHICLE_ID, dto);

        AccessoryDto expected = getAccessoryDto();
        assertAll(
                () -> assertEquals(expected.id(), result.id()),
                () -> assertEquals(expected.nom(), result.nom()),
                () -> assertEquals(expected.description(), result.description()),
                () -> assertEquals(expected.prix(), result.prix()),
                () -> assertEquals(expected.type(), result.type())
        );

        verify(vehicleService, times(1)).findVehicleEntityByIdOrThrow(VEHICLE_ID);
        verify(accessoryRepository, times(1)).save(any(Accessory.class));
        verifyNoMoreInteractions(vehicleService, accessoryRepository);
    }


}