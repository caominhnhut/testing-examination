package com.saigontech.interviewsample.assignment1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "GUESTS")
public class Guest extends Persons{

    @Column(name = "TEMPORARY_NAME")
    protected String tempName;

    public Guest(Long sessionId, String tempName) {
        super(sessionId);
        this.tempName = tempName;
    }

    String getTempName() {
        return tempName;
    }
}

