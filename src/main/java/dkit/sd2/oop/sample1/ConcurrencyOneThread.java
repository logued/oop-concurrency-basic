package dkit.sd2.oop.sample1;

/** Demonstrates that, by default, programs run in the "main" thread.
 * (also called the User-Interface Thread)
 *
 * Demonstrates creation of a Runnable object that
 * encapsulates a task in a run() method.
 *
 * The Runnable object is created and passed to a thread, which executes
 * its run() method.
 *
 */

public class ConcurrencyOneThread
{
    public static void main(String[] args)
    {
        RunnableTask r1 = new RunnableTask("Hello");  // create a runnable task
        Thread t1 = new Thread(r1);  // create a thread and pass it a runnable task

        System.out.println("In thread: \"" + Thread.currentThread().getName()
                + "\". Requesting that a background thread t1 be started...");

        t1.start();  // request to start the thread ( Thread Manager decides when to start)

        System.out.println("In thread: \"" + Thread.currentThread().getName()
                + "\". Thread t1 has been requested to start.");



        // TODO

         /**
         * Q.1 Write the code to create a new RunnableTask r2 constructed with
         * the message "Goodbye", and execute it in a new thread t2
         *
         * (Tip: copy and paste the code from above, and modify accordingly.
         *
         * Study the output, note the interleaving of output, which demonstrates
         * concurrent execution
         *
         * Is there a pattern to the interleaving?
         *
         *
         * Q.2 Can r1 be executed concurrently in a new thread t3? Try it.
         *
         *
         */
    }
}

