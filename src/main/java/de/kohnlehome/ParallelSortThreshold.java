package de.kohnlehome;

public class ParallelSortThreshold implements ISortAlgorithm {
    private IMerger merger;
    private int threshold;

    public ParallelSortThreshold(IMerger merger, int threshold) {
        this.merger = merger;
        this.threshold = threshold;
    }

    @Override
    public int[] sort(int[] unsortedArray) {
        SortierenThresholdTask sortierenTask = new SortierenThresholdTask(unsortedArray, merger, threshold);
        sortierenTask.invoke();
        return sortierenTask.join();
    }
}
