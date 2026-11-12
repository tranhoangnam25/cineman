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

    @Column(name = "cardNumber", length = 20, unique = true)
    private String cardNumber;

    @Column(name = "issueDate")
    private LocalDate issueDate;

    @Column(name = "expiryDate")
    private LocalDate expiryDate;

    @Column(name = "status", length = 20)
    private String status;

    public MembershipCard1() {
    }

    public MembershipCard1(Member1 member1, String cardNumber, LocalDate issueDate, LocalDate expiryDate, String status) {
        this.member1 = member1;
        this.cardNumber = cardNumber;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.status = status;
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

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
