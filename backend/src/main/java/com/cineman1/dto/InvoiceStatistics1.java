package com.cineman1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InvoiceStatistics1 {

    private Long invoiceId;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime ngayLap;

    private String tenKhachHang;
    private long soVe;
    private BigDecimal tongTien;

    public InvoiceStatistics1() {
    }

    public InvoiceStatistics1(Long invoiceId, LocalDateTime ngayLap, String tenKhachHang, long soVe, BigDecimal tongTien) {
        this.invoiceId = invoiceId;
        this.ngayLap = ngayLap;
        this.tenKhachHang = tenKhachHang;
        this.soVe = soVe;
        this.tongTien = tongTien;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public LocalDateTime getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDateTime ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public long getSoVe() {
        return soVe;
    }

    public void setSoVe(long soVe) {
        this.soVe = soVe;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }
}
