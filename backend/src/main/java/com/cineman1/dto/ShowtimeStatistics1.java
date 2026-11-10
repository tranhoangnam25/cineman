package com.cineman1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class ShowtimeStatistics1 {

    private Long showtimeId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayChieu;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime gioBatDau;

    private String tenPhong;
    private long soVeDaBan;
    private BigDecimal doanhThu;

    public ShowtimeStatistics1() {
    }

    public ShowtimeStatistics1(Long showtimeId, LocalDate ngayChieu, LocalTime gioBatDau,
                               String tenPhong, long soVeDaBan, BigDecimal doanhThu) {
        this.showtimeId = showtimeId;
        this.ngayChieu = ngayChieu;
        this.gioBatDau = gioBatDau;
        this.tenPhong = tenPhong;
        this.soVeDaBan = soVeDaBan;
        this.doanhThu = doanhThu;
    }

    public Long getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(Long showtimeId) {
        this.showtimeId = showtimeId;
    }

    public LocalDate getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(LocalDate ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public LocalTime getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(LocalTime gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
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
