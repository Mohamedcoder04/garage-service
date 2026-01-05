package com.renault.mobility.garage.service;

import com.renault.mobility.garage.domain.Vehicle;
import com.renault.mobility.garage.dto.PageResponse;
import com.renault.mobility.garage.dto.VehicleDto;

public interface IVehicleService {

    VehicleDto addVehicleToGarage(Long garageId, VehicleDto vehicleDTO);

    VehicleDto getVehicleById(Long id);

    VehicleDto updateVehicle(Long id, VehicleDto vehicleDTO);

    void deleteVehicle(Long id);

    PageResponse<VehicleDto> getVehiclesByGarageId(int page, int size, Long garageId);

    PageResponse<VehicleDto> getVehiclesByModel(int page, int size, String modelName);

    Vehicle findVehicleEntityByIdOrThrow(Long id);
}
