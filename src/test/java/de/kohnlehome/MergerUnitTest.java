package de.kohnlehome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergerUnitTest {
    private IMerger merger;

    @BeforeEach
    public void init(){
        //Arrange
        merger = new Merger();
    }

    @Test
    public void test(){
        //Act
        int[] result = merger.merge(new int[]{1}, new int[]{2});

        //Assert
        assertThat(result).isEqualTo(new int[]{1,2});
    }


}
