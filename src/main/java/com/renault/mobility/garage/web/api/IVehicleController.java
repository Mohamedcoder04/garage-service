package com.renault.mobility.garage.web.api;

import com.renault.mobility.garage.dto.PageResponse;
import com.renault.mobility.garage.dto.VehicleDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequestMapping("/vehicles")
@Tag(name = "Vehicles", description = "Gestion des véhicules (CRUD) et requêtes par garage ou par modèle")
public interface IVehicleController {

    @Operation(
            summary = "Ajouter un véhicule à un garage",
            description = "Crée un nouveau véhicule et l’associe au garage spécifié."
    )
    @PostMapping("/garages/{garageId}")
    ResponseEntity<VehicleDto> addVehicleToGarage(
            @PathVariable Long garageId,
            @Valid @RequestBody VehicleDto vehicleDTO
    );

    @Operation(
            summary = "Obtenir un véhicule par ID",
            description = "Retourne les détails d’un véhicule par identifiant."
    )
    @GetMapping("/{id}")
    ResponseEntity<VehicleDto> getVehicleById(@PathVariable Long id);

    @Operation(
            summary = "Mettre à jour un véhicule",
            description = "Met à jour les informations d’un véhicule existant."
    )
    @PutMapping("/{id}")
    ResponseEntity<VehicleDto> updateVehicle(
            @PathVariable Long id,
            @Valid @RequestBody VehicleDto vehicleDTO
    );

    @Operation(
            summary = "Supprimer un véhicule",
            description = "Supprime un véhicule par son identifiant."
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteVehicle(@PathVariable Long id);

    @Operation(
            summary = "Lister les véhicules d’un garage",
            description = "Retourne une page de véhicules appartenant au garage spécifié, avec pagination."
    )
    @GetMapping("/garages/{garageId}")
    ResponseEntity<PageResponse<VehicleDto>> getVehiclesByGarageId(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "5") int size,
            @PathVariable Long garageId);

    @Operation(
            summary = "Lister les véhicules par modèle",
            description = "Retourne une page de véhicules filtrés par nom de modèle, avec pagination."
    )
    @GetMapping("/model/{modelName}")
    ResponseEntity<PageResponse<VehicleDto>> getVehiclesByModel(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "5") int size,
            @PathVariable String modelName
    );
}
