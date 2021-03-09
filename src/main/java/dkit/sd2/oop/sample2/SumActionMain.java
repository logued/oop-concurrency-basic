package dkit.sd2.oop.sample2;

/**
 * Using thread.join() to create dependencies between threads.
 * i.e. To block a thread until another thread completes its work.
 *
 * The initial code has the join() methods commented out, so
 * when run, the program gives an incorrect result.
 */

public class SumActionMain
{
    public static void main(String[] args)
    {
//        try {
        // create two Runnable tasks
        RunnableSumAction r1 = new RunnableSumAction(1, 10);
        RunnableSumAction r2 = new RunnableSumAction(11, 20);

        // pass the runnable tasks into two separate threads for execution
        Thread t1 = new Thread( r1 );
        Thread t2 = new Thread( r2 );

        System.out.println("Starting two threads.");
        t1.start();     // start the threads (which now have runnable tasks)
        t2.start();

//        t1.join(); // block (stop execution of) the current thread (i.e main)
                    //  until t1 completes.

                    // Creates a dependency on the thread t1, such that this thread (main),
                    // is blocked at this point until thread t1 completes.
                    // Once thread t1 completes its work, then the main thread continues.

        System.out.println("Thread t1 has completed.");

//        t2.join();  // block this current thread until t2 completes.

        System.out.println("Thread t2 has completed.");

        System.out.println("The main thread can proceed to use the results from t1 and t2");

        /** We must not execute the following line of code until the two worker
         threads t1 and t2 have completed their tasks because the total requires
         the results from the runnables in both threads r1 and r2 to be completed.
         Therefore, we must block the current 'main' thread of execution using the
         join() method  (as coded above).
         I.e. we insist on t1 and t2 completing before the main thread can proceed.
         *
         * Without the join(), we will get an incorrect result because the sum will
         * be retrieved from the runnable objects before they have had time
         * to complete their summing operation.
         */
        int total = r1.getSum() + r2.getSum();

        System.out.println("Total: " + total);

//        } catch (InterruptedException ex)   // needed for join()
//        {
//            //do nothing
//        }

    }
}

