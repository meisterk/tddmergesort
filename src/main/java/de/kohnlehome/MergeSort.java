package de.kohnlehome;

import java.util.Arrays;

public class MergeSort implements ISortAlgorithm {
    private IMerger merger;

    public MergeSort(IMerger merger) {
        this.merger = merger;
    }

    @Override
    public int[] sort(int[] unsortedArray) {
        if(unsortedArray.length <= 1){
            return unsortedArray;
        }
        else{
         int mid = unsortedArray.length/2;

         int[] leftSideOfArray = Arrays.copyOfRange(unsortedArray,0,mid);
         int[] rightSideOfArray= Arrays.copyOfRange(unsortedArray, mid, unsortedArray.length);

         leftSideOfArray = sort(leftSideOfArray);
         rightSideOfArray = sort(rightSideOfArray);



         int[] resultArray = merger.merge(leftSideOfArray, rightSideOfArray);

         return resultArray;

        }
    }

}
