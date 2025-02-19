package org.example.sample1;

/**
 * Defines a Runnable class:
 *  A runnable must implement the Runnable Interface and thus the run() method.
 *  The code we write in the run() method is the code/task that will be executed
 *  in the thread that this runnable is assigned to.
 *
 * Here, the task is to print a greeting and current date/time
 * repeatedly a certain number of times. A time delay is used between each
 * print operation so that we can see the output happening.
 * (Otherwise it would appear to complete instantaneously).
 *
 */

import java.time.LocalDateTime;

public class GreetingRunnable implements Runnable
{
    private static final int REPETITIONS = 10;
    private static final int DELAY = 500;    // milliseconds (500 ms = half a second)

    private String greeting;    // store the greeting in the Runnable object

    /**
     Constructs the runnable object with the passed-in greeting (e.g. "Hello")
     @param greeting the greeting to display
     */
    public GreetingRunnable(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public void run()       // define the task that will run in a thread
    {
        try
        {
            for (int i = 1; i <= REPETITIONS; i++)
            {
                LocalDateTime currentTime = LocalDateTime.now();

                System.out.println("In thread:  \"" +
                        Thread.currentThread().getName() +
                        "\". " + currentTime + " " + greeting);

                Thread.sleep(DELAY);   // send current thread to sleep for a set time - milliseconds
                // Note that the delay is only put here so that we can see what is happening.
                // The delay is not used in production code (i.e. when finished learning)
            }
        }
        catch (InterruptedException ex) //needed to catch Exception for Thread.sleep()
        {
            System.out.println("Thread was interrupted: " + ex);
        }
    }
}

