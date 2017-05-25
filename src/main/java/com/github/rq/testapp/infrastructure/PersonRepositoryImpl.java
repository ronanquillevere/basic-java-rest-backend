package com.github.rq.testapp.infrastructure;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.github.rq.testapp.domain.Person;
import com.github.rq.testapp.domain.PersonRepository;
import com.google.common.collect.Lists;

public class PersonRepositoryImpl implements PersonRepository
{
   //private final Logger log = LoggerFactory.getLogger(getClass());
   private final List<Person> repo = Lists.newArrayList();

   @Inject
   public PersonRepositoryImpl()
   {
      repo.add(new Person("ronan"));
      repo.add(new Person("kim"));
      repo.add(new Person("xavier"));
      repo.add(new Person("Ronan"));
   }

   @Override
   public Person findPersonById(String id)
   {
      //TODO @rqu not working fix ASAP
      List<Person> list = repo.stream().filter(p -> p.getId().equals(id)).collect(Collectors.toList());
      if (list.size() == 1)
         return list.get(0);
      return null;
   }

   @Override
   public List<Person> findPersonsByName(String name)
   {
      return repo.stream().filter(p -> p.getName().toLowerCase().equals(name.toLowerCase())).collect(Collectors.toList());
   }

   @Override
   public List<Person> getAll()
   {
      return repo;
   }

}
