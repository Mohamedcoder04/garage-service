package com.renault.mobility.garage.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record VehicleDto(
        Long id,
        @NotBlank(message = "Le nom de la marque est obligatoire")
        @Size(max = 100, message = "La marque ne doit pas dépasser 100 caractères")
        @Schema(description = "Marque du véhicule", example = "Renault", maxLength = 100)
        String brand,
        @NotBlank(message = "Le modelName du véhicule est obligatoire")
        @Size(max = 100, message = "Le nom du modèle ne doit pas dépasser 100 caractères")
        @Schema(description = "Nom du modèle", example = "Clio", maxLength = 100)
        String modelName,
        @Min(value = 1990, message = "L'année de fabrication doit être ≥ 1990")
        @Schema(description = "Année de fabrication", example = "2020", minimum = "1990")
        Integer anneeFabrication,
        @NotNull(message = "Le type de carburant est obligatoire")
        @Schema(
                description = "Type de carburant",
                example = "DIESEL",
                allowableValues = {"DIESEL", "ESSENCE", "ELECTRIQUE", "HYBRIDE"}
        )
        String typeCarburant,
        Long garageId,
        String garageName

) {
}
