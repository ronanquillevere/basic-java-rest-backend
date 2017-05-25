package com.github.rq.testapp.injection;

import javax.inject.Inject;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Injector;

public class CurrentResourceConfig extends ResourceConfig
{
   private static Logger logger = LoggerFactory.getLogger(CurrentResourceConfig.class);

   @Inject
   public CurrentResourceConfig(ServiceLocator serviceLocator)
   {
      logger.info("Registering injectables...");

      registerProviders();

      createBiDirectionalGuiceBridge(serviceLocator);
      logger.info("Guice/HK2 Bridge created");
   }

   private void registerProviders()
   {
      register(JacksonFeature.class);
   }

   public Injector createBiDirectionalGuiceBridge(ServiceLocator serviceLocator)
   {
      Injector injector = ServiceManager.getInjector();
      GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
      GuiceIntoHK2Bridge g2h = serviceLocator.getService(GuiceIntoHK2Bridge.class);
      g2h.bridgeGuiceInjector(injector);

      return injector;
   }
}
