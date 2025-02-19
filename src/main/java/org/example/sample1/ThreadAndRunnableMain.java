package org.example.sample1;            // Feb 2025

/** Concurrency is where two or more tasks can be executed in 'parallel'. i.e. concurrently.
 * A number of tasks can be executed independently and concurrently by running them
 * in separate Threads.
 * This sample demonstrates how to create a Runnable object and execute it on a Thread.
 * A Runnable is an object that implements the "Runnable" interface,
 * meaning that it must define a run() method containing code to be executed in a Thread.
 * A Thread is a 'separate path of execution' that can execute a Runnable task
 * independently of the main thread of execution.
 * The main thread is called the User-Interface Thread (or UI-Thread) - all programs
 * have a default main UI-Thread (where the code in main() runs)
 *
 * If two threads run Concurrently, it means that one runs fora short time, then the other runs,
 * then back to the first one, and so on.  Their execution is Interleaved (or switched over and back)
 *
 */

public class ThreadAndRunnableMain
{
    public static void main(String[] args)
    {
        System.out.println("The code in main() is running in the main thread (also called the UI Thread)");

        // create a Runnable object which contains the code to be run on a thread.
        GreetingRunnable runnable1 = new GreetingRunnable("Hello");

        // create a new Thread and pass the Runnable into its constructor.
        // The Runnable will execute in that Thread.
        Thread thread1 = new Thread(runnable1, "Thread-1");

        System.out.println("In thread: \"" + Thread.currentThread().getName()
                + "\". Requesting to start thread 'Thread-1' ");

        /// request to start the thread that contains the runnable.
        /// The Thread Manager system will select/start the Thread-1 and will assign
        /// the runnable to it.  The runnable 'runs' on that thread.
        thread1.start();

        /// The execution of this function ( main() ) continues, as it is running on
        /// the "main thread" and is independent of the thread "Thread-1".  T
        /// The runnable runs on the new thread - thread1 - and executes
        /// concurrently with this thread.
        //
        System.out.println("In thread: \"" +
                Thread.currentThread().getName() +
                "\". Thread Thread-1 has been requested to start.");

        System.out.println("Goodbye from main thread !");
        System.out.println("You should see output below from the Runnable as it loops 10 times.");
        System.out.println("Note also the half second delay between each time value due to the specified sleep() delay.");

        //TODO Exercises (in class)
        // Q.1 Write code in main() to instantiate a second GreetingRunnable object named 'runnable2'
        // constructed with the message "Dobrý den!", and execute it on a new thread called 'Thread-2'.
        // (Tip: copy and paste the code from above, and modify accordingly.)
        //
        // Study the output, note the interleaving (switching between threads 1 and 2) of the output,
        // which demonstrates concurrent execution.
        // Is there a pattern to the interleaving?
        //
        //TODO
        // Q.2 Can the Runnable task - runnable1 - be executed concurrently in a third new thread - thread3?
        // Try it, and study the output.
        //
    }
}

