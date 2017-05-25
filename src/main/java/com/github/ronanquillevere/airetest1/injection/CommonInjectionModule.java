package com.github.ronanquillevere.airetest1.injection;

import com.github.ronanquillevere.airetest1.application.Application;
import com.github.ronanquillevere.airetest1.domain.PersonRepository;
import com.github.ronanquillevere.airetest1.infrastructure.PersonRepositoryImpl;
import com.github.ronanquillevere.airetest1.interfaces.rest.v1.PersonsResource;
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
