package com.saigontech.interviewsample.service;

import com.saigontech.interviewsample.entity.Person;
import com.saigontech.interviewsample.entity.Pet;
import com.saigontech.interviewsample.exception.PersonNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

    @PersistenceContext
    private final EntityManager entityManager;

    public PersonService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//    @Transactional
//    public void addPerson(Person person) {
//        entityManager.persist(person);
//        entityManager.flush();
//    }

    @Transactional
    public void addPet(Long personId, String petName) {
        Person person = entityManager.find(Person.class, personId);

        if (person == null) {
            throw new PersonNotFoundException("Person with id " + personId + " not found.");
        }

        Pet pet = new Pet();
        pet.setName(petName);
        person.addPet(pet);

        entityManager.persist(person);
    }
}
