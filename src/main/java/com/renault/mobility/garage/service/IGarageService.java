package com.renault.mobility.garage.service;

import com.renault.mobility.garage.domain.Garage;
import com.renault.mobility.garage.dto.GarageDTO;
import com.renault.mobility.garage.dto.GarageSearchCriteria;
import com.renault.mobility.garage.dto.PageResponse;

public interface IGarageService {

    GarageDTO createGarage(GarageDTO garageDTO);

    GarageDTO updateGarage(Long id, GarageDTO garageDTO);

    void deleteGarage(Long id);

    GarageDTO getGarageById(Long id);

    PageResponse<GarageDTO> getAllGarages(int page, int size, String sortBy, String direction);

    PageResponse<GarageDTO> searchGarages(int page, int size, GarageSearchCriteria searchCriteria);

    public Garage findGarageEntityByIdOrThrow(Long id);

}
