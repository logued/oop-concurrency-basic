package dkit.sd2.oop.sample1;

/**
 * A Runnable class, with a run() method that contains a task
 * (i.e. code) to be executed by a thread.
 * The task is to print a greeting and the current date/time
 * repeatedly a certain number of times.
 *
 */

import java.time.LocalDateTime;

public class RunnableTask implements Runnable
{
    private static final int REPETITIONS = 10;
    private static final int DELAY = 500;    // milliseconds

    private String greeting;

    /**
     Constructs the runnable object with a set greeting (e.g. Hello)
     @param greeting the greeting to display
     */
    public RunnableTask(String greeting)
    {
        this.greeting = greeting;
    }

    @Override
    public void run()       // define the task that will run in a thread
    {
        try
        {
            for (int i = 1; i <= REPETITIONS; i++)
            {
                LocalDateTime now = LocalDateTime.now();

                System.out.println("In thread: \"" +
                        Thread.currentThread().getName() +
                        "\". " + now + " " + greeting);

                Thread.sleep(DELAY);     // send current thread to sleep for a set time - milliseconds
            }
        }
        catch (InterruptedException exception) //needed to catch Exception for Thread.sleep()
        {
            // do nothing
        }
    }
}

