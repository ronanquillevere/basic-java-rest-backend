package com.github.ronanquillevere.airetest1.interfaces.rest.v1;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class ResponseDebugFilter implements ContainerResponseFilter
{

   private static final Logger logger = LoggerFactory.getLogger(ResponseDebugFilter.class);

   @Override
   public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException
   {
      logger.info(requestContext.getMethod().toUpperCase() + " " + requestContext.getUriInfo().getRequestUri() + " " + responseContext.getStatus());
   }
}
