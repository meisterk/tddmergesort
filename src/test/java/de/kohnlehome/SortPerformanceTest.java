package de.kohnlehome;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class SortPerformanceTest {

    private final int size = 10000000;
    private int[] unsortedArray;

    @Test
    public void testPerformance() {
        //großes Array mit Zufallszahlen erstellen
        Random rand = new Random();
        unsortedArray = new int[size];

        for (int i = 0; i < size; i++) {
            unsortedArray[i] = rand.nextInt(size + 1);
        }

        ISortAlgorithm parallelMergeSort = new ParallelMergeSort(new Merger());
        messenUndAusgeben(parallelMergeSort);

        ISortAlgorithm mergeSort = new MergeSort(new Merger());
        messenUndAusgeben(mergeSort);

        ISortAlgorithm arraysSort = new ArraysSort();
        messenUndAusgeben(arraysSort);

        ISortAlgorithm arraysParallelSort = new ArraysParallelSort();
        messenUndAusgeben(arraysParallelSort);

    }

    private void messenUndAusgeben(ISortAlgorithm sortAlgorithm) {
        int[] copyOfArray = unsortedArray.clone();
        long startTime = System.nanoTime();
        sortAlgorithm.sort(copyOfArray);
        long endTime = System.nanoTime();
        long durationInMs = (endTime - startTime) / 1000000;
        System.out.println(sortAlgorithm.getClass().getSimpleName() + ":\t" + durationInMs + "ms");
    }
}
