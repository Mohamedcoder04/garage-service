package com.renault.mobility.garage.repository;

import com.renault.mobility.garage.domain.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    long countByGarageId(@Param("garageId") Long garageId);

    Page<Vehicle> findAllByGarageId(Long garageId, Pageable pageable);

    Page<Vehicle> findAllByModelNameIgnoreCase(String modelName, Pageable pageable);
}
