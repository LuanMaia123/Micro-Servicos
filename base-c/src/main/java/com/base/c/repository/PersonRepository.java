package com.base.c.repository;

import com.base.c.document.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person,String> {
    Person findById(String id);
}
