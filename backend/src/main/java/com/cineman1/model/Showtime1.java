package com.cineman1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tblShowtime1")
public class Showtime1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie1 movie1;

    @ManyToOne
    @JoinColumn(name = "screeningRoomId")
    private ScreeningRoom1 screeningRoom1;

    @Column(name = "showDate")
    private LocalDate showDate;

    @Column(name = "startTime")
    private LocalTime startTime;

    @Column(name = "endTime")
    private LocalTime endTime;

    @Column(name = "ticketPrice")
    private BigDecimal ticketPrice;

    public Showtime1() {
    }

    public Showtime1(Movie1 movie1, ScreeningRoom1 screeningRoom1, LocalDate showDate,
                     LocalTime startTime, LocalTime endTime, BigDecimal ticketPrice) {
        this.movie1 = movie1;
        this.screeningRoom1 = screeningRoom1;
        this.showDate = showDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.ticketPrice = ticketPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie1 getMovie1() {
        return movie1;
    }

    public void setMovie1(Movie1 movie1) {
        this.movie1 = movie1;
    }

    public ScreeningRoom1 getScreeningRoom1() {
        return screeningRoom1;
    }

    public void setScreeningRoom1(ScreeningRoom1 screeningRoom1) {
        this.screeningRoom1 = screeningRoom1;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
