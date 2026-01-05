package com.renault.mobility.garage.repository.specification;

import com.renault.mobility.garage.domain.Accessory;
import com.renault.mobility.garage.domain.Garage;
import com.renault.mobility.garage.domain.Vehicle;
import com.renault.mobility.garage.dto.GarageSearchCriteria;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class GarageSpecification {

    private static final String TYPE_CARBURANT = "typeCarburant";
    private static final String VEHICLES = "vehicles";
    private static final String ACCESSORIES = "accessories";
    private static final String ACCESSORY_TYPE = "type";

    private GarageSpecification() {
    }

    public static Specification<Garage> build(GarageSearchCriteria criteria) {
        return hasType(criteria.type())
                .and(hasAccessory(criteria.accessoryCode()));
    }

    private static Specification<Garage> hasAccessory(String accessoryCode) {
        return (root, query, cb) -> {
            if (StringUtils.isBlank(accessoryCode)) return cb.conjunction();

            Join<Garage, Vehicle> vehicleJoin = root.join(VEHICLES, JoinType.INNER);
            Join<Vehicle, Accessory> accessoryJoin = vehicleJoin.join(ACCESSORIES, JoinType.INNER);

            return cb.equal(cb.lower(accessoryJoin.get(ACCESSORY_TYPE)), accessoryCode.toLowerCase());
        };
    }

    private static Specification<Garage> hasType(String type) {
        return (root, query, cb) -> {
            if (StringUtils.isBlank(type)) return cb.conjunction();

            Join<Garage, Vehicle> vehicleJoin = root.join(VEHICLES, JoinType.INNER);

            return cb.equal(vehicleJoin.get(TYPE_CARBURANT), type);
        };
    }

}
