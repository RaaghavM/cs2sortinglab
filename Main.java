import java.util.*;

public class Main
{
    //returns an array with given length of random integers from 0 to (max - 1)
    public static Comparable[] randomIntegers(int length, int max)
    {
        Comparable[] a = new Comparable[length];
        for (int i = 0; i < a.length; i++)
            a[i] = (int)(Math.random() * max);
        return a;
    }

    //returns an array with given length of random locations with coordinates from 0 to (max - 1)
    public static Comparable[] randomLocations(int length, int max)
    {
        Comparable[] a = new Comparable[length];
        for (int i = 0; i < a.length; i++)
            a[i] = new Location((int)(Math.random() * max), (int)(Math.random() * max));
        return a;
    }

    //returns array as a string
    public static <E> String toString(E[] a)
    {
        return Arrays.toString(a);
    }
}
