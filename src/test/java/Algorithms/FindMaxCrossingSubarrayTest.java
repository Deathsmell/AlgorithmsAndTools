package Algorithms;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import static Algorithms.FindMaxCrossingSubarray.*;
import static java.util.Arrays.copyOfRange;
import static org.junit.jupiter.api.Assertions.*;

class FindMaxCrossingSubarrayTest {

    private static final String matcherCorrectStringResult = "start:\\d+\nend:\\d+\nsum:\\d+\nelems:\\u005B.*\\u005D";
    private static final String correctStringResult = "start:7\nend:10\nsum:43\nelems:[18, 20, -7, 12]";

    private static final int[] sourceArray = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
    private static final int[] correctResult = {18, 20, -7, 12};
    private static final int[] correctRange = {7, 10};
    private static final int correctSum = 43;

    private static final int[] empty = {};
    private static final int[] zero = {0};
    private static final int[] posOne = {1};
    private static final int[] negOne = {-1};
    private static final int[] posTwo = {2, 3};
    private static final int[] negTwo = {-1, -2};
    private static final int[] onlyPositive = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static final int[] repeatPosOne = {1, 1, 1, 1, 1, 1, 1, 1, 1};
    private static final int[] onlyNegative = {-1, -2, -3, -4, -5, -6, -7, -8, -9};
    private static final int[] repeatNegOne = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

    @Test
    public void correctDisplayOfTheSearchResultAsAString() {
        List<String> expected = Collections.singletonList(stringResult(sourceArray));
        List<String> actual = Collections.singletonList(correctStringResult);

        boolean matches = Pattern.compile(matcherCorrectStringResult).matcher(stringResult(sourceArray)).matches();

        assertLinesMatch(expected, actual);
        assertTrue(matches);
    }


    @Test
    public void returnCorrectFirstAndEndIndex() {
        assertEquals(findRange(sourceArray).length, 2);
        assertArrayEquals(findRange(sourceArray), correctRange);
        assertEquals(findStartIndex(sourceArray), correctRange[0]);
        assertEquals(findEndIndex(sourceArray), correctRange[1]);
    }

    @Test
    public void ifSourceArrayContainMoreWhenOnePositiveElementsReturnSourceArrayWithoutLastElement() {
        assertArrayEquals(findArray(onlyPositive), copyOfRange(onlyPositive, 0, onlyPositive.length - 1));
        assertArrayEquals(findArray(repeatPosOne), copyOfRange(repeatPosOne, 0, onlyPositive.length - 1));
    }

    @Test
    public void ifSourceArrayContainOnlyNegativeItReturnOneLargestElement() {
        assertNotNull(negOne);
        assertNotNull(onlyNegative);
        assertNotNull(repeatNegOne);

        assertEquals(findArray(negOne).length, 1);
        assertEquals(findArray(onlyNegative).length, 1);
        assertEquals(findArray(repeatNegOne).length, 1);

        assertArrayEquals(findArray(negOne), negOne);
        assertEquals(findArray(onlyNegative)[0], onlyNegative[0]);
        assertEquals(findArray(repeatNegOne)[0], repeatNegOne[0]);
    }

    @Test
    public void ifSourceArrayContainMoreThenOneNegativeElementsItsSumEqualZero() {
        assertEquals(findSum(negTwo), 0);
        assertEquals(findSum(onlyNegative), 0);
        assertEquals(findSum(repeatNegOne), 0);
    }

    @Test
    public void ifSourceArrayContainTwoPositiveElementsReturnLargest() {
        if (posTwo[0] > posTwo[1]) {
            assertEquals(findSum(posTwo), posTwo[0]);
            assertArrayEquals(findArray(posTwo), new int[]{posTwo[0]});
        } else {
            assertEquals(findSum(posTwo), posTwo[1]);
            assertArrayEquals(findArray(posTwo), new int[]{posTwo[1]});
        }
    }


    @Test
    public void ifSourceArrayContainOneElementsThisNumber() {
        assertEquals(findSum(zero), zero[0]);
        assertEquals(findSum(posOne), posOne[0]);
        assertEquals(findSum(negOne), negOne[0]);
    }

    @Test

    public void ifSourceArrayEmptyThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> findArray(empty));
        assertThrows(IllegalArgumentException.class, () -> findSum(empty));
        assertThrows(IllegalArgumentException.class, () -> findRange(empty));
        assertThrows(IllegalArgumentException.class, () -> findEndIndex(empty));
        assertThrows(IllegalArgumentException.class, () -> findStartIndex(empty));
        assertThrows(IllegalArgumentException.class, () -> stringResult(empty));
    }

    @Test
    public void correctReturnResultArray() {
        int[] resultArr = findArray(sourceArray);
        assertNotNull(resultArr);
        assertArrayEquals(resultArr, correctResult);
    }

    @Test
    public void correctReturnResultSum() {
        int resultSum = findSum(sourceArray);
        assertEquals(resultSum, correctSum);
    }

    @Test
    public void correctReturnResultRangeArray() {
        int[] resultRange = findRange(sourceArray);
        assertNotNull(resultRange);
        assertArrayEquals(resultRange, correctRange);
    }
}