package com.github.ronanquillevere.airetest1.injection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;

import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

import ch.qos.logback.classic.LoggerContext;

public class ServletConfig extends GuiceServletContextListener
{
   @Override
   protected Injector getInjector()
   {
      return ServiceManager.getInjector();
   }

   @Override
   public void contextInitialized(ServletContextEvent servletContextEvent)
   {
      ServiceManager instance = ServiceManager.getInstance();

      ServletContext servletContext = servletContextEvent.getServletContext();
      instance.registerCommonModules(servletContext);
      instance.registerAppModules();

      instance.startServices(servletContext);

      super.contextInitialized(servletContextEvent);
   }

   @Override
   public void contextDestroyed(ServletContextEvent servletContextEvent)
   {
      try
      {
         ILoggerFactory loggerFactory = LoggerFactory.getILoggerFactory();
         if (loggerFactory instanceof LoggerContext)
         {
            LoggerContext context = (LoggerContext) loggerFactory;
            context.stop();
         }
         super.contextDestroyed(servletContextEvent);
      }
      finally
      {
         ServiceManager.getInstance().stopServices();
      }
   }

}
