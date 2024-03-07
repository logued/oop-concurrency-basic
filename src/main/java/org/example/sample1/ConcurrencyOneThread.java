package org.example.sample1;            // Mar 2024

import java.sql.SQLOutput;

/** Concurrency is where two or more tasks can be executed in 'parallel'. i.e. concurrently.
 * A number of tasks can be executed independently but concurrently by running them
 * in their own Threads.
 * Demonstrates how to create a Runnable object and execute it on a Thread.
 * A Runnable is an object that implements the Runnable interface,
 * meaning that it defines a run() method containing code to be executed in a Thread.
 * A Thread is a 'separate path of execution' that can execute a Runnable task
 * independently of the main thread of execution.
 * The main thread is also called the User-Interface Thread (or UI-Thread)
 *
 */

public class ConcurrencyOneThread
{
    public static void main(String[] args)
    {
        System.out.println("The code in main() is running in the main thread (also called the UI Thread)");

        // create a Runnable object which contains the code to be run on a thread.
        RunnableTask runnable1 = new RunnableTask("Hello");

        // create a new Thread and pass the Runnable into its constructor
        Thread thread1 = new Thread(runnable1);

        System.out.println("In thread: \"" + Thread.currentThread().getName()
                + "\". Requesting that a background thread t1 be started...");

        // request to start the thread that contains the runnable.
        // The Thread Manager system will select/start the thread and will assign
        // the runnable to it.  The runnable 'runs' on the thread.
        thread1.start();

        // The execution of this function ( main() ) continues, as it is running on
        // the "main thread" (also called the UI Thread).  The runnable runs on the
        // new thread - thread1 - and executes concurrently with this thread.
        //
        System.out.println("In thread: \"" +
                Thread.currentThread().getName() +
                "\". Thread t1 has been requested to start.");

        System.out.println("Goodbye from main thread !");
        System.out.println("You should see output below from the Runnable as it loops 10 times.");
        System.out.println("Note that the system has named the thread \"Thread-0\" ");
        System.out.println("Note also the half second delay between each time value due to the specified delay.");

        // TODO Exercises (in class)
        // Q.1 Write the code in main() to create a new RunnableTask object named 'runnable2'
        // constructed with the message "Dobrý den!", and execute it on a new thread called thread2.
        // (Tip: copy and paste the code from above, and modify accordingly.)
        //
        // Study the output, note the interleaving (switching between 1 and 2) of the output,
        // which demonstrates concurrent execution.
        // Is there a pattern to the interleaving?
        //
        // Q.2 Can the Runnable task - runnable1 - be executed concurrently in a third new thread - thread3?
        // Try it, and study the output.
        //
    }
}

