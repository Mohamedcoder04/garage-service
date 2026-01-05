package com.renault.mobility.garage.web;

import com.renault.mobility.garage.dto.AccessoryDto;
import com.renault.mobility.garage.dto.PageResponse;
import com.renault.mobility.garage.service.IAccessoryService;
import com.renault.mobility.garage.web.api.IAccessoryController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccessoryController implements IAccessoryController {

    private final IAccessoryService accessoryService;

    @Override
    public ResponseEntity<AccessoryDto> addAccessoryToVehicle(Long vehicleId, AccessoryDto accessoryDTO) {
        return ResponseEntity.ok(accessoryService.addAccessoryToVehicle(vehicleId, accessoryDTO));
    }

    @Override
    public ResponseEntity<List<AccessoryDto>> getAccessoriesByVehicleId(Long vehicleId) {
        return ResponseEntity.ok(accessoryService.getAccessoriesByVehicleId(vehicleId));
    }

    @Override
    public ResponseEntity<PageResponse<AccessoryDto>> getAllAccessories(int page, int size) {
        return ResponseEntity.ok(accessoryService.getAllAccessories(page, size));
    }

    @Override
    public ResponseEntity<AccessoryDto> getAccessoryById(Long id) {
        return ResponseEntity.ok(accessoryService.getAccessoryById(id));
    }

    @Override
    public ResponseEntity<AccessoryDto> updateAccessory(Long id, AccessoryDto accessoryDTO) {
        return ResponseEntity.ok(accessoryService.updateAccessory(id, accessoryDTO));
    }

    @Override
    public ResponseEntity<Void> deleteAccessory(Long id) {
        accessoryService.deleteAccessory(id);
        return ResponseEntity.ok().build();
    }
}
