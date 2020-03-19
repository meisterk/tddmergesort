package de.kohnlehome;

import java.util.concurrent.ForkJoinPool;

public class ParallelMergeSort implements IMergeSort{
    @Override
    public int[] sort(int[] unsortedArray) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        SortierenTask sortierenTask = new SortierenTask(unsortedArray);
        forkJoinPool.invoke(sortierenTask);
        return new int[0];
    }
}
