package com.renault.mobility.garage.web.api;

import com.renault.mobility.garage.dto.AccessoryDto;
import com.renault.mobility.garage.dto.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RequestMapping("/accessories")
@Tag(name = "Accessories", description = "Gestion des accessoires (CRUD) et association aux véhicules")
public interface IAccessoryController {

    @Operation(
            summary = "Ajouter un accessoire à un véhicule",
            description = "Crée un accessoire et l’associe au véhicule spécifié."
    )
    @PostMapping("/vehicles/{vehicleId}")
    ResponseEntity<AccessoryDto> addAccessoryToVehicle(
            @PathVariable Long vehicleId,
            @Valid @RequestBody AccessoryDto accessoryDTO
    );

    @Operation(
            summary = "Lister les accessoires d’un véhicule",
            description = "Retourne la liste des accessoires associés au véhicule spécifié."
    )
    @GetMapping("/vehicles/{vehicleId}")
    ResponseEntity<List<AccessoryDto>> getAccessoriesByVehicleId(@PathVariable Long vehicleId);

    @Operation(
            summary = "Lister tous les accessoires (paginé)",
            description = "Retourne une page d’accessoires avec pagination."
    )
    @GetMapping
    ResponseEntity<PageResponse<AccessoryDto>> getAllAccessories(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "5") int size
    );

    @Operation(
            summary = "Obtenir un accessoire par ID",
            description = "Retourne les détails d’un accessoire par identifiant."
    )
    @GetMapping("/{id}")
    ResponseEntity<AccessoryDto> getAccessoryById(@PathVariable Long id);

    @Operation(
            summary = "Mettre à jour un accessoire",
            description = "Met à jour les informations d’un accessoire existant."
    )
    @PutMapping("/{id}")
    ResponseEntity<AccessoryDto> updateAccessory(
            @PathVariable Long id,
            @Valid @RequestBody AccessoryDto accessoryDTO
    );

    @Operation(
            summary = "Supprimer un accessoire",
            description = "Supprime un accessoire par son identifiant."
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteAccessory(@PathVariable Long id);

}
