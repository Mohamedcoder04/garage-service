package com.renault.mobility.garage.mapper;

import com.renault.mobility.garage.domain.Accessory;
import com.renault.mobility.garage.dto.AccessoryDto;

import java.util.Objects;

public interface AccessoryMapper {


    static Accessory mapToAccessory(AccessoryDto dto) {
        if (Objects.isNull(dto)) return null;

        return Accessory.builder()
                .id(dto.id())
                .nom(dto.nom())
                .prix(dto.prix())
                .type(dto.type())
                .description(dto.description())
                .build();
    }

    static AccessoryDto mapToAccessoryDto(Accessory accessory) {
        if (Objects.isNull(accessory)) return null;

        return new AccessoryDto(
                accessory.getId(),
                accessory.getNom(),
                accessory.getDescription(),
                accessory.getPrix(),
                accessory.getType(),
                accessory.getVehicle() != null ? accessory.getVehicle().getId() : null
        );
    }
}
