package com.github.rq.testapp.interfaces.rest.v1;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.github.rq.testapp.application.Application;
import com.github.rq.testapp.domain.Person;

@Path(RestConstant.PATH_VERSION_1 + RestConstant.PATH_PERSONS)
public class PersonsResource
{
   private final Application application;

   @Inject
   public PersonsResource(Application application)
   {
      this.application = application;
   }

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<Person> findPersons(@QueryParam("name") String name)
   {
      if (name != null)
         return this.application.findPersonsByName(name);
      return this.application.getAll();
   }

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   @Path(RestConstant.SEPARATOR + "{id}")
   public Person getPerson(@PathParam("id") String id)
   {
      return application.findPersonById(id);
   }
}
