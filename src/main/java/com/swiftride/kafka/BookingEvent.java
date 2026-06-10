package com.swiftride.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingEvent {

    private Long bookingId;
    private Long userId;
    private Long busId;
    private Integer seatCount;
}