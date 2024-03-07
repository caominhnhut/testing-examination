package com.saigontech.interviewsample.assignment1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "EPICS")
public class Epic extends Task {

    @Column(name = "PROJECT_ID")
    protected Long projectId;

    @Column(name = "PRODUCT_OWNER_NAME")
    protected String productOwner;

    public Epic(String name, String author, Long projectId, String productOwner) {
        super(name, author);
        this.projectId = projectId;
        this.productOwner = productOwner;
    }

    String getName() {
        return this.getName();
    }
}