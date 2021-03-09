package dkit.sd2.oop.sample2;

/**
 * Runnable object that defines a task that can be executed in a thread.
 * The task must be coded in the run() method.
 *
 */

public class RunnableSumAction implements Runnable
{

    private int start, end, sum;

    public RunnableSumAction(int s, int e)
    {
        start = s;
        end = e;
        sum = 0;
    }

    @Override
    public void run()
    {
        for(int i = start; i <=end;i++)
        {
            sum += i;
        }
    }

    public int getSum()
    {
        return sum;
    }

}

