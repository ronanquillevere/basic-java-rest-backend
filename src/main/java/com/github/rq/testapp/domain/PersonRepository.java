package com.github.rq.testapp.domain;

import java.util.List;

public interface PersonRepository
{
   Person findPersonById(String id);

   List<Person> findPersonsByName(String name);

   List<Person> getAll();
}
