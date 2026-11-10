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

    @Column(name = "ngayChieu")
    private LocalDate ngayChieu;

    @Column(name = "gioBatDau")
    private LocalTime gioBatDau;

    @Column(name = "gioKetThuc")
    private LocalTime gioKetThuc;

    @Column(name = "giaVe")
    private BigDecimal giaVe;

    public Showtime1() {
    }

    public Showtime1(Movie1 movie1, ScreeningRoom1 screeningRoom1, LocalDate ngayChieu,
                     LocalTime gioBatDau, LocalTime gioKetThuc, BigDecimal giaVe) {
        this.movie1 = movie1;
        this.screeningRoom1 = screeningRoom1;
        this.ngayChieu = ngayChieu;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
        this.giaVe = giaVe;
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

    public LocalTime getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(LocalTime gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public BigDecimal getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(BigDecimal giaVe) {
        this.giaVe = giaVe;
    }
}
