package com.saigontech.interviewsample.assignment1.service;

import org.springframework.stereotype.Repository;

import com.saigontech.interviewsample.assignment1.entity.AppUser;
import com.saigontech.interviewsample.assignment1.entity.Persons;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class Assignment1Service{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void persitAppUser(){
        AppUser appUser = new AppUser(1L, "app1", "fname1", "lastname1");
        entityManager.persist(appUser);
    }

    @Transactional
    public void persitPerson(){
        Persons p = new Persons(1L);
        entityManager.persist(p);
    }
}
