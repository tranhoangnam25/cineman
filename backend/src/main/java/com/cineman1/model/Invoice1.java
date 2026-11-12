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

    @Column(name = "issuedAt")
    private LocalDateTime issuedAt;

    @Column(name = "totalAmount")
    private BigDecimal totalAmount;

    @Column(name = "paymentMethod", length = 20)
    private String paymentMethod;

    public Invoice1() {
    }

    public Invoice1(Customer1 customer1, Employee1 employee1, LocalDateTime issuedAt,
                    BigDecimal totalAmount, String paymentMethod) {
        this.customer1 = customer1;
        this.employee1 = employee1;
        this.issuedAt = issuedAt;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
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

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
