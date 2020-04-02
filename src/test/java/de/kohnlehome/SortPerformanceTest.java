package de.kohnlehome;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class SortPerformanceTest {

    private final int size = 10000;

    @Test
    public void testPerformance(){
        //großes Array mit Zufallszahlen erstellen
        Random rand = new Random();
        int[] unsortedArray = new int[size];

        for(int i = 0; i< size;i++){
            unsortedArray[i] = rand.nextInt(size+1);
        }

        ISortAlgorithm parallelMergeSort = new ParallelMergeSort(new Merger());
        messenUndAusgeben(unsortedArray, parallelMergeSort);

        ISortAlgorithm mergeSort = new MergeSort(new Merger());
        messenUndAusgeben(unsortedArray, mergeSort);
    }

    private void messenUndAusgeben(int[] unsortedArray, ISortAlgorithm sortAlgorithm){
        long startTime = System.nanoTime();
        sortAlgorithm.sort(unsortedArray);
        long endTime = System.nanoTime();
        long durationInMs = (endTime-startTime)/1000000;
        System.out.println(sortAlgorithm.getClass().getSimpleName() +":\t" + durationInMs + "ms");
    }
}
