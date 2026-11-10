package com.cineman1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblScreeningRoom1")
public class ScreeningRoom1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenPhong", length = 50)
    private String tenPhong;

    @Column(name = "soGhe")
    private int soGhe;

    @Column(name = "loaiPhong", length = 20)
    private String loaiPhong;

    @Column(name = "trangThai", length = 20)
    private String trangThai;

    public ScreeningRoom1() {
    }

    public ScreeningRoom1(String tenPhong, int soGhe, String loaiPhong, String trangThai) {
        this.tenPhong = tenPhong;
        this.soGhe = soGhe;
        this.loaiPhong = loaiPhong;
        this.trangThai = trangThai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
