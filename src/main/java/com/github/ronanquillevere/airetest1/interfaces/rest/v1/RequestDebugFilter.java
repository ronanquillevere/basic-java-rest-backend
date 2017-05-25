package com.github.ronanquillevere.airetest1.interfaces.rest.v1;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
@PreMatching
public class RequestDebugFilter implements ContainerRequestFilter
{

   private static final Logger logger = LoggerFactory.getLogger(RequestDebugFilter.class);

   @Override
   public void filter(ContainerRequestContext requestContext) throws IOException
   {
      logger.info(requestContext.getMethod().toUpperCase() + " " + requestContext.getUriInfo().getRequestUri());
   }

}
