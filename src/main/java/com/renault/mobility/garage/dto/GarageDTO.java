package com.renault.mobility.garage.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record GarageDTO(
        Long id,
        @NotBlank(message = "Le nom du garage est obligatoire")
        @Size(max = 100, message = "Le nom ne peut pas dépasser 100 caractères")
        String name,
        @NotBlank(message = "L'adresse est obligatoire")
        String address,
        @NotBlank(message = "Le téléphone est obligatoire")
        String telephone,
        @NotBlank(message = "L'email est obligatoire")
        @Email(message = "Format d'email invalide")
        String email,
        @NotNull(message = "Les horaires d'ouverture sont obligatoires.")
        @Schema(
                description = "Horaires d'ouverture par jour",
                example = """
                        {
                          "MONDAY": [
                            {"startTime":"08:30","endTime":"12:30"},
                            {"startTime":"14:00","endTime":"18:00"}
                          ],
                          "TUESDAY": [
                            {"startTime":"08:30","endTime":"12:30"},
                            {"startTime":"14:00","endTime":"18:00"}
                          ],
                          "WEDNESDAY": [
                            {"startTime":"08:30","endTime":"12:30"},
                            {"startTime":"14:00","endTime":"18:00"}
                          ],
                          "THURSDAY": [
                            {"startTime":"08:30","endTime":"12:30"},
                            {"startTime":"14:00","endTime":"18:00"}
                          ],
                          "FRIDAY": [
                            {"startTime":"08:30","endTime":"12:30"},
                            {"startTime":"14:00","endTime":"18:00"}
                          ],
                          "SATURDAY": [
                            {"startTime":"09:00","endTime":"13:00"}
                          ],
                          "SUNDAY": []
                        }
                        """
        )
        Map<DayOfWeek, List<OpeningTimeDto>> openingHours,
        List<VehicleDto> vehicles

) {
}
