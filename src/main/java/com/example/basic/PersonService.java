package com.example.basic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Insert
     */
    public Person addPerson(Person person)
    {
        return personRepository.save(person);
    }

    /**
     * Delete
     */
    public void removePerson(Long personId)
    {
        personRepository.deleteById(personId);
    }

    /**
     * Update
     */
    public Person updatePerson(Long personId, String lastName)
    {
        int affectedRows = personRepository.updateLastName(personId, lastName);
        return personRepository.findById(personId).orElse(null);
    }

    /**
     * Research
     */
    public List<Person> searchPerson(String key)
    {
        return personRepository.searchPerson(key);
    }

    /**
     * Get by ID
     */
    public Person getPersonbyId(Long id)
    {
        return personRepository.findById(id).orElse(null);
    }

    /**
     * Pagination
     */
    public Page<Person> allPersonList(Pageable pageable)
    {
        return personRepository.findAll(pageable);
    }

    public List<Person> searchByLastName(String lastName)
    {
        return personRepository.findByLastNameContains(lastName);
    }
}
