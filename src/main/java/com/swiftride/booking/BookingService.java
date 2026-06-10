package com.swiftride.booking;

import com.swiftride.bus.Bus;
import com.swiftride.bus.BusRepository;
import com.swiftride.dto.BookingRequest;
import com.swiftride.exception.ResourceNotFoundException;
import com.swiftride.exception.SeatNotAvailableException;
import com.swiftride.user.User;
import com.swiftride.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final BusRepository busRepository;

    public Booking bookTicket(BookingRequest request) {

        Authentication authentication =
                SecurityContextHolder.getContext()
                        .getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found"));

        Bus bus = busRepository.findById(request.getBusId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Bus not found"));

        if (bus.getAvailableSeats() < request.getSeatCount()) {
            throw new SeatNotAvailableException(
                    "Seats not available");
        }

        bus.setAvailableSeats(
                bus.getAvailableSeats()
                        - request.getSeatCount());

        busRepository.save(bus);

        Booking booking = Booking.builder()
                .user(user)
                .bus(bus)
                .seatCount(request.getSeatCount())
                .totalFare(
                        bus.getFare()
                                * request.getSeatCount())
                .bookingTime(LocalDateTime.now())
                .status("CONFIRMED")
                .build();

        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUser(Long userId) {

        return bookingRepository.findByUserUserId(userId);
    }

    @Transactional
    public String cancelBooking(Long bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Booking not found"));

        if ("CANCELLED".equals(booking.getStatus())) {
            throw new RuntimeException(
                    "Booking already cancelled");
        }

        Bus bus = booking.getBus();

        bus.setAvailableSeats(
                bus.getAvailableSeats()
                        + booking.getSeatCount());

        busRepository.save(bus);

        booking.setStatus("CANCELLED");

        bookingRepository.save(booking);

        return "Booking Cancelled Successfully";
    }
}