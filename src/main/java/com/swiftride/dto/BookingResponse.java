package com.swiftride.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingResponse {

    private Long bookingId;
    private String busName;
    private Integer seatCount;
    private Double totalFare;
    private String status;
}