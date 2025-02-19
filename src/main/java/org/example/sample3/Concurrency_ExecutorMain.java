package org.example.sample3;                /// Feb 2025

 /// Executing Runnable tasks in threads using an Executor.
 /// An Executor is a thread manager that creates and manages threads
 /// and allocates your runnables to those threads automatically.
 /// This is the preferred way of using threads in Java
 /// unless some complex threading operations are required.
 import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Concurrency_ExecutorMain
{

    public static void main(String[] args) {
        System.out.println("Using Executor to run tasks in threads");

        ArrayList<GreetingsRunnable> listOfRunnables = new ArrayList<>();

        listOfRunnables.add( new GreetingsRunnable("Hello") );
        listOfRunnables.add( new GreetingsRunnable("Bonjour") );
        listOfRunnables.add( new GreetingsRunnable("Hola") );

        final int NUMBER_OF_THREADS_IN_POOL = 2;    // number of threads in the thread pool

        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS_IN_POOL);

        ///  pass each of the runnable tasks to the executor to be executed
        for (GreetingsRunnable runnable : listOfRunnables) {
            executor.execute( runnable );
        }
        /// if there are more tasks than threads available, the executor queues the
        /// runnables until threads become free.

        executor.shutdown();// request that the thread pool be shut down (not instantaneous)
        // At this point, no new runnables can be allocated to the executor queue and
        // all runnables assigned to the executor (those running in threads, and those in the queue)
        // will be completed.

        /// An alternative is to use the newCachedThreadPool() factory method
        /// of the Executors class to yield an executor optimized for programs
        /// with many tasks that are  short-lived or spend most of their time waiting.
        /// Each task is executed on an idle thread if possible, but a new thread is
        /// allocated if all threads are busy. Threads that are idle for an extended time
        /// are terminated.
        }
}

