package com.github.ronanquillevere.airetest1.application;

import javax.inject.Inject;

import com.github.ronanquillevere.airetest1.domain.Person;
import com.github.ronanquillevere.airetest1.domain.PersonRepository;

public class Application
{
   private PersonRepository personRepository;

   @Inject
   public Application(PersonRepository personRepository)
   {
      this.personRepository = personRepository;
   }

   public Person findPerson(String name)
   {
      return personRepository.findPerson(name);
   }

}
