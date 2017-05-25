package com.github.rq.testapp.injection;

import com.github.rq.testapp.application.Application;
import com.github.rq.testapp.domain.PersonRepository;
import com.github.rq.testapp.infrastructure.PersonRepositoryImpl;
import com.github.rq.testapp.interfaces.rest.v1.PersonsResource;
import com.google.inject.AbstractModule;

public class CommonInjectionModule extends AbstractModule
{
   @Override
   protected void configure()
   {
      bind(Application.class);
      bind(PersonsResource.class);
      bind(PersonRepository.class).to(PersonRepositoryImpl.class);
   }

}
