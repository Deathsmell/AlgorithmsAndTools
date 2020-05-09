package Algorithms;

import java.util.Arrays;

public class FindIdenticalNearbyElements {

    public static String showResults(int[] original) {
        StringBuilder result = new StringBuilder();

        // делаем буферную переменную с элементом маркером на конце
        int[] source = Arrays.copyOf(original, original.length+1);
        source[original.length] = Integer.MAX_VALUE;

        for (int i = 0; i < source.length; i++) {
            for (int j = i + 1; j < source.length; j++) {
                if (source[i] != source[j]) {
                    // побитовое & 1 равноценно % 2 но выполняется в 2 раза быстрее
                    if (((j - i) & 1) != 1) {
                        String array = Arrays.toString(Arrays.copyOfRange(source, i, j));
                        result
                                .append("Совпадение с позиции ").append(i)
                                .append(" по ").append(j)
                                .append(" состоящее из: ").append(array)
                                .append("\n");
                    }
                    i = j - 1;
                    break;
                }
            }
        }
        return result.toString();
    }

}
