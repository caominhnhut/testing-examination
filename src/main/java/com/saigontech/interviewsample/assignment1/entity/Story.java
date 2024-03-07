package com.saigontech.interviewsample.assignment1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "STORIES")
public class Story extends Task {

    @Column(name = "SPRINT_ID")
    protected Long sprintId;

    public Story(String name, String author, Long sprintId) {
        super(name, author);
        this.sprintId = sprintId;
    }

    String getName() {
        return this.getName();
    }
}

