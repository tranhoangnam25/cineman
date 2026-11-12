package com.cineman1.dto;

import java.math.BigDecimal;
import java.util.List;

public class MovieStatisticsResponse1 {

    private List<MovieRevenueStatistics1> movies;
    private long totalTickets;
    private BigDecimal totalRevenue;

    public MovieStatisticsResponse1() {
    }

    public MovieStatisticsResponse1(List<MovieRevenueStatistics1> movies, long totalTickets, BigDecimal totalRevenue) {
        this.movies = movies;
        this.totalTickets = totalTickets;
        this.totalRevenue = totalRevenue;
    }

    public List<MovieRevenueStatistics1> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieRevenueStatistics1> movies) {
        this.movies = movies;
    }

    public long getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(long totalTickets) {
        this.totalTickets = totalTickets;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
