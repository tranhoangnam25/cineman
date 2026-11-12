package com.cineman1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class ShowtimeStatistics1 {

    private Long showtimeId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate showDate;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;

    private String roomName;
    private long ticketsSold;
    private BigDecimal revenue;

    public ShowtimeStatistics1() {
    }

    public ShowtimeStatistics1(Long showtimeId, LocalDate showDate, LocalTime startTime,
                               String roomName, long ticketsSold, BigDecimal revenue) {
        this.showtimeId = showtimeId;
        this.showDate = showDate;
        this.startTime = startTime;
        this.roomName = roomName;
        this.ticketsSold = ticketsSold;
        this.revenue = revenue;
    }

    public Long getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(Long showtimeId) {
        this.showtimeId = showtimeId;
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

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public long getTicketsSold() {
        return ticketsSold;
    }

    public void setTicketsSold(long ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }
}
