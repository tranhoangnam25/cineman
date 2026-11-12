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

    @Column(name = "registrationDate")
    private LocalDate registrationDate;

    @Column(name = "membershipTier", length = 20)
    private String membershipTier;

    @Column(name = "loyaltyPoints")
    private int loyaltyPoints;

    public Member1() {
    }

    public Member1(Customer1 customer1, LocalDate registrationDate, String membershipTier, int loyaltyPoints) {
        this.customer1 = customer1;
        this.registrationDate = registrationDate;
        this.membershipTier = membershipTier;
        this.loyaltyPoints = loyaltyPoints;
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

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getMembershipTier() {
        return membershipTier;
    }

    public void setMembershipTier(String membershipTier) {
        this.membershipTier = membershipTier;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}
