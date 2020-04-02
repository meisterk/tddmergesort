package de.kohnlehome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class MergeSortIntegrationTest {

    private ISortAlgorithm mergeSort;

    @BeforeEach
    public void init() {
        //Arrange
        IMerger merger = new Merger();

        mergeSort = new MergeSort(merger);
    }

    @Test
    public void test(){
        int[] unsorted = {5,3,1,2,4};
        //Act
        int[] sorted = mergeSort.sort(unsorted);

        //Assert
        int[]expected = {1,2,3,4,5};
        assertThat(sorted).isEqualTo(expected);
    }
}
