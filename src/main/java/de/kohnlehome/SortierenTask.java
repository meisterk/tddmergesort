package de.kohnlehome;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class SortierenTask extends RecursiveTask<int[]> {

    private int[] unsortedArray;
    private IMerger merger;

    public SortierenTask(int[] unsortedArray, IMerger merger) {
        this.unsortedArray = unsortedArray;
        this.merger = merger;
    }

    @Override
    protected int[] compute() {
        if(unsortedArray.length <= 1){
            return unsortedArray;
        }
        else{
            int mid = unsortedArray.length/2;

            int[] leftSideOfArray = Arrays.copyOfRange(unsortedArray,0,mid);
            int[] rightSideOfArray= Arrays.copyOfRange(unsortedArray, mid, unsortedArray.length);

            //leftSideOfArray = sort(leftSideOfArray);
            //rightSideOfArray = sort(rightSideOfArray);
            SortierenTask leftTask = new SortierenTask(leftSideOfArray, merger);
            SortierenTask rightTask = new SortierenTask(rightSideOfArray, merger);
            invokeAll(leftTask, rightTask);


            int[] resultArray = merger.merge(leftTask.join(), rightTask.join());

            return resultArray;

        }
    }
}
