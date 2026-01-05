package com.renault.mobility.garage.service;

import com.renault.mobility.garage.dto.AccessoryDto;
import com.renault.mobility.garage.dto.PageResponse;

import java.util.List;

public interface IAccessoryService {

    AccessoryDto addAccessoryToVehicle(Long vehicleId, AccessoryDto accessoryDTO);

    AccessoryDto getAccessoryById(Long id);

    PageResponse<AccessoryDto> getAllAccessories(int page, int size);

    AccessoryDto updateAccessory(Long id, AccessoryDto accessoryDTO);

    void deleteAccessory(Long id);

    List<AccessoryDto> getAccessoriesByVehicleId(Long vehicleId);

}
