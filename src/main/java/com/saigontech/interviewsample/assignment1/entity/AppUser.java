package com.saigontech.interviewsample.assignment1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class AppUser extends Persons{

    @Column(name = "LOGIN")
    protected String login;

    @Column(name = "USER_NAME")
    protected String firstName;

    @Column(name = "USER_SURNAME")
    protected String lastName;

    public AppUser(Long sessionId, String login, String firstName, String lastName) {
        super(sessionId);
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    String getLogin() {
        return login;
    }

}
