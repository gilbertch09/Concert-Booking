package com.example.ConcertBooking.service;

import com.example.ConcertBooking.model.Concert;
import com.example.ConcertBooking.repository.ConcertRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConcertService {
    private final ConcertRepository concertRepository;

    public ConcertService(ConcertRepository concertRepository) {
        this.concertRepository = concertRepository;
    }

    public List<Concert> getAvailableConcerts() {
        return concertRepository.findAvailableConcerts(LocalDateTime.now());
    }

    public List<Concert> getAllConcerts() {
        return concertRepository.findAll();
    }
}