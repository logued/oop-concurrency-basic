package org.example.sample4;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SumAllMain {

    public static void main(String[] args) {

        ArrayList<SumRange_Runnable> listOfRunnables = new ArrayList<>();

        // sum value from 1 - 30, by splitting work
        listOfRunnables.add(new SumRange_Runnable(1, 10));
        listOfRunnables.add(new SumRange_Runnable(11, 20));
        listOfRunnables.add(new SumRange_Runnable(21, 30));

        final int number_of_threads = 2;    // number of threads in the thread pool

        // Note that we have two threads in the thread pool, but we queue up 3 runnable tasks
        // to be executed. The first two will be executed, and when one finishes, the third will be
        // run on the thread that has become idle.
        System.out.println("Assigning three runnables to the Executor thread-pool.");
        ExecutorService executor = Executors.newFixedThreadPool(number_of_threads);
        for (int i = 0; i < listOfRunnables.size(); i++) {      // queue up all 3 runnables to be executed in thread pool
            executor.execute(listOfRunnables.get(i));
        }

        int count = 0;

        executor.shutdown(); // request that the thread pool be shut down (not instantaneous)
        // AAfter shutdown, the executor will not accept any more runnable tasks to be executed.

        // The runnable tasks will be executed in the thread pool (one runnable per thread).
        // We must pause the main thread (that main() is running on ) until all the
        // runnables have completed their work.
        // The code below uses awaitTermination() to achieve this.
        // This serves the same purpose of the thread.join() in the previous samples -
        // it stops the main thread here until all queued executor runnable tasks in pool have terminated.
        // Once all have finished, the main thread can proceed and the 'sum' results will
        // be available in the runnable objects. We can then add them all up.

        try {
            while (!executor.awaitTermination(100, TimeUnit.MILLISECONDS)) {
                // if all threads have not terminated in the last 100ms interval, then
                // print the time lapsed, and then wait again for another 100 ms.
                System.out.println("Waiting - time passes = " + (count * 100) +" milliseconds");
                count++;
            }
        } catch (InterruptedException ex) {
            System.out.println("Interrupted exception: " + ex);
        }

        System.out.println("Executor is shutdown, and all threads have finished their work....");
        System.out.println("Summing up the 'sum' totals for all the runnables....");
        int total = 0;
        int i=0;
        for (SumRange_Runnable r : listOfRunnables) {
            System.out.println("Sum from runnable " + ++i +" = " + r.getSum() );
            total = total + r.getSum();
        }
        System.out.println("Grand total = " + total);
    }
}
