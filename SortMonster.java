// I'll sort you out!

import java.util.*;

public class SortMonster
{
  public static void main(String[] args)
  {
    test(new Location(1, 4).compareTo((Object)new Location(3, 2)) < 0);
    test(new Location(3, 2).compareTo((Object)new Location(1, 4)) > 0);
    test(new Location(1, 4).compareTo((Object)new Location(1, 2)) > 0);
    test(new Location(1, 4).compareTo((Object)new Location(1, 5)) < 0);
    test(new Location(1, 4).compareTo((Object)new Location(1, 4)) == 0);
    
    Comparable[] a = randomIntegers(1000, 100);
    Comparable[] copy = copy(a);
    BubbleSort.sort(a);
    testSorted(a, copy);
    for (int i = 0; i < a.length; i++)
      a[i] = a.length - i;
    copy = copy(a);
    BubbleSort.sort(a);
    testSorted(a, copy);
    a = randomLocations(1000, 10);
    copy = copy(a);
    BubbleSort.sort(a);
    testSorted(a, copy);
    
    int max = 10000;
    a = randomIntegers(max, max);
    long start = System.currentTimeMillis();
    BubbleSort.sort(a);
    System.out.println("Bubble Sort time for " + max + ":  " + (System.currentTimeMillis() - start));
    testSorted(a);
    
    int sortingAlgorithmsCompleted = 0;
    if (menu("Quicksort"))
    {
      a = randomIntegers(1000, 100);
      copy = copy(a);
      Quicksort.sort(a);
      testSorted(a, copy);
      a = randomLocations(1000, 10);
      copy = copy(a);
      Quicksort.sort(a);
      testSorted(a, copy);
      
      max = 1000000;
      a = randomIntegers(max, max);
      start = System.currentTimeMillis();
      Quicksort.sort(a);
      System.out.println("Quicksort time for " + max + ":  " + (System.currentTimeMillis() - start));
      testSorted(a);
      
      sortingAlgorithmsCompleted++;
    }
    
    if (menu("Radix Sort"))
    {
      a = randomIntegers(1000, 1000);
      copy = copy(a);
      RadixSort.sort(a);
      testSorted(a, copy);
      
      max = 1000000;
      a = randomIntegers(max, 10);
      start = System.currentTimeMillis();
      RadixSort.sort(a);
      System.out.println("Radix Sort time for " + max + ":  " + (System.currentTimeMillis() - start));
      testSorted(a);
      
      sortingAlgorithmsCompleted++;
    }
    
    if (sortingAlgorithmsCompleted == 0)
      return;
    
    System.out.println("I guess your code maybe sorta works ...");
  }
  
  public static void testSorted(Comparable[] a, Comparable[] copy)
  {
    testSorted(a);
    test(sameElements(a, copy));
  }
  
  public static void testSorted(Comparable[] a)
  {
    for (int i = 0; i < a.length - 1; i++)
      test(a[i].compareTo(a[i + 1]) <= 0);
  }
  
  public static boolean sameElements(Comparable[] a, Comparable[] b)
  {
    if (a.length != b.length)
      return false;
    boolean[] used = new boolean[a.length];
    for (int i = 0; i < a.length; i++)
    {
      boolean found = false;
      for (int j = 0; j < a.length; j++)
      {
        if (a[i].equals(b[j]) && !used[j])
        {
          used[j] = true;
          found = true;
          break;
        }
      }
      if (!found)
        return false;
    }
    return true;
  }
  
  public static Comparable[] copy(Comparable[] a)
  {
    Comparable[] copy = new Comparable[a.length];
    for (int i = 0; i < a.length; i++)
      copy[i] = a[i];
    return copy;
  }
  
  public static boolean menu(String sort)
  {
    System.out.println("a)  Test my " + sort);
    System.out.println("b)  I did not write " + sort);
    return new Scanner(System.in).nextLine().equals("a");
  }
  
  public static void test(boolean result)
  {
    if (!result)
      throw new RuntimeException("Sorta stinky!");
  }

  public static Comparable[] randomIntegers(int length, int max)
  {
    Comparable[] a = new Comparable[length];
    for (int i = 0; i < a.length; i++)
      a[i] = (int)(Math.random() * max);
    return a;
  }
  
  public static Comparable[] randomLocations(int length, int max)
  {
    Comparable[] a = new Comparable[length];
    for (int i = 0; i < a.length; i++)
      a[i] = new Location((int)(Math.random() * max), (int)(Math.random() * max));
    return a;
  }
}
