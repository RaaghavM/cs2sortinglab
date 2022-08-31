public class RadixSort
{
    public static void sort(Comparable[] a)
    {
        if (a.length > 0)
        {
            for (int i = 0; i < 10; i++)
            {
                BucketSort.sort(a, i);
            }
        }
    }
}
