import java.lang.Math;

public class BucketSort
{
    public static int getDigit(int n, int place)
    {
        return (n % (int)(Math.pow(10, place+1)))/(int)(Math.pow(10,place));
    }

    public static void sort(Comparable[] a, int place)
    {
        ListNode<Integer>[] buckets = (ListNode<Integer>[])new ListNode[10];
        for (int i = 0; i < a.length; i++)
        {
            int digit = getDigit((Integer)(a[i]), place);
            ListNode<Integer> cnode = buckets[digit]; 
            if (cnode == null)
                buckets[digit] = new ListNode<Integer>((Integer)(a[i]), null);
            else
                buckets[digit] = new ListNode<Integer>((Integer)(a[i]), buckets[digit]);
        }
        int count = a.length-1;
        for (int i = buckets.length-1; i >= 0; i--)
        {
            while (buckets[i] != null)
            {
                a[count] = buckets[i].getValue();
                count--;
                buckets[i] = buckets[i].getNext();
            }
        }
    }
}