package com.renault.mobility.garage.repository;

import com.renault.mobility.garage.domain.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessoryRepository extends JpaRepository<Accessory, Long> {

    List<Accessory> findAllByVehicleId(Long vehicleId);

}
