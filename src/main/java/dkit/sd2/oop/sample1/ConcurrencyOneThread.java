package dkit.sd2.oop.sample1;

/** Demonstrates that, by default, programs run in the "main" thread.
 * (also called the User-Interface Thread)
 *
 * Demonstrates creation of a Runnable object.
 * A Runnable class is a class that implements the Runnable Interface, meaning
 * that the class must implement a run() method.
 * A Runnable object can be passed into a Thread to be executed, and the Thread
 * expects there to be a run() method in the runnable that it can call.
 */

public class ConcurrencyOneThread
{
    public static void main(String[] args)
    {
        RunnableTask runnable1 = new RunnableTask("Hello");  // create a Runnable object

        Thread thread1 = new Thread(runnable1);  // create a Thread and pass it a Runnable

        System.out.println("In thread: \"" + Thread.currentThread().getName()
                + "\". Requesting that a background thread t1 be started...");

        thread1.start();  // request to start the thread ( Thread Manager decides when to actually start)

        System.out.println("In thread: \"" + Thread.currentThread().getName()
                + "\". Thread t1 has been requested to start.");



        // TODO

         /**
         * Q.1 Write the code to create a new RunnableTask runnable2 constructed with
         * the message "Goodbye", and execute it in a new thread thread2
         *
         * (Tip: copy and paste the code from above, and modify accordingly.
         *
         * Study the output, note the interleaving of output, which demonstrates
         * concurrent execution
         *
         * Is there a pattern to the interleaving?
         *
         *
         * Q.2 Can runnable1 be executed concurrently in a new thread thread3? Try it.
         *
         *
         */
    }
}

