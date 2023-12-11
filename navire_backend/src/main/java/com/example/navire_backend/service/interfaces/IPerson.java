package com.example.navire_backend.service.interfaces;

import com.example.navire_backend.persistence.entities.Person;

import java.util.List;

public interface IPerson {
    Person savePerson(Person person);
    Person updatePerson(Person person);
    boolean deletePerson(Long id);
    List<Person> getListPerson();
    Person getPerson(Long id);
    Person findPersonByName(String name);
    int getQuantityOfPerson();
    Person getPersonByIdPerson(Long id);
}


