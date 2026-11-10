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
@Table(name = "tblMembershipCard1")
public class MembershipCard1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "memberId", unique = true)
    private Member1 member1;

    @Column(name = "maThe", length = 20, unique = true)
    private String maThe;

    @Column(name = "ngayCap")
    private LocalDate ngayCap;

    @Column(name = "ngayHetHan")
    private LocalDate ngayHetHan;

    @Column(name = "trangThai", length = 20)
    private String trangThai;

    public MembershipCard1() {
    }

    public MembershipCard1(Member1 member1, String maThe, LocalDate ngayCap, LocalDate ngayHetHan, String trangThai) {
        this.member1 = member1;
        this.maThe = maThe;
        this.ngayCap = ngayCap;
        this.ngayHetHan = ngayHetHan;
        this.trangThai = trangThai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member1 getMember1() {
        return member1;
    }

    public void setMember1(Member1 member1) {
        this.member1 = member1;
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
