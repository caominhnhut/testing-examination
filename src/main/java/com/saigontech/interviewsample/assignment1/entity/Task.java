package com.saigontech.interviewsample.assignment1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Task {

    @Id
    @GeneratedValue
    @Column(name = "TASK_ID")
    protected Long id;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "AUTHOR")
    protected String author;

    public Task(String name, String author) {
        this.name = name;
        this.author = author;
    }

    String getName() {
        return name;
    }
}