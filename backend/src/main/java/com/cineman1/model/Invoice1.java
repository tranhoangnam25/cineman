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
import java.time.LocalDateTime;

@Entity
@Table(name = "tblInvoice1")
public class Invoice1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = true)
    private Customer1 customer1;

    @ManyToOne
    @JoinColumn(name = "employeeId", nullable = true)
    private Employee1 employee1;

    @Column(name = "ngayLap")
    private LocalDateTime ngayLap;

    @Column(name = "tongTien")
    private BigDecimal tongTien;

    @Column(name = "hinhThucThanhToan", length = 20)
    private String hinhThucThanhToan;

    public Invoice1() {
    }

    public Invoice1(Customer1 customer1, Employee1 employee1, LocalDateTime ngayLap,
                    BigDecimal tongTien, String hinhThucThanhToan) {
        this.customer1 = customer1;
        this.employee1 = employee1;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer1 getCustomer1() {
        return customer1;
    }

    public void setCustomer1(Customer1 customer1) {
        this.customer1 = customer1;
    }

    public Employee1 getEmployee1() {
        return employee1;
    }

    public void setEmployee1(Employee1 employee1) {
        this.employee1 = employee1;
    }

    public LocalDateTime getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDateTime ngayLap) {
        this.ngayLap = ngayLap;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }
}
