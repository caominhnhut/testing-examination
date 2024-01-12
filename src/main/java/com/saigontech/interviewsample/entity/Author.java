package com.saigontech.interviewsample.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Author{

    private String name;
    private String login;

    private Author(){

    }

    public Author(String name, String login){
        this.name = name;

        this.login = login;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }
}
