package Utils;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilSeparationTest {

    @Test
    public void returnTwoArraysEqualHalfLengthSourceArray() {
        int sourceLength = 10;
        Double[] doubles = new Double[sourceLength];

        Map<Integer, Double[]> result = ArrayUtil.separation(doubles);

        assertEquals(2, result.size());
        for (Double[] value : result.values()) {
            assertEquals(sourceLength / 2, value.length);
        }
    }


    @Test
    public void ifSourceArrayHaveOddLengthFirstArrayWillBeMore() {
        int sourceLength = 11;
        Double[] doubles = new Double[sourceLength];

        Map<Integer, Double[]> result = ArrayUtil.separation(doubles);

        Double[] arr1 = result.get(1);
        Double[] arr2 = result.get(2);

        assertEquals(2,result.size());
        assertNotEquals(arr1.length,arr2.length);
        assertTrue(arr1.length > arr2.length);
    }


    @Test
    public void trowExceptionIfSourceArrayEmpty(){
        Double[] doubles = new Double[0];
        assertThrows(IllegalArgumentException.class, () -> ArrayUtil.separation(doubles));
    }

    @Test
    public void canHandlesStringsArray(){
        String[] strings = {"one", "two", "three", "fore", "five"};

        Map<Integer, String[]> result = ArrayUtil.separation(strings);

        assertEquals(2,result.size());
        for (String[] value : result.values()) {
            assertNotNull(value);
        }
    }
}
