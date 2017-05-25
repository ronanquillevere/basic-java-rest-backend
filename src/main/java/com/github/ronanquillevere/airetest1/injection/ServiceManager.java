package com.github.ronanquillevere.airetest1.injection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class ServiceManager
{

   private static final Logger logger = LoggerFactory.getLogger(ServiceManager.class);

   private final List<Class<? extends Service>> serviceClassNames = Lists.newArrayList();
   private final List<Service> repository = Lists.newArrayList();

   private static ServiceManager INSTANCE = new ServiceManager();

   private static Map<String, Module> MODULES = new HashMap<String, Module>();

   @Nullable
   private static Injector INJECTOR;

   private ServiceManager()
   {}

   public static ServiceManager getInstance()
   {
      return INSTANCE;
   }

   public static Injector getInjector()
   {
      return INJECTOR;
   }

   public void registerService(Class<? extends Service> serviceClass)
   {
      serviceClassNames.add(serviceClass);
      logger.info("Service has been registered;" + serviceClass.getSimpleName());
   }

   public void startServices(ServletContext srvCtx)
   {
      initInjector();
      instantiateAndStartServices();
   }

   private void instantiateAndStartServices()
   {
      for (Class<? extends Service> serviceClass : serviceClassNames)
      {
         Service service = INJECTOR.getInstance(serviceClass);
         repository.add(service);
         logger.info("Service injected and stored;" + serviceClass.getSimpleName());
         service.start();
      }
   }

   public void stopServices()
   {

      for (int i = repository.size() - 1; i >= 0; i--)
      {
         final Service service = repository.get(i);
         try
         {
            service.stop();
         }
         catch (Exception e)
         {
            logger.error("Service not stopped correctly;" + service.getName(), e);
         }
      }

      dispose();
   }

   private static void initInjector()
   {
      INJECTOR = Guice.createInjector(MODULES.values());
   }

   private static void resetInjector()
   {
      INJECTOR = null;
   }

   public void registerCommonModules(ServletContext srvCtx)
   {
   }

   public void registerAppModules()
   {
      registerModule(new CommonInjectionModule(), "CommonModule"); // for hk2 bridge, declare converters and facades
   }

   public void registerModule(Module module, String moduleName)
   {
      MODULES.put(moduleName, module);
      logger.info("Added injected module;" + moduleName);
   }

   public Module getModule(String moduleName)
   {
      return MODULES.get(moduleName);
   }

   private void dispose()
   {
      serviceClassNames.clear();
      //((SchedulerModule) getModule("SchedulerModule")).clean();
      resetInjector();
   }
}
