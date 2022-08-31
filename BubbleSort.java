public class BubbleSort
{
    public static void sort(Comparable[] a)
    {
        for (int j = 0; j < a.length-1; j++)
        {
            for (int i = 0; i < a.length-1; i++)
            {
                if (a[i].compareTo(a[i+1]) > 0)
                {
                    Comparable temp = a[i+1];
                    a[i+1] = a[i];
                    a[i] = temp;
                }   
            }
        }
    }

    private static void bubblePass(Comparable[] a)
    {

    }
}