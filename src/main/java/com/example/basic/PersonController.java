package com.example.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/person/add")
    public Person addPerson(@RequestParam String firstName, @RequestParam String lastName)
    {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);

        return personService.addPerson(person);
    }

    @GetMapping("/person/delete/{id}")
    public String removePerson(@PathVariable Long id)
    {
         personService.removePerson(id);
         return "delete success";
    }

    @GetMapping("/person/update/{id}")
    public Person updateLastName(@PathVariable Long id, @RequestParam String lastName)
    {
        return personService.updatePerson(id, lastName);
    }

    @GetMapping("/person/search")
    public List<Person> searchPersonList(@RequestParam String key)
    {
//        return personService.searchPerson(key);

        return personService.searchByLastName(key);
    }

    @GetMapping("/person/list")
    public Page<Person> allPersonList(@RequestParam int page)
    {
        return personService.allPersonList(PageRequest.of(page, 2));
    }

    @GetMapping("/person/get/{id}")
    public Person getPerson(@PathVariable Long id)
    {
        return personService.getPersonbyId(id);
    }
}
