package org.example.sample3;

/**
 * A Runnable that repeatedly prints a greeting and the current date/time.
 *
 * A Runnable is an object with a method called run() that contains
 * the instructions/task that is to be executed by a thread.
 */

import java.util.Date;

public class GreetingsRunnable implements java.lang.Runnable
{
    private static final int REPETITIONS = 10;
    private static final int DELAY = 500;    // milliseconds

    private String greeting;

    /**
     Constructs the runnable object.
     @param aGreeting the greeting to display
     */
    public GreetingsRunnable(String aGreeting)
    {
        greeting = aGreeting;
    }

    @Override
    public void run()
    {
        try {
            for (int i = 1; i <= REPETITIONS; i++) {
                Date now = new Date();
                System.out.println("in thread: \"" +
                        Thread.currentThread().getName() +
                        "\"." + now + " " + greeting);
                Thread.sleep(DELAY);     // send current thread to sleep
            }
        }
        catch (InterruptedException exception)
        {
            System.out.println("Interrupted Exception: " + exception);
        }


    }
}

