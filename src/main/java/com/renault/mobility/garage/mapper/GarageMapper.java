package com.renault.mobility.garage.mapper;

import com.renault.mobility.garage.domain.Garage;
import com.renault.mobility.garage.dto.GarageDTO;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

import static com.renault.mobility.garage.mapper.OpeningTimeMapper.mapToOpeningHours;
import static com.renault.mobility.garage.mapper.OpeningTimeMapper.mapToOpeningHoursDTO;

public interface GarageMapper {

    static Garage mapToGarage(GarageDTO dto) {
        if (Objects.isNull(dto)) return null;

        return Garage.builder()
                .id(dto.id())
                .name(dto.name())
                .address(dto.address())
                .telephone(dto.telephone())
                .email(dto.email())
                .openingHours(mapToOpeningHours(dto.openingHours()))
                .vehicles(
                        Optional.ofNullable(dto.vehicles())
                                .orElse(Collections.emptyList())
                                .stream()
                                .filter(Objects::nonNull)
                                .map(VehicleMapper::mapToVehicle)
                                .toList()
                )
                .build();
    }

    static GarageDTO mapToGarageDto(Garage garage) {
        if (Objects.isNull(garage)) return null;
        return new GarageDTO(
                garage.getId(),
                garage.getName(),
                garage.getAddress(),
                garage.getTelephone(),
                garage.getEmail(),
                mapToOpeningHoursDTO(garage.getOpeningHours()),
                Optional.ofNullable(garage.getVehicles())
                        .orElse(Collections.emptyList())
                        .stream()
                        .filter(Objects::nonNull)
                        .map(VehicleMapper::maptoVehicleDto)
                        .toList()
        );
    }

}
