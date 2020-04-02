package de.kohnlehome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ArraysParallelSortTest {

    private ISortAlgorithm arraysParallelSort;

    @BeforeEach
    public void init() {
        //Arrange
        arraysParallelSort = new ArraysParallelSort();
    }

    @Test
    public void test(){
        int[] unsorted = {5,3,1,2,4};
        //Act
        int[] sorted = arraysParallelSort.sort(unsorted);

        //Assert
        int[]expected = {1,2,3,4,5};
        assertThat(sorted).isEqualTo(expected);
    }
}
