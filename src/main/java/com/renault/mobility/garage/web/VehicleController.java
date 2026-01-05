package com.renault.mobility.garage.web;

import com.renault.mobility.garage.dto.PageResponse;
import com.renault.mobility.garage.dto.VehicleDto;
import com.renault.mobility.garage.service.IVehicleService;
import com.renault.mobility.garage.web.api.IVehicleController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VehicleController implements IVehicleController {

    private final IVehicleService vehicleService;

    @Override
    public ResponseEntity<VehicleDto> addVehicleToGarage(Long garageId, VehicleDto vehicleDTO) {
        return ResponseEntity.ok(vehicleService.addVehicleToGarage(garageId, vehicleDTO));
    }

    @Override
    public ResponseEntity<VehicleDto> getVehicleById(Long id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    @Override
    public ResponseEntity<VehicleDto> updateVehicle(Long id, VehicleDto vehicleDTO) {
        return ResponseEntity.ok(vehicleService.updateVehicle(id, vehicleDTO));
    }

    @Override
    public ResponseEntity<Void> deleteVehicle(Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<PageResponse<VehicleDto>> getVehiclesByGarageId(int page, int size, Long garageId) {
        return ResponseEntity.ok(vehicleService.getVehiclesByGarageId(page, size, garageId));
    }

    @Override
    public ResponseEntity<PageResponse<VehicleDto>> getVehiclesByModel(int page, int size, String modelName) {
        return ResponseEntity.ok(vehicleService.getVehiclesByModel(page, size, modelName));
    }
}
