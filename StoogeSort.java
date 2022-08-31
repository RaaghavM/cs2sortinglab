
public class StoogeSort
{
    public static void sort(Comparable[] a)
    {
        sort(a, 0, a.length-1);
    }
    
    public static void sort(Comparable[] a, int start, int end)
    {
        int size = end-start+1;
        if (size == 2) //2 elements to sort
        {
            if (a[start].compareTo(a[end]) > 0)
            {
                Comparable temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }             
        }
        else
        {
            sort(a, start, end - size/3);
            sort(a, start + size/3, end);
            sort(a, start, end - size/3);
        }
    }
}
