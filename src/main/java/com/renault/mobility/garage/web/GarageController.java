package com.renault.mobility.garage.web;

import com.renault.mobility.garage.dto.GarageDTO;
import com.renault.mobility.garage.dto.GarageSearchCriteria;
import com.renault.mobility.garage.dto.PageResponse;
import com.renault.mobility.garage.service.IGarageService;
import com.renault.mobility.garage.web.api.IGarageController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GarageController implements IGarageController {

    private final IGarageService garageService;

    @Override
    public ResponseEntity<GarageDTO> createGarage(GarageDTO garageDTO) {
        return ResponseEntity.ok(garageService.createGarage(garageDTO));
    }

    @Override
    public ResponseEntity<GarageDTO> updateGarage(Long id, GarageDTO garageDTO) {
        return ResponseEntity.ok(garageService.updateGarage(id, garageDTO));
    }

    @Override
    public ResponseEntity<Void> deleteGarage(Long id) {
        garageService.deleteGarage(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<GarageDTO> getGarageById(Long id) {
        return ResponseEntity.ok(garageService.getGarageById(id));
    }

    @Override
    public ResponseEntity<PageResponse<GarageDTO>> getAllGarages(int page, int size, String sortBy, String direction) {
        return ResponseEntity.ok(garageService.getAllGarages(page, size, sortBy, direction));
    }

    @Override
    public ResponseEntity<PageResponse<GarageDTO>> searchGarages(int page, int size, GarageSearchCriteria searchCriteria) {
        return ResponseEntity.ok(garageService.searchGarages(page, size, searchCriteria));
    }
}