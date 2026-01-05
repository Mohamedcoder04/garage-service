package com.renault.mobility.garage.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record AccessoryDto(
        Long id,
        @Schema(
                description = "Nom de l'accessoire",
                example = "Caméra de recul"
        )
        @NotBlank(message = "Le nom est obligatoire")
        @Size(max = 100, message = "Le nom ne doit pas dépasser 100 caractères")
        String nom,
        @Schema(
                description = "Description de l'accessoire",
                example = "Caméra HD avec lignes de guidage dynamiques"
        )
        @Size(max = 1000, message = "La description ne doit pas dépasser 1000 caractères")
        String description,
        @Schema(
                description = "Prix TTC en dirhams (MAD)",
                example = "1499.90",
                minimum = "0.00"
        )
        @NotNull(message = "Le prix est obligatoire")
        @DecimalMin(value = "0.0", inclusive = false, message = "Le prix doit être strictement positif")
        @Digits(integer = 10, fraction = 2, message = "Le prix doit comporter au plus 10 chiffres entiers et 2 décimales")
        BigDecimal prix,

        @NotNull(message = "Le type d'accessoire est obligatoire")
        @Schema(
                description = "Type d'accessoire",
                example = "SAFETY",
                allowableValues = {"SAFETY", "INFOTAINMENT", "COMFORT", "EXTERIOR", "INTERIOR", "ELECTRICAL"}
        )
        String type,
        Long vehicleId

) {
}
