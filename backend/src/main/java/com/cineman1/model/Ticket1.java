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

@Entity
@Table(name = "tblTicket1")
public class Ticket1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "showtimeId")
    private Showtime1 showtime1;

    @ManyToOne
    @JoinColumn(name = "invoiceId")
    private Invoice1 invoice1;

    @Column(name = "soGhe", length = 10)
    private String soGhe;

    @Column(name = "giaVe")
    private BigDecimal giaVe;

    @Column(name = "trangThai", length = 20)
    private String trangThai;

    public Ticket1() {
    }

    public Ticket1(Showtime1 showtime1, Invoice1 invoice1, String soGhe, BigDecimal giaVe, String trangThai) {
        this.showtime1 = showtime1;
        this.invoice1 = invoice1;
        this.soGhe = soGhe;
        this.giaVe = giaVe;
        this.trangThai = trangThai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Showtime1 getShowtime1() {
        return showtime1;
    }

    public void setShowtime1(Showtime1 showtime1) {
        this.showtime1 = showtime1;
    }

    public Invoice1 getInvoice1() {
        return invoice1;
    }

    public void setInvoice1(Invoice1 invoice1) {
        this.invoice1 = invoice1;
    }

    public String getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(String soGhe) {
        this.soGhe = soGhe;
    }

    public BigDecimal getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(BigDecimal giaVe) {
        this.giaVe = giaVe;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
