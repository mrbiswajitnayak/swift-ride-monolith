package com.swiftride.bus;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusService {

    private final BusRepository busRepository;

    public Bus addBus(Bus bus) {

        return busRepository.save(bus);
    }

    public List<Bus> getAllBuses() {

        return busRepository.findAll();
    }

    public Bus getBusById(Long busId) {

        return busRepository.findById(busId)
                .orElseThrow(() ->
                        new RuntimeException("Bus not found"));
    }

    public List<Bus> searchBus(
            String source,
            String destination) {

        return busRepository
                .findBySourceAndDestination(
                        source,
                        destination);
    }
}