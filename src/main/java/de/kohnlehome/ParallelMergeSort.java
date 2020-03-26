package de.kohnlehome;

import java.util.concurrent.ForkJoinPool;

public class ParallelMergeSort implements IMergeSort {
    private IMerger merger;
    private ForkJoinPool forkJoinPool;

    public ParallelMergeSort(IMerger merger) {
        this.merger = merger;
        forkJoinPool = new ForkJoinPool();
    }

    @Override
    public int[] sort(int[] unsortedArray) {
        SortierenTask sortierenTask = new SortierenTask(unsortedArray, merger);
        forkJoinPool.invoke(sortierenTask); // call compute() method in sortierenTask
        return sortierenTask.join(); // get return value of compute() method
    }
}
