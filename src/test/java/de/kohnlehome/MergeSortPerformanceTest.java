package de.kohnlehome;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class MergeSortPerformanceTest {

    private final int size = 100000000;

    @Test
    public void testPerformance(){
        //großes Array mit Zufallszahlen erstellen
        Random rand = new Random();
        int[] unsortedArray = new int[size];

        for(int i = 0; i< size;i++){
            unsortedArray[i] = rand.nextInt(size+1);
        }

        //Startzeit messen ParallelSort
        long parallelStart = System.nanoTime();
        //sortieren
        ParallelMergeSort parallelMergeSort = new ParallelMergeSort(new Merger());
        parallelMergeSort.sort(unsortedArray);
        //Endzeit messen ParallelSort
        long parallelEnde = System.nanoTime();

        //Startzeit messen MergeSort
        long mergeStart = System.nanoTime();
        //sortieren
        MergeSort mergeSort = new MergeSort(new Merger());
        mergeSort.sort(unsortedArray);
        //Endzeit messen MergeSort
        long mergeEnde = System.nanoTime();

        //Differenzen berechnen
        long difMergeInMs = (mergeEnde-mergeStart)/1000000;
        long difParalInMs = (parallelEnde-parallelStart)/1000000;

        //Differenz ausgeben
        System.out.println("MergeSort:\t" + difMergeInMs + "ms");
        System.out.println("ParallelSort:\t" + difParalInMs + "ms");
    }
}
