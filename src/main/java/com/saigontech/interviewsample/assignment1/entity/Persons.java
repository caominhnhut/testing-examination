package com.saigontech.interviewsample.assignment1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "PERSONS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persons{

    @Id
    @GeneratedValue
    @Column(name = "PERSON_ID")
    protected Long id;

    @Column(name = "SESSION_ID")
    protected Long sessionId;

    public Persons(Long sessionId) {
        this.sessionId = sessionId;
    }
}
