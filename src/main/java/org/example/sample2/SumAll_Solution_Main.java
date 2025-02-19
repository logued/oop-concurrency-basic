package org.example.sample2;            // Feb 2025

/**
 * Using thread.join() to create dependencies between threads. i.e. to make one wait
 * until another one has finished.
 * Often, we need the results of the work done by one (or more) threads
 * to be available before we continue with other tasks/calculations.
 * Therefore, we need to be able to make a current thread wait for the completion
 * of another thread.  We do this by blocking the current thread until another
 * specified thread completed its work.
 * The threadX.join() method causes the current thread to stop and wait (blocked) until
 * the work in threadX is finished.  When finished, the current thread (here main() )
 * resumes and can use the results from threadX.
 *
 * The initial code has the join() methods commented out, so,
 * when run, the program gives an incorrect result.  We will then
 * uncomment the join() to see the effects.
 */

public class SumAll_Solution_Main
{
    public static void main(String[] args)
    {
//        try {


        // Consider if we want to sum up the numbers in the range 1 to 20.
        // We can break this down into two tasks, sum 1-10 and sum 11-20
        // and give each task to a separate thread. (to speed it up).

        // create two Runnable tasks, each summing up a different range of numbers
        SumRange_Runnable r1 = new SumRange_Runnable(1, 10);
        SumRange_Runnable r2 = new SumRange_Runnable(11, 20);

        // pass the runnable tasks into two separate threads for execution
        Thread t1 = new Thread( r1 );
        Thread t2 = new Thread( r2 );

        System.out.println("Starting two threads.");
        t1.start();     // start the threads (which now have runnable tasks)
        t2.start();

//        t1.join(); // block (stop execution of) the CURRENT thread (i.e. main)
                    //  until t1 completes.

                    // Creates a dependency on the thread t1, such that this thread (main),
                    // is blocked at this point until thread t1 completes.
                    // Once thread t1 completes its work, then the main thread is notified and continues.

        System.out.println("Thread t1 has completed.");

//        t2.join();  // block this current thread until t2 completes.

        System.out.println("Thread t2 has completed.");

        System.out.println("The main thread can proceed to use the results from t1 and t2");

        /** To calculate the total sum, we need to get the results from the
         * two runnables.  However, we must not retrieve/get the results from the
         * runnable objects before they have done their work, otherwise their
         * sum fields will contain the value zero.
         * So, threads t1 and t2 must be allowed to finish their work before we
         * continue to use their results here in the main thread.

         Therefore, we must block the current 'main' thread of execution using the
         join() method for each thread - t1.join(), and t2.join().  Note that the
         commands will cause the current (main) thread to block until threads t1 and t2
         have completed their work (respectively). (t1 and t2 are not blocked!, it is the main thread
         that is blocked until the other finish.)
         I.e. we insist on t1 and t2 completing before the main thread can proceed.

         Without the join(), we will get an incorrect result because the sum will
         be retrieved from the runnable objects before they have had time
         to complete their summing operation. So, the sum may be zero, or some
         intermediate value.
         */
        int total = r1.getSum() + r2.getSum();

        System.out.println("Total: " + total);

//        } catch (InterruptedException ex)   // needed for join()
//        {
//        System.out.println("InterruptedException: " + ex);
//        }

    }
}

