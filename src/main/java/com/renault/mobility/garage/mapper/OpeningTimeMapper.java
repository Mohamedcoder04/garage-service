package com.renault.mobility.garage.mapper;

import com.renault.mobility.garage.domain.OpeningTime;
import com.renault.mobility.garage.dto.OpeningTimeDto;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface OpeningTimeMapper {

    static Map<DayOfWeek, List<OpeningTimeDto>> mapToOpeningHoursDTO(Map<DayOfWeek, List<OpeningTime>> horairesOuverture) {
        if (horairesOuverture == null) {
            return new HashMap<>();
        }

        return horairesOuverture.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .map(openingTime -> new OpeningTimeDto(openingTime.getStartTime(), openingTime.getEndTime()))
                                .collect(Collectors.toList())
                ));
    }

    static Map<DayOfWeek, List<OpeningTime>> mapToOpeningHours(Map<DayOfWeek, List<OpeningTimeDto>> horairesOuverture) {
        if (horairesOuverture == null) {
            return new HashMap<>();
        }

        return horairesOuverture.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .map(dto -> new OpeningTime(dto.startTime(), dto.endTime()))
                                .collect(Collectors.toList())
                ));
    }

}
