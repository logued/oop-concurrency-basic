package dkit.sd2.oop.sample2;

import static java.lang.Thread.sleep;

/**
 * Starting point for SumAction example
 * Program sum all the numbers [1,20]
 * Using 2 threads in addition to main thread - split task in 2 parts.
 *
 * 1 + 2 + ....+ 10
 * 11 + 12  ....+ 20
 *
 * Modification: Put main() to sleep
 *
 */

public class SumActionMainStart
{
    public static void main(String[] args)
    {
        // create two Runnable tasks
        RunnableSumAction r1 = new RunnableSumAction(1, 10);
        RunnableSumAction r2 = new RunnableSumAction(11, 20);

        // pass the runnable tasks into two separate threads for execution
        Thread t1 = new Thread( r1 );
        Thread t2 = new Thread( r2 );

        System.out.println("Starting two threads.");
        t1.start();     // start the threads (which now have runnable tasks)
        t2.start();


        int total = r1.getSum() + r2.getSum();

        System.out.println("Total: " + total);

    }
}

//TODO -
// 1. Put main thread to sleep to allow t1 & t2 complete first.
//    But sleep for how long?
// 2. Force main thread to wait until t1 & t2 complete: use join()