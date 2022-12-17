package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface PersonRepository extends JpaRepository<Person, Long> {

  /*  @Query("SELECT new com.example.demo.model.Person(p.id,p.name) FROM Person p WHERE p.name = :name AND p.surname = :surname AND p.uniqueCode =: uniqueCode")
    List<Person> getPersonByParameters(@Param("name") String name, @Param("surname") String surname, @Param("uniqueCode") String uniqueCode)
        */
    Person findAllByNameAndUniqueCode(String name, String uniqueCode);

    Person findAllByName(String name);

    List<Person> findAllByIsSelectedFalse();

}
