package com.example.ConcertBooking.repository;

import com.example.ConcertBooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}