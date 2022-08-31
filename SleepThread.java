
public class SleepThread extends Thread
{
    private int num;
    
    public SleepThread(int num)
    {
        super();
        this.num = num;
    }

    
    public void run()
    {
        try { Thread.sleep(num * 1000); } catch(Exception e) { }
        System.out.println(num);
    }
}
