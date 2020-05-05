package Algorithms;

import java.util.Arrays;

public class FindMaxCrossingSubarray {

    private static class SubArrayDTO {
        private final int start;
        private final int end;
        private final int sum;
        private final int[] elems;

        /**
         * An entity to pass the result between search methods.
         *
         * @param start index of the initial element of the original array
         * @param end   index of the last element of the original array
         * @param sum   the sum all elements between start and end
         * @param elems the array found elements
         */
        public SubArrayDTO(int start, int end, int sum, int[] elems) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.elems = Arrays.copyOfRange(elems, start, end + 1);
        }

        public int[] getRange() {
            int[] range = new int[2];
            range[0] = start;
            range[1] = end;
            return range;
        }

        @Override
        public boolean equals(final Object o) {
            if (o == this) return true;
            if (o == null) return false;
            if (o.getClass() != this.getClass()) return false;
            if (!super.equals(o)) return false;
            final SubArrayDTO other = (SubArrayDTO) o;
            return this.sum == 0 ? other.sum == 0 : this.sum == other.sum;
        }

        @Override
        public String toString() {
            return  "start:" + start + "\n" +
                    "end:" + end + "\n" +
                    "sum:" + sum + "\n" +
                    "elems:" + Arrays.toString(elems);
        }
    }


    private static SubArrayDTO findMaxCrossingSubarray(int[] source, int low, int mid, int high) {

        int maxLeft, maxRight;
        maxLeft = maxRight = 0;

        int leftSum = 0;
        int sum = 0;
        for (int i = mid; low <= i; i--) {
            sum += source[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        int rightSum = 0;
        sum = 0;
        for (int i = mid + 1; i < high; ++i) {
            sum += source[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }

        if (maxLeft > maxRight) {
            maxLeft = maxRight;
        }

        return new SubArrayDTO(maxLeft, maxRight, leftSum + rightSum, source);
    }

    private static SubArrayDTO find(int[] source, int low, int high) {
        if (Arrays.binarySearch(source,0) == -1 && source.length == 0) {
            throw new IllegalArgumentException("Массив не может быть пустым");
        }
        if (low == high) {
            return new SubArrayDTO(low, high, source[low], source);
        } else {
            int mid = (low + high) / 2;

            SubArrayDTO left = find(source, low, mid);
            SubArrayDTO right = find(source, mid + 1, high);
            SubArrayDTO cross = findMaxCrossingSubarray(source, low, mid, high);

            if (left.sum >= right.sum && left.sum >= cross.sum) {
                return left;
            } else if (right.sum >= left.sum && right.sum >= cross.sum) {
                return right;
            } else {
                return cross;
            }
        }
    }

    public static int[] findArray(int[] source) {
        return find(source, 0, source.length - 1).elems;
    }

    public static int[] findRange(int[] source) {
        return find(source, 0, source.length - 1).getRange();
    }

    public static int findStartIndex(int[] source) {
        return find(source, 0, source.length - 1).start;
    }

    public static int findEndIndex(int[] source) {
        return find(source, 0, source.length - 1).end;
    }

    public static int findSum(int[] source) {
        return find(source, 0, source.length - 1).sum;
    }

    public static String stringResult(int[] source) {
        return find(source, 0, source.length - 1).toString();
    }
}
