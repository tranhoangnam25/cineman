package com.cineman1.dto;

import java.math.BigDecimal;

public class MovieRevenueStatistics1 {

    private Long movieId;
    private String movieName;
    private long ticketsSold;
    private BigDecimal revenue;

    public MovieRevenueStatistics1() {
    }

    public MovieRevenueStatistics1(Long movieId, String movieName, long ticketsSold, BigDecimal revenue) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.ticketsSold = ticketsSold;
        this.revenue = revenue;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
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
