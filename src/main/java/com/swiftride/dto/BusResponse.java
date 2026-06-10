package com.swiftride.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusResponse {

    private Long busId;
    private String busName;
    private String source;
    private String destination;
    private Integer availableSeats;
    private Double fare;
    private String busType;
}