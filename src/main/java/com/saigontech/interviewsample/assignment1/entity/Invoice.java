package com.saigontech.interviewsample.assignment1.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("INV")
public class Invoice extends Document {

    @Column(name = "PAY_DATE")
    protected LocalDate paymentDate;

    public Invoice(String referenceId, String authorName, LocalDate paymentDate) {
        super(referenceId, authorName);
        this.paymentDate = paymentDate;
    }

    @Override
    String getAuthorName() {
        return this.getAuthorName();
    }
}