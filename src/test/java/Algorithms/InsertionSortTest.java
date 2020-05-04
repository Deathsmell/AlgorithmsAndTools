package Algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InsertionSortTest {

    @Test
    void sort() {
        Double[] sourceArr = {.5,.4,.6,.3,.8,.7,.2,.1};

        Double[] result = InsertionSort.sort(sourceArr);
        System.out.println(Arrays.toString(result));
        Double[] resultArr = {.1,.2,.3,.4,.5,.6,.7,.8};

        assertArrayEquals(result,resultArr);
        assertEquals(sourceArr.length,resultArr.length);

    }
}