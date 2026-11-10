package com.cineman1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tblMovie1")
public class Movie1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenMovie1", length = 200)
    private String tenMovie1;

    @Column(name = "theLoai", length = 100)
    private String theLoai;

    @Column(name = "daoDien", length = 100)
    private String daoDien;

    @Column(name = "dienVien", length = 300)
    private String dienVien;

    @Column(name = "thoiLuong")
    private int thoiLuong;

    @Column(name = "ngayKhoiChieu")
    private LocalDate ngayKhoiChieu;

    @Column(name = "moTa", length = 1000)
    private String moTa;

    @Column(name = "trangThai", length = 20)
    private String trangThai;

    public Movie1() {
    }

    public Movie1(String tenMovie1, String theLoai, String daoDien, String dienVien, int thoiLuong,
                  LocalDate ngayKhoiChieu, String moTa, String trangThai) {
        this.tenMovie1 = tenMovie1;
        this.theLoai = theLoai;
        this.daoDien = daoDien;
        this.dienVien = dienVien;
        this.thoiLuong = thoiLuong;
        this.ngayKhoiChieu = ngayKhoiChieu;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenMovie1() {
        return tenMovie1;
    }

    public void setTenMovie1(String tenMovie1) {
        this.tenMovie1 = tenMovie1;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getDaoDien() {
        return daoDien;
    }

    public void setDaoDien(String daoDien) {
        this.daoDien = daoDien;
    }

    public String getDienVien() {
        return dienVien;
    }

    public void setDienVien(String dienVien) {
        this.dienVien = dienVien;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public LocalDate getNgayKhoiChieu() {
        return ngayKhoiChieu;
    }

    public void setNgayKhoiChieu(LocalDate ngayKhoiChieu) {
        this.ngayKhoiChieu = ngayKhoiChieu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
