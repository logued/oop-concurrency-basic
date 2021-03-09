package dkit.sd2.oop.sample3;

/**
 * Executing Runnable tasks in threads using an Executor.
 *
 * This is the preferred way of using threads in Java
 * unless some complex threading operations are required.
 */


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CoucurrencyExecutorMain
{

    public static void main(String[] args)
    {
        System.out.println("Using Executor to run tasks in threads");

        GreetingRunnable r1 = new GreetingRunnable("Hello");
        GreetingRunnable r2 = new GreetingRunnable("Goodbye");

        Executor executor = Executors.newCachedThreadPool();

        executor.execute(r1);  // pass runnables to executor to be run on
        executor.execute(r2);  // individual/separate threads

        /**
         * Uses the newCachedThreadPool() factory method of the Executors class
         * to yield an executor optimized for programs with many tasks that are
         * short lived or spend most of their time waiting. Each task is
         * executed on an idle thread if possible, but a new thread is allocated
         * if all threads are busy. Threads that are idle for an extended time
         * are terminated.
         */
    }
}

