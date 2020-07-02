package com.example.basic;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    List<Person> findByLastNameContains(String lastname);

    @Query("SELECT * FROM person WHERE first_name LIKE :key OR last_name LIKE :key")
    List<Person> searchPerson(String key);

    @Modifying
    @Query("UPDATE person set last_name=:lastName WHERE ID=:id")
    int updateLastName(Long id, String lastName);
}
