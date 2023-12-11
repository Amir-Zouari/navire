package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.entities.Person;
import com.example.navire_backend.service.interfaces.IPerson;

import java.util.List;

public class PersonService implements IPerson {
    @Override
    public Person savePerson(Person person) {
        return null;
    }

    @Override
    public Person updatePerson(Person person) {
        return null;
    }

    @Override
    public boolean deletePerson(Long id) {
        return false;
    }

    @Override
    public List<Person> getListPerson() {
        return null;
    }

    @Override
    public Person getPerson(Long id) {
        return null;
    }

    @Override
    public Person findPersonByName(String name) {
        return null;
    }

    @Override
    public int getQuantityOfPerson() {
        return 0;
    }

    @Override
    public Person getPersonByIdPerson(Long id) {
        return null;
    }
}
