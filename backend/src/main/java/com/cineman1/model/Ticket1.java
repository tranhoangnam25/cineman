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

    @Column(name = "seatNumber", length = 10)
    private String seatNumber;

    @Column(name = "ticketPrice")
    private BigDecimal ticketPrice;

    @Column(name = "status", length = 20)
    private String status;

    public Ticket1() {
    }

    public Ticket1(Showtime1 showtime1, Invoice1 invoice1, String seatNumber, BigDecimal ticketPrice, String status) {
        this.showtime1 = showtime1;
        this.invoice1 = invoice1;
        this.seatNumber = seatNumber;
        this.ticketPrice = ticketPrice;
        this.status = status;
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

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
