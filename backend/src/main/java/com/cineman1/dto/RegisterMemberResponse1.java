package com.cineman1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class RegisterMemberResponse1 {

    private Long customerId;
    private String hoTen;
    private LocalDate ngaySinh;
    private String gioiTinh;
    private String soDienThoai;
    private String email;
    private String diaChi;

    private Long memberId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayDangKi;
    private String hangMember1;
    private int diemTichLuy;

    private String maThe;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayCap;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayHetHan;
    private String trangThaiThe;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public LocalDate getNgayDangKi() {
        return ngayDangKi;
    }

    public void setNgayDangKi(LocalDate ngayDangKi) {
        this.ngayDangKi = ngayDangKi;
    }

    public String getHangMember1() {
        return hangMember1;
    }

    public void setHangMember1(String hangMember1) {
        this.hangMember1 = hangMember1;
    }

    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(int diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public String getMaThe() {
        return maThe;
    }

    public void setMaThe(String maThe) {
        this.maThe = maThe;
    }

    public LocalDate getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(LocalDate ngayCap) {
        this.ngayCap = ngayCap;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public String getTrangThaiThe() {
        return trangThaiThe;
    }

    public void setTrangThaiThe(String trangThaiThe) {
        this.trangThaiThe = trangThaiThe;
    }
}
