package com.saigontech.interviewsample.entity;

import jakarta.persistence.*;

@Entity
@Table(name="pet")
public class Pet {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Person owner;

    public String getOwnerName() {
        if (owner != null) {
            return owner.getFirstName();
        } else {
            return null;
        }
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
