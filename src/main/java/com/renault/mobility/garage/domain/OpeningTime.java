package com.renault.mobility.garage.domain;

import lombok.*;
import java.time.LocalTime;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpeningTime {
    private LocalTime startTime;
    private LocalTime endTime;

    @Override
    public String toString() {
        return String.format("OpeningTime [startTime=%s, endTime=%s]", startTime, endTime);
    }
}
