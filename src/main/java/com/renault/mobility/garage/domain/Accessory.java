package com.renault.mobility.garage.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Accessory extends AbstractEntity {

    private String nom;

    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal prix;

    @Column(nullable = false)
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Accessory other)) return false;

        return getId().equals(other.getId());
    }


    @Override
    public String toString() {
        return String.format("Accessory [nom=%s, description=%s, prix=%s, type=%s]",
                nom, description, prix, type);
    }

}
