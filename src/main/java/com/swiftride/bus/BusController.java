package com.swiftride.bus;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/buses")
@RequiredArgsConstructor
public class BusController {

    private final BusService busService;

    @PostMapping
    @PreAuthorize("hasRole('VENDOR')")
    public Bus addBus(
            @RequestBody Bus bus) {

        return busService.addBus(bus);
    }

    @GetMapping
    public List<Bus> getAllBuses() {

        return busService.getAllBuses();
    }

    @GetMapping("/{id}")
    public Bus getBusById(
            @PathVariable Long id) {

        return busService.getBusById(id);
    }

    @GetMapping("/search")
    public List<Bus> searchBus(
            @RequestParam String source,
            @RequestParam String destination) {

        return busService.searchBus(
                source,
                destination);
    }
}