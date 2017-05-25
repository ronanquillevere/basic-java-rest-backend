package com.github.rq.testapp.application;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Test;

import com.github.rq.testapp.domain.PersonRepository;

public class TestApplication
{
   @Test
   public void testgetPerson()
   {
      // Given
      PersonRepository repo = mock(PersonRepository.class);

      Application app = new Application(repo);
      String id = "id";

      // When
      app.findPersonById(id);

      // Then
      verify(repo, times(1)).findPersonById(id);

      verifyNoMoreInteractions(repo);
   }
}
