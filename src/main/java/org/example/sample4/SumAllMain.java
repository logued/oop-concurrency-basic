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

        final int total_threads = 3;    // number of threads in the thread pool

        ExecutorService executor = Executors.newFixedThreadPool(total_threads);
        for (int i = 0; i < total_threads; i++) {
            executor.execute(listOfRunnables.get(i));
        }

        // If we want to WAIT for the runnables to complete we need the following code

        int count = 0;

        executor.shutdown(); // request that the thread pool be shut down (not instantaneous)

        // wait for all threads in the pool to have finished executing their runnables
        // before we call the getSum() methods in the runnable tasks.
        // This serves teh same purpose of the thread.join() in the previous samples
        // It stops the main thread here until all executor threads in pool have terminated.
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

        int total = 0;
        for (SumRange_Runnable r : listOfRunnables) {
            total = total + r.getSum();
        }
        System.out.println("Grand total = " + total);
    }
}
