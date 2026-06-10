package com.swiftride.booking;

import com.swiftride.dto.BookingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public Booking bookTicket(
          @Valid  @RequestBody BookingRequest request) {

        return bookingService.bookTicket(request);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getUserBookings(
            @PathVariable Long userId) {

        return bookingService.getBookingsByUser(userId);
    }

    @DeleteMapping("/{bookingId}")
    public String cancelBooking(
            @PathVariable Long bookingId) {

        return bookingService
                .cancelBooking(bookingId);
    }
}