package com.renault.mobility.garage.mapper;

import com.renault.mobility.garage.domain.Garage;
import com.renault.mobility.garage.domain.Vehicle;
import com.renault.mobility.garage.dto.VehicleDto;

import java.util.Objects;

public interface VehicleMapper {

    static Vehicle mapToVehicle(VehicleDto dto) {
        if (Objects.isNull(dto)) return null;

        return Vehicle.builder()
                .id(dto.id())
                .brand(dto.brand())
                .anneeFabrication(dto.anneeFabrication())
                .modelName(dto.modelName())
                .typeCarburant(dto.typeCarburant())
                .build();
    }

    static VehicleDto maptoVehicleDto(Vehicle vehicle) {
        if (Objects.isNull(vehicle)) return null;


        Garage garage = vehicle.getGarage();

        return new VehicleDto(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getModelName(),
                vehicle.getAnneeFabrication(),
                vehicle.getTypeCarburant(),
                garage != null ? garage.getId() : null,
                garage != null ? garage.getName() : null
        );

    }
}
