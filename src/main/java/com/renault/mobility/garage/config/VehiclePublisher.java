package com.renault.mobility.garage.config;

import com.renault.mobility.garage.dto.VehicleEvent;
import com.renault.mobility.garage.dto.VehicleDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;
import java.util.function.Function;

@Configuration
public class VehiclePublisher {

    @Bean
    public Function<VehicleDto, VehicleEvent> createVehicle() {
        return vehicleDto -> new VehicleEvent(
                UUID.randomUUID().toString(),
                vehicleDto.brand(),
                vehicleDto.modelName()
        );
    }

}
