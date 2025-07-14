package com.example.ConcertBooking.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import redis.clients.jedis.Jedis;

@Entity
public class Concert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    private LocalDateTime bookingStart;
    private LocalDateTime bookingEnd;
    private LocalDateTime concertTime;

    private Integer maxTickets;

    private int version;

    // ✅ Optional: Redis-based ticket decrement method for Level 3 booking
    @Transient
    public long decrementTicketStock() {
        try (Jedis jedis = new Jedis("localhost", 6379)) {
            String redisKey = "concert:" + this.getId() + ":tickets";
            return jedis.decr(redisKey);
        }
    }

    // ✅ Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getBookingStart() {
        return bookingStart;
    }

    public void setBookingStart(LocalDateTime bookingStart) {
        this.bookingStart = bookingStart;
    }

    public LocalDateTime getBookingEnd() {
        return bookingEnd;
    }

    public void setBookingEnd(LocalDateTime bookingEnd) {
        this.bookingEnd = bookingEnd;
    }

    public LocalDateTime getConcertTime() {
        return concertTime;
    }

    public void setConcertTime(LocalDateTime concertTime) {
        this.concertTime = concertTime;
    }

    public Integer getMaxTickets() {
        return maxTickets;
    }

    public void setMaxTickets(Integer maxTickets) {
        this.maxTickets = maxTickets;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
