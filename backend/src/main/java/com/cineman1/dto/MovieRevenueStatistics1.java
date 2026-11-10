package com.cineman1.dto;

import java.math.BigDecimal;

public class MovieRevenueStatistics1 {

    private Long movieId;
    private String tenMovie1;
    private long soVeDaBan;
    private BigDecimal doanhThu;

    public MovieRevenueStatistics1() {
    }

    public MovieRevenueStatistics1(Long movieId, String tenMovie1, long soVeDaBan, BigDecimal doanhThu) {
        this.movieId = movieId;
        this.tenMovie1 = tenMovie1;
        this.soVeDaBan = soVeDaBan;
        this.doanhThu = doanhThu;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTenMovie1() {
        return tenMovie1;
    }

    public void setTenMovie1(String tenMovie1) {
        this.tenMovie1 = tenMovie1;
    }

    public long getSoVeDaBan() {
        return soVeDaBan;
    }

    public void setSoVeDaBan(long soVeDaBan) {
        this.soVeDaBan = soVeDaBan;
    }

    public BigDecimal getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(BigDecimal doanhThu) {
        this.doanhThu = doanhThu;
    }
}
