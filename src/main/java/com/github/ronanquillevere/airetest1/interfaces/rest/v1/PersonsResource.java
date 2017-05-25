package com.github.ronanquillevere.airetest1.interfaces.rest.v1;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.ronanquillevere.airetest1.domain.Person;


@Path(RestConstant.PATH_VERSION_1 + RestConstant.PATH_PERSONS)
public class PersonsResource
{
//   private static final Logger logger = LoggerFactory.getLogger(PersonsResource.class);
//   private Application application;


   @Inject
   public PersonsResource()
//      Application application
   {
//      this.application = application;
   }


   @GET
   @Produces(MediaType.APPLICATION_JSON)
   //@Path(RestConstant.SEPARATOR + "{name}")
   public Person getPerson(/*@PathParam("name") String name*/)
   {
      //logger.info("Hello ;" + name);
      return new Person("ronan");
   }
}
