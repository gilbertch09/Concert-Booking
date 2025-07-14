package com.example.ConcertBooking.controller;

import com.example.ConcertBooking.service.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/book")
    public String bookTicket(@RequestParam Long concertId, @RequestParam String email) {
        return bookingService.bookTicket(concertId, email);
    }
}
