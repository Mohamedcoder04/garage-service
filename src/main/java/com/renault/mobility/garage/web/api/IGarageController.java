package com.renault.mobility.garage.web.api;

import com.renault.mobility.garage.dto.GarageDTO;
import com.renault.mobility.garage.dto.GarageSearchCriteria;
import com.renault.mobility.garage.dto.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequestMapping("/garages")
@Tag(name = "Garages", description = "Gestion des garages (CRUD, listing et recherche)")
public interface IGarageController {


    @Operation(
            summary = "Créer un garage",
            description = "Crée un nouveau garage à partir des données fournies."
    )
    @PostMapping
    ResponseEntity<GarageDTO> createGarage(@Valid @RequestBody GarageDTO garageDTO);


    @Operation(
            summary = "Mettre à jour un garage",
            description = "Met à jour un garage existant par son identifiant."
    )
    @PutMapping("/{id}")
    ResponseEntity<GarageDTO> updateGarage(@PathVariable Long id, @Valid @RequestBody GarageDTO garageDTO);


    @Operation(
            summary = "Supprimer un garage",
            description = "Supprime un garage par son identifiant."
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteGarage(@PathVariable Long id);


    @Operation(
            summary = "Obtenir un garage par ID",
            description = "Retourne les détails d’un garage par identifiant."
    )
    @GetMapping("/{id}")
    ResponseEntity<GarageDTO> getGarageById(@PathVariable Long id);


    @Operation(
            summary = "Lister les garages",
            description = "Retourne une page de garages avec pagination et tri."
    )
    @GetMapping
    ResponseEntity<PageResponse<GarageDTO>> getAllGarages(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    );


    @Operation(
            summary = "Rechercher des garages",
            description = "Recherche avec critères et pagination."
    )
    @PostMapping("/search")
    ResponseEntity<PageResponse<GarageDTO>> searchGarages(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "5") int size,
            @RequestBody GarageSearchCriteria searchCriteria
    );

}
