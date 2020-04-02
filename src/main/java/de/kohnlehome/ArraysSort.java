package de.kohnlehome;

import java.util.Arrays;

public class ArraysSort implements ISortAlgorithm{
    @Override
    public int[] sort(int[] unsortedArray) {
        Arrays.sort(unsortedArray);
        return unsortedArray;
    }
}
