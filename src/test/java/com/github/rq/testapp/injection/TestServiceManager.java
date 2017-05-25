package com.github.rq.testapp.injection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import javax.servlet.ServletContext;

import org.jukito.JukitoModule;
import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.rq.testapp.interfaces.rest.v1.PersonsResource;
import com.google.inject.Injector;

@RunWith(JukitoRunner.class)
public class TestServiceManager
{
   public static class TestInjectionModule extends JukitoModule
   {
      @Override
      protected void configureTest()
      {}

   }

   @Test
   public void testInjection() throws Exception
   {
      // Given
      ServiceManager serviceManager = ServiceManager.getInstance();
      ServletContext servletContext = mock(ServletContext.class);

      serviceManager.registerCommonModules(servletContext);
      serviceManager.registerAppModules();

      // Override Ojdbc
      serviceManager.startServices(servletContext);

      // When I retrieve the injector
      Injector injector = ServiceManager.getInjector();

      // Then the injector is not null
      assertThat(injector).isNotNull();

      // And I can instantiate the Hello Resource
      PersonsResource personResource = injector.getInstance(PersonsResource.class);
      assertThat(personResource).isNotNull();
   }
}
