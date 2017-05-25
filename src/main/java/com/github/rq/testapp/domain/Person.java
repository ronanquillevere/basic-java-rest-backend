package com.github.rq.testapp.domain;

import java.util.UUID;

public class Person
{
   private final String name;
   private final String id;
   public Person(String name)
   {
      this.name = name;
      this.id = UUID.randomUUID().toString();
   }

   public String getName()
   {
      return name;
   }

   public String getId()
   {
      return id;
   }


}
