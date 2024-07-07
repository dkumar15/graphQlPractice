package com.graphQlPractice.repositories;

import com.graphQlPractice.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    Person findByEmail(String email);
}
