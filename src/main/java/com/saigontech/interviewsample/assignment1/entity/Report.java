package com.saigontech.interviewsample.assignment1.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("REP")
public class Report extends Document {

    @Column(name = "BEGIN")
    protected LocalDate startDate;

    @Column(name = "FINISH")
    protected LocalDate endDate;

    public Report(String referenceId, String authorName, LocalDate startDate, LocalDate endDate) {
        super(referenceId, authorName);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    String getAuthorName() {
        return this.getAuthorName();
    }
}