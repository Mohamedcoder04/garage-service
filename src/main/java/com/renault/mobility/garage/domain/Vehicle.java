package com.renault.mobility.garage.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle extends AbstractEntity {

    private String brand;

    private String modelName;

    private Integer anneeFabrication;

    private String typeCarburant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "garage_id")
    private Garage garage;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Accessory> accessories = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle other)) return false;

        return getId().equals(other.getId());
    }

    @Override
    public String toString() {
        return String.format("Vehicle [brand=%s, modelName=%s, anneeFabrication=%d, typeCarburant=%s]",
                brand, modelName, anneeFabrication, typeCarburant);
    }
}
