package com.github.ronanquillevere.airetest1.infrastructure;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.ronanquillevere.airetest1.domain.Person;
import com.github.ronanquillevere.airetest1.domain.PersonRepository;

public class PersonRepositoryImpl implements PersonRepository
{
   private final Logger log = LoggerFactory.getLogger(getClass());

   @Inject
   public PersonRepositoryImpl()
   {}

   @Override
   public Person findPerson(String name)
   {
      return new Person(name);
   }

}
