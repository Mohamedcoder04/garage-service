package com.renault.mobility.garage.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.renault.mobility.garage.domain.Garage;
import com.renault.mobility.garage.repository.GarageRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class MockData {
    private final GarageRepository garageRepository;
    private final ObjectMapper objectMapper;

    @PostConstruct
    public void loadDoctors() {
        try {
            if (garageRepository.count() == 0) {
                InputStream inputStream = new ClassPathResource("garages.json").getInputStream();
                List<Garage> garages = objectMapper.readValue(inputStream, new TypeReference<>() {
                });

                garageRepository.saveAll(garages);
                log.info("Doctors loaded successfully!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
