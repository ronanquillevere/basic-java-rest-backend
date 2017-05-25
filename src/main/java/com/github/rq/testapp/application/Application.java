package com.github.rq.testapp.application;

import java.util.List;

import javax.inject.Inject;

import com.github.rq.testapp.domain.Person;
import com.github.rq.testapp.domain.PersonRepository;

public class Application
{
   private PersonRepository personRepository;

   @Inject
   public Application(PersonRepository personRepository)
   {
      this.personRepository = personRepository;
   }

   public List<Person> findPersonsByName(String name)
   {
      return personRepository.findPersonsByName(name);
   }

   public Person findPersonById(String id)
   {
      return personRepository.findPersonById(id);
   }

   public List<Person> getAll()
   {
      return personRepository.getAll();
   }

}
