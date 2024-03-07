package org.example.sample2;

import static java.lang.Thread.sleep;

/**
 * The task for this program is to add up the numbers from 1 to 20.
 * We will create a Runnable that will sum number between two values, and
 * then we can execute our task by running two concurrent tasks of separate threads.
 * One thread will run a Runnable that will sum the numbers from 1 to 10, and a second thread
 * will run a runnable to sum the numbers from 11 to 20. The sums will be retrieved from the
 * Runnable objects when they are finished, and will be added together for a result.
 * second thread
 *
 * 1 + 2 +   ...+ 10 =  55
 * 11 + 12  ....+ 20 = 155
 *
 * Grand total = 210
 * Modification: Put main() to sleep
 *
 */

public class SumAllFirstAttemptMain
{
    public static void main(String[] args)
    {
        // create two instances of Runnable tasks
        SumRange_Runnable r1 = new SumRange_Runnable(1, 10);
        SumRange_Runnable r2 = new SumRange_Runnable(11, 20);

        // pass the runnable tasks into two separate threads for execution
        Thread t1 = new Thread( r1 );
        Thread t2 = new Thread( r2 );

        System.out.println("Starting two threads. Sum 1-10 and sum 11-20, then calculate overall total.");
        t1.start();     // start the threads (which now have runnable tasks)
        t2.start();

        int total = r1.getSum() + r2.getSum();  // get the range sums and add them together

        System.out.println("Overall Total: (sum of the two sums) = " + total);

        System.out.println("The answer is WRONG! - Explain why.");

    }
}

//TODO - Solutions to our problem above?
// 1. Put main thread to sleep to allow t1 & t2 complete first.
//    But sleep for how long?
// 2. Force main thread to wait until t1 & t2 complete: use join()