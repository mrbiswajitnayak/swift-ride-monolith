package com.swiftride.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookingRequest {

    @NotNull(message = "Bus Id is required")
    private Long busId;

    @NotNull(message = "Seat Count is required")
    @Min(value = 1, message = "Minimum 1 seat required")
    private Integer seatCount;
}