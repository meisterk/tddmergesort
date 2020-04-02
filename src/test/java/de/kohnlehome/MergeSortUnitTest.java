package de.kohnlehome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MergeSortUnitTest {

    private ISortAlgorithm mergeSort;

    @BeforeEach
    public void init() {
        //Arrange
        IMerger merger = mock(IMerger.class);
        when(merger.merge(new int[]{5}, new int[]{3})).thenReturn(new int[]{3,5});
        when(merger.merge(new int[]{2}, new int[]{4})).thenReturn(new int[]{2,4});
        when(merger.merge(new int[]{1}, new int[]{2,4})).thenReturn(new int[]{1,2,4});
        when(merger.merge(new int[]{3,5}, new int[]{1,2,4})).thenReturn(new int[]{1,2,3,4,5});

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
