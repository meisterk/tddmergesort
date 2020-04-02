package de.kohnlehome;

public class ParallelMergeSort implements ISortAlgorithm {
    private IMerger merger;

    public ParallelMergeSort(IMerger merger) {
        this.merger = merger;
    }

    @Override
    public int[] sort(int[] unsortedArray) {
        SortierenTask sortierenTask = new SortierenTask(unsortedArray, merger);
        sortierenTask.invoke();
        return sortierenTask.join();
    }
}
