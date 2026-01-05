package com.renault.mobility.garage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record OpeningTimeDto(
        @NotNull(message = "L'heure de début est obligatoire.")
        @JsonFormat(pattern = "HH:mm")
        @Schema(description = "Heure de début (format HH:mm)", example = "08:30")
        LocalTime startTime,

        @NotNull(message = "L'heure de fin est obligatoire.")
        @JsonFormat(pattern = "HH:mm")
        @Schema(description = "Heure de fin (format HH:mm)", example = "12:30")
        LocalTime endTime
) {
}
