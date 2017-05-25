package com.github.ronanquillevere.airetest1.application;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Test;

import com.github.ronanquillevere.airetest1.domain.PersonRepository;

public class TestApplication
{
   @Test
   public void testgetPerson()
   {
      // Given
      PersonRepository repo = mock(PersonRepository.class);

      Application app = new Application(repo);

      String name = "toto";
      // When
      app.findPerson(name);

      // Then
      verify(repo, times(1)).findPerson(name);

      verifyNoMoreInteractions(repo);
   }
}
