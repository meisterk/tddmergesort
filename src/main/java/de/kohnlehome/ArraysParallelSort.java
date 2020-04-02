package de.kohnlehome;

import java.util.Arrays;

public class ArraysParallelSort implements ISortAlgorithm {
    @Override
    public int[] sort(int[] unsortedArray) {
        Arrays.parallelSort(unsortedArray);
        return unsortedArray;
    }
}
