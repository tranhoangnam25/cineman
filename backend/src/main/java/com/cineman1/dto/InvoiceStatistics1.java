package com.cineman1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InvoiceStatistics1 {

    private Long invoiceId;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime issuedAt;

    private String customerName;
    private long ticketCount;
    private BigDecimal totalAmount;

    public InvoiceStatistics1() {
    }

    public InvoiceStatistics1(Long invoiceId, LocalDateTime issuedAt, String customerName, long ticketCount, BigDecimal totalAmount) {
        this.invoiceId = invoiceId;
        this.issuedAt = issuedAt;
        this.customerName = customerName;
        this.ticketCount = ticketCount;
        this.totalAmount = totalAmount;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(long ticketCount) {
        this.ticketCount = ticketCount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
