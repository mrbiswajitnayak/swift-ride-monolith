package com.swiftride.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BookingConsumer {

    @KafkaListener(
            topics = "booking-created",
            groupId = "swift-ride-group")
    public void consumeBookingEvent(String message) {

        System.out.println(
                "Booking Event Received : "
                        + message);
    }
}