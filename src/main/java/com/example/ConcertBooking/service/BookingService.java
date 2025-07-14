package com.example.ConcertBooking.service;

import com.example.ConcertBooking.model.Booking;
import com.example.ConcertBooking.model.Concert;
import com.example.ConcertBooking.repository.BookingRepository;
import com.example.ConcertBooking.repository.ConcertRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final ConcertRepository concertRepository;

    public BookingService(BookingRepository bookingRepository, ConcertRepository concertRepository) {
        this.bookingRepository = bookingRepository;
        this.concertRepository = concertRepository;
    }

    @Transactional
    public String bookTicket(Long concertId, String email) {
        Concert concert = concertRepository.findAndLockById(concertId)
            .orElseThrow(() -> new RuntimeException("Concert not found"));

        if (concert.getMaxTickets() <= 0) {
            throw new RuntimeException("Tickets sold out");
        }
        System.out.println(concert.getMaxTickets());

        concert.setMaxTickets(concert.getMaxTickets() - 1);
        concertRepository.save(concert);

        Booking booking = new Booking();
        booking.setConcert(concert);
        booking.setEmail(email);
        booking.setBookingTime(LocalDateTime.now());
        bookingRepository.save(booking);
        
        System.out.println(concert.getMaxTickets());

        return "Booking confirmed for " + email;
    }
}
