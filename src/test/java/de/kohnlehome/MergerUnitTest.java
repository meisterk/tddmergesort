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
    public void test12(){
        //Act
        int[] result = merger.merge(new int[]{1}, new int[]{2});

        //Assert
        assertThat(result).isEqualTo(new int[]{1,2});
    }

    @Test
    public void test12345(){
        //Act
        int[] result = merger.merge(new int[]{1,3,5}, new int[]{2,4});

        //Assert
        assertThat(result).isEqualTo(new int[]{1,2,3,4,5});
    }

    @Test
    public void test22689(){
        //Act
        int[] result = merger.merge(new int[]{2,6,9}, new int[]{2,8});

        //Assert
        assertThat(result).isEqualTo(new int[]{2,2,6,8,9});
    }


}
