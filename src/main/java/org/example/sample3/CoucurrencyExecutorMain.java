package org.example.sample3;

/**
 * Executing Runnable tasks in threads using an Executor.
 * An Executor is a thread manager that creates and manages threads
 * and allocates your runnables to those threads automatically.
 *
 * This is the preferred way of using threads in Java
 * unless some complex threading operations are required.
 */


import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CoucurrencyExecutorMain
{

    public static void main(String[] args) {
        System.out.println("Using Executor to run tasks in threads");

        ArrayList<GreetingsRunnable> listOfRunnables = new ArrayList<>();

        listOfRunnables.add( new GreetingsRunnable("Hello") );
        listOfRunnables.add( new GreetingsRunnable("Bonjour") );
        listOfRunnables.add( new GreetingsRunnable("Hola") );

        final int total_threads = 3;    // number of threads in the thread pool

        ExecutorService executor = Executors.newFixedThreadPool(total_threads);
        for(int i = 0; i < total_threads; i++){
            executor.execute(listOfRunnables.get(i));
        }


        /**
         * Uses the newCachedThreadPool() factory method of the Executors class
         * to yield an executor optimized for programs with many tasks that are
         * short-lived or spend most of their time waiting. Each task is
         * executed on an idle thread if possible, but a new thread is allocated
         * if all threads are busy. Threads that are idle for an extended time
         * are terminated.
         */

        // QUery: is two threads are allocated, then th ethird task should eventually run, but does not appear to do so.???

    }
}

