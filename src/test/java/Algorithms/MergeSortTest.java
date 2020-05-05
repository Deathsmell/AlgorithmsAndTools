package Algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void mergeTwoArrays() {
        int[] arr1 = {3, 5, 6, 9, 12, 15};
        int[] arr2 = {2, 4, 6, 6, 8, 12, 16};
        int length = arr1.length + arr2.length;

        int[] actual = {2, 3, 4, 5, 6, 6, 6, 8, 9, 12, 12, 15, 16};

        int[] result = new int[length];
        MergeSort.merge(result, arr1, arr2);

        assertNotNull(result);
        assertEquals(result.length, length);
        assertArrayEquals(result, actual);
    }


    @Test
    void mergeSort() {
        int[] source = Stream.generate(Math::random)
                .limit(200)
                .map(aDouble -> aDouble * 10000)
                .map(Math::round)
                .mapToInt(Long::intValue)
                .toArray();

        int[] result = MergeSort.mergeSort(source);
        System.out.println(Arrays.toString(result));


        for (int i = 0; i < result.length - 1; i++) {
            assertTrue(result[i] <= result[i + 1]);
        }
        assertNotNull(result);


    }
}