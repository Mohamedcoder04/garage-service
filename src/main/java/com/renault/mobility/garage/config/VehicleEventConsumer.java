package com.renault.mobility.garage.config;

import com.renault.mobility.garage.dto.VehicleEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class VehicleEventConsumer {

    @Bean
    public Consumer<VehicleEvent> vehicleConsumer() {
        log.info("Vehicle consumer ready to receive messages");
        return vehicleEvent -> {
            log.info("Vehicle {} créé avec succès", vehicleEvent.toString());
        };
    }

}
