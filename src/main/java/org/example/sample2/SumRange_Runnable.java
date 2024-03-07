package org.example.sample2;
/**
 * This Runnable accepts a range (start to end) of integers
 * and sums up the values in the range.
 * This runnable task can be executed in a thread and runs independently of other code.
 * The task must be coded in the run() method.
 * The sum will be stored in the Runnable (sum field)
 */

public class SumRange_Runnable implements Runnable
{
    private int start, end;
    private int sum;        // the resulting sum

    public SumRange_Runnable(int start, int end) {
        this.start = start;
        this.end = end;
        sum = 0;
    }

    /**
     * Sum the numbers between start and end (inclusive)
     */
    @Override
    public void run() {
        for(int i = start; i <=end; i++)
        {
            sum += i;
        }
    }

    public int getSum()    {
        return sum;
    }
}

