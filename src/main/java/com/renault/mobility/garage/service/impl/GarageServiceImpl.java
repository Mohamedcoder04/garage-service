package com.renault.mobility.garage.service.impl;

import com.renault.mobility.garage.domain.Garage;
import com.renault.mobility.garage.dto.GarageDTO;
import com.renault.mobility.garage.dto.GarageSearchCriteria;
import com.renault.mobility.garage.dto.PageResponse;
import com.renault.mobility.garage.exception.EntityNotFoundException;
import com.renault.mobility.garage.mapper.GarageMapper;
import com.renault.mobility.garage.repository.GarageRepository;
import com.renault.mobility.garage.repository.specification.GarageSpecification;
import com.renault.mobility.garage.service.IGarageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static com.renault.mobility.garage.mapper.GarageMapper.mapToGarage;
import static com.renault.mobility.garage.mapper.GarageMapper.mapToGarageDto;
import static com.renault.mobility.garage.mapper.OpeningTimeMapper.mapToOpeningHours;
import static com.renault.mobility.garage.util.Constants.GARAGE_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
public class GarageServiceImpl implements IGarageService {

    private static final Set<String> ALLOWED_SORT_FIELDS = Set.of("name", "address");
    private final GarageRepository garageRepository;

    @Override
    public GarageDTO createGarage(GarageDTO garageDTO) {
        Garage savedGarage = garageRepository.save(mapToGarage(garageDTO));
        log.info("Garage créé avec succès : {}", savedGarage);
        return mapToGarageDto(savedGarage);
    }

    @Override
    public GarageDTO updateGarage(Long id, GarageDTO dto) {
        Garage existingGarage = findGarageEntityByIdOrThrow(id);

        existingGarage.setName(dto.name());
        existingGarage.setAddress(dto.address());
        existingGarage.setTelephone(dto.telephone());
        existingGarage.setEmail(dto.email());
        existingGarage.setOpeningHours(mapToOpeningHours(dto.openingHours()));

        Garage savedGarage = garageRepository.save(existingGarage);
        log.info("Garage mis à jour avec succès : {}", savedGarage);

        return mapToGarageDto(savedGarage);
    }

    @Override
    public GarageDTO getGarageById(Long id) {
        return mapToGarageDto(findGarageEntityByIdOrThrow(id));
    }


    @Override
    public void deleteGarage(Long id) {
        findGarageEntityByIdOrThrow(id);
        garageRepository.deleteById(id);
        log.info("Garage avec ID {} est supprimé avec succès", id);
    }


    @Override
    public PageResponse<GarageDTO> getAllGarages(int page, int size, String sortBy, String direction) {
        if (!ALLOWED_SORT_FIELDS.contains(sortBy)) {
            throw new IllegalArgumentException("Le tri avec ce shamps n'est pas autorisé");
        }

        Sort sort = Sort.by(
                Sort.Direction.fromString(direction),
                sortBy
        );
        int pageOneBased = Math.max(1, page);
        Pageable pageable = PageRequest.of(pageOneBased - 1, size, sort);
        Page<Garage> garagePages = garageRepository.findAll(pageable);
        List<GarageDTO> garageDtos = garagePages.getContent().stream()
                .map(GarageMapper::mapToGarageDto)
                .toList();

        return new PageResponse<>(
                garageDtos,
                garagePages.getNumber(),
                garagePages.getSize(),
                garagePages.getTotalElements(),
                garagePages.getTotalPages()
        );
    }

    @Override
    public PageResponse<GarageDTO> searchGarages(int page, int size, GarageSearchCriteria criteria) {
        int pageOneBased = Math.max(1, page);
        Pageable pageable = PageRequest.of(pageOneBased - 1, size, Sort.by("id").descending());
        Page<Garage> garagePages = garageRepository.findAll(
                GarageSpecification.build(criteria), pageable
        );

        List<GarageDTO> garageDtos = garagePages.getContent().stream()
                .map(GarageMapper::mapToGarageDto)
                .toList();

        return new PageResponse<>(
                garageDtos,
                garagePages.getNumber(),
                garagePages.getSize(),
                garagePages.getTotalElements(),
                garagePages.getTotalPages()
        );
    }


    public Garage findGarageEntityByIdOrThrow(Long id) {
        return garageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(GARAGE_NOT_FOUND, id)));
    }

}
