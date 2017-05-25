package com.github.ronanquillevere.airetest1.domain;

import java.util.List;

import javax.annotation.Nullable;
import javax.xml.bind.annotation.XmlRootElement;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;

@XmlRootElement
public class PagedResult<T>
{
   private long total;
   private int count;
   private int offset;
   @Nullable
   private List<T> results;

   /**
    * Used by ObjectMapper
    */
   @VisibleForTesting
   public PagedResult()
   {
      this(0, 0, 0, Lists.<T> newArrayList());
   }

   public PagedResult(long total, int count, int offset)
   {
      this(total, count, offset, Lists.<T> newArrayList());
   }

   public PagedResult(long total, int count, int offset, List<T> results)
   {
      this.total = total;
      this.count = count;
      this.offset = offset;
      this.results = results;
   }

   public long getTotal()
   {
      return total;
   }

   public int getCount()
   {
      return count;
   }

   public int getOffset()
   {
      return offset;
   }

   public List<T> getResults()
   {
      return results;
   }

   public void addResult(T result)
   {
      this.results.add(result);
   }

   public void addResults(List<T> results)
   {
      this.results.addAll(results);
   }

   // Setters for Enunciate...
   public void setTotal(long total)
   {
      this.total = total;
   }

   public void setCount(int count)
   {
      this.count = count;
   }

   public void setOffset(int offset)
   {
      this.offset = offset;
   }

   public void setResults(List<T> results)
   {
      this.results = results;
   }
}
