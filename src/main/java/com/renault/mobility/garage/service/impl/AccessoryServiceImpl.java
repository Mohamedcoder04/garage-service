package com.renault.mobility.garage.service.impl;

import com.renault.mobility.garage.domain.Accessory;
import com.renault.mobility.garage.domain.Vehicle;
import com.renault.mobility.garage.dto.AccessoryDto;
import com.renault.mobility.garage.dto.PageResponse;
import com.renault.mobility.garage.exception.EntityNotFoundException;
import com.renault.mobility.garage.mapper.AccessoryMapper;
import com.renault.mobility.garage.repository.AccessoryRepository;
import com.renault.mobility.garage.service.IAccessoryService;
import com.renault.mobility.garage.service.IVehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.renault.mobility.garage.mapper.AccessoryMapper.mapToAccessory;
import static com.renault.mobility.garage.mapper.AccessoryMapper.mapToAccessoryDto;
import static com.renault.mobility.garage.util.Constants.ACCESSORY_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccessoryServiceImpl implements IAccessoryService {

    private final AccessoryRepository accessoryRepository;
    private final IVehicleService vehicleService;

    @Override
    public AccessoryDto addAccessoryToVehicle(Long vehicleId, AccessoryDto accessoryDTO) {

        Vehicle vehicle = vehicleService.findVehicleEntityByIdOrThrow(vehicleId);

        Accessory accessory = mapToAccessory(accessoryDTO);
        accessory.setVehicle(vehicle);

        Accessory savedAccessory = accessoryRepository.save(accessory);

        log.info("Accessoire ajouté avec succès - ID: {}", savedAccessory.getId());
        return mapToAccessoryDto(savedAccessory);
    }

    @Override
    public AccessoryDto getAccessoryById(Long id) {
        return mapToAccessoryDto(findAccessoryEntityByIdOrThrow(id));
    }

    @Override
    public PageResponse<AccessoryDto> getAllAccessories(int page, int size) {
        int pageOneBased = Math.max(1, page);
        Pageable pageable = PageRequest.of(pageOneBased - 1, size, Sort.by("id").descending());

        Page<Accessory> accessoryPages = accessoryRepository.findAll(pageable);
        List<AccessoryDto> accessoryDtos = accessoryPages.getContent().stream()
                .map(AccessoryMapper::mapToAccessoryDto)
                .toList();

        return new PageResponse<>(
                accessoryDtos,
                accessoryPages.getNumber(),
                accessoryPages.getSize(),
                accessoryPages.getTotalElements(),
                accessoryPages.getTotalPages()
        );
    }

    @Override
    public AccessoryDto updateAccessory(Long id, AccessoryDto accessoryDTO) {
        Accessory existingAccessory = findAccessoryEntityByIdOrThrow(id);

        existingAccessory.setNom(accessoryDTO.nom());
        existingAccessory.setDescription(accessoryDTO.description());
        existingAccessory.setPrix(accessoryDTO.prix());
        existingAccessory.setType(accessoryDTO.type());

        Accessory updatedAccessory = accessoryRepository.save(existingAccessory);

        log.info("Accessoire ID: {} mis à jour avec succès", updatedAccessory.getId());
        return mapToAccessoryDto(updatedAccessory);
    }

    @Override
    public void deleteAccessory(Long id) {
        findAccessoryEntityByIdOrThrow(id);

        accessoryRepository.deleteById(id);

        log.info("Accessoire [id={}] supprimé avec succès", id);
    }

    @Override
    public List<AccessoryDto> getAccessoriesByVehicleId(Long vehicleId) {
        List<Accessory> accessories = accessoryRepository.findAllByVehicleId(vehicleId);
        return accessories.stream()
                .map(AccessoryMapper::mapToAccessoryDto)
                .toList();
    }

    private Accessory findAccessoryEntityByIdOrThrow(Long id) {
        return accessoryRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format(ACCESSORY_NOT_FOUND, id))
                );
    }
}
