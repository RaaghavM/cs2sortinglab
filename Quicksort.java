public class Quicksort
{
    public static int partition(Comparable[] a, int first, int last)
    {
        Comparable partition = a[first];
        int i = first+1;
        int j = first+1;
        while (j <= last)
        {
            Comparable currentUnknown = a[j];
            if (currentUnknown.compareTo(partition) < 0)
            {
                Comparable temp = a[i];
                a[i] = currentUnknown;
                a[j] = temp;
                i++; j++;
            }
            else
                j++;
        }
        Comparable temp = a[i-1];
        a[i-1] = partition;
        a[first] = temp;        
        return i-1;
    }

    public static void sort(Comparable[] a, int first, int last)
    {
        if (first <= last)
        {
            int split = partition(a, first, last);
            sort(a, first, split-1);
            sort(a, split+1, last);
        }
    }

    public static void sort(Comparable[] a)
    {
        sort(a, 0, a.length-1);
    }
}