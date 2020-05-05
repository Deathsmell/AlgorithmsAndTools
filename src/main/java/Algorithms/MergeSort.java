package Algorithms;

/**
 * The type Merge sort.
 */
public class MergeSort {


    /**
     * Merge sort int [ ].
     *
     * @param resource array which the be sorted
     * @return the int [ ] which been sorted
     */
    public static int[] mergeSort(int[] resource) {

        int[] temp;
        int[] currentArr = resource;
        int[] currentDest = new int[resource.length];

        int size = 1;
        while (size < resource.length) {
            for (int i = 0; i < resource.length; i += 2 * size) {
                merge(currentArr, i, currentArr, i + size, currentDest, i, size);
            }

            temp = currentArr;
            currentArr = currentDest;
            currentDest = temp;

            size *= 2;
        }

        return currentArr;
    }

    /**
     * Algorithm merge two array int [ ].
     *
     * @param arr1      first input array
     * @param arr1Start index starts position for first array
     * @param arr2      second input array
     * @param arr2Start index starts position for second array
     * @param dest      destination array to which we'll store the result
     * @param destStart index position where started to writing
     * @param size      size subarray
     */
    private static void merge(int[] arr1, int arr1Start, int[] arr2, int arr2Start, int[] dest, int destStart, int size) {

        int index1 = arr1Start;
        int index2 = arr2Start;

        int arr1End = Math.min(arr1Start + size, arr1.length);
        int arr2End = Math.min(arr2Start + size, arr2.length);

        int iterationStart = arr1End - arr2Start + arr2End - arr1Start;

        for (int i = destStart; i < destStart + iterationStart; i++) {

            if (index1 < arr1End && (index2 >= arr2End || arr1[index1] < arr2[index2])) {
                dest[i] = arr1[index1];
                index1++;
            } else {
                dest[i] = arr2[index2];
                index2++;
            }

        }
    }

    public static int[] merge (int [] arr1, int[] arr2){
        int[] result = new int[arr1.length + arr2.length];
        merge(arr1, 0, arr2, 0, result,0,result.length);
        return result;
    }

    public static void merge (int[] source, int [] fromArr1, int[] fromArr2){
        merge(fromArr1,0,fromArr2,0,source,0,source.length);
    }

}
