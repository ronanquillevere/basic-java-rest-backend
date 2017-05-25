package com.github.ronanquillevere.airetest1.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class EqualsHelper
{
   private EqualsHelper()
   {
   }

   public static void testSame(Object o1, Object same, Object notSame)
   {
      assertThat(o1).isEqualTo(o1);
      assertThat(o1).isNotEqualTo(null);
      assertThat(o1).isNotEqualTo(new Object());
      assertThat(o1).isEqualTo(same);
      assertThat(o1.hashCode()).isEqualTo(same.hashCode());
      assertThat(o1).isNotEqualTo(notSame);
      assertThat(o1.hashCode()).isNotEqualTo(notSame.hashCode());
   }
}
