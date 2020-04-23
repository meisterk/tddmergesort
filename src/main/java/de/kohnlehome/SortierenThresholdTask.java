package de.kohnlehome;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class SortierenThresholdTask extends RecursiveTask<int[]> {

    private int[] unsortedArray;
    private IMerger merger;
    private int threshold;

    public SortierenThresholdTask(int[] unsortedArray, IMerger merger, int threshold) {
        this.unsortedArray = unsortedArray;
        this.merger = merger;
        this.threshold = threshold;
    }

    @Override
    protected int[] compute() {
        if(unsortedArray.length <= threshold){
            Arrays.sort(unsortedArray);
            return unsortedArray;
        }
        else{
            int mid = unsortedArray.length/2;

            int[] leftSideOfArray = Arrays.copyOfRange(unsortedArray,0,mid);
            int[] rightSideOfArray= Arrays.copyOfRange(unsortedArray, mid, unsortedArray.length);

            //leftSideOfArray = sort(leftSideOfArray);
            //rightSideOfArray = sort(rightSideOfArray);
            SortierenThresholdTask leftTask = new SortierenThresholdTask(leftSideOfArray, merger, threshold);
            SortierenThresholdTask rightTask = new SortierenThresholdTask(rightSideOfArray, merger, threshold);
            invokeAll(leftTask, rightTask);


            int[] resultArray = merger.merge(leftTask.join(), rightTask.join());

            return resultArray;

        }
    }
}
