package com.cineman1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tblMember1")
public class Member1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "customerId", unique = true)
    private Customer1 customer1;

    @Column(name = "ngayDangKi")
    private LocalDate ngayDangKi;

    @Column(name = "hangMember1", length = 20)
    private String hangMember1;

    @Column(name = "diemTichLuy")
    private int diemTichLuy;

    public Member1() {
    }

    public Member1(Customer1 customer1, LocalDate ngayDangKi, String hangMember1, int diemTichLuy) {
        this.customer1 = customer1;
        this.ngayDangKi = ngayDangKi;
        this.hangMember1 = hangMember1;
        this.diemTichLuy = diemTichLuy;
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
}
