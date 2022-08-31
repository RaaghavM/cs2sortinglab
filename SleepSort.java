
public class SleepSort
{
    public static void sort(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            Thread t = new SleepThread(a[i]);
            t.start();
        }
    }
}
