package com.example.ConcertBooking.controller;

import com.example.ConcertBooking.model.Concert;
import com.example.ConcertBooking.service.ConcertService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/concerts")
public class ConcertController {
    private final ConcertService concertService;

    public ConcertController(ConcertService concertService) {
        this.concertService = concertService;
    }

    @GetMapping("/available")
    public List<Concert> getAvailableConcerts() {
        return concertService.getAvailableConcerts();
    }

}