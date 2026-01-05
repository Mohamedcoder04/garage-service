package com.renault.mobility.garage.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> {
    private List<T> elements;
    private int number;
    private int size;
    private Long totalElement;
    private int totalPages;
}
