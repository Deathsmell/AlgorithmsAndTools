package Utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ArrayUtil {

    @SuppressWarnings("unchecked")
    public static <T> Map<Integer, T[]> separation(T[] arr) {
        if (!arr.getClass().isArray() || arr.length == 0) {
            throw new IllegalArgumentException("Пустой масив");
        }
        Map<Integer, T[]> result = new HashMap<>();
        int middle = arr.length / 2;
        boolean flag = arr.length % 2 == 1;

        T[] arr2, arr1;


        arr1 = flag ? (T[]) Array.newInstance(arr.getClass().getComponentType(), middle + 1)
                : (T[]) Array.newInstance(arr.getClass().getComponentType(), middle);

        arr2 = (T[]) Array.newInstance(arr.getClass().getComponentType(), middle);

        System.arraycopy(arr, 0, arr1, 0, arr1.length);
        System.arraycopy(arr, middle, arr2, 0, arr2.length);

        result.put(1, arr1);
        result.put(2, arr2);

        return result;
    }
    @SuppressWarnings("unchecked")
    public static <T> T[] concat(T[] arr1, T[] arr2) {
        if (!arr1.getClass().isArray() || !arr2.getClass().isArray()) {
            throw new IllegalArgumentException("Один из аргументов не является масивом");
        }

        T[] result = (T[]) Array.newInstance(arr1.getClass().getComponentType(), arr1.length + arr2.length);

        System.arraycopy(arr1, 0, result, 0, arr2.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);

        return result;
    }
    @SuppressWarnings("unchecked")
    public static <T> T[] concat(Map<? extends Number, T[]> map) {
        // Проверка на пустоту
        if (map.isEmpty()) {
            throw new IllegalArgumentException("Пустой элемент");
        }
        // Вытаскиваю колекцию значений
        Collection<T[]> values = map.values();

        // Нахожу клас дженерика
        Class<?> aClass = null;
        long limit = 1;
        for (T[] value : values) {
            if (limit-- == 0) break;
            aClass = value.getClass();
        }
        if (!aClass.isArray()) {
            throw new IllegalArgumentException("Не является масивом");
        }

        // Масив результата
        int sumLength = values.stream().mapToInt(ts -> ts.length).sum();
        T[] result = (T[]) Array.newInstance(aClass.getComponentType(), sumLength);

        // Запихиваю соединяю масивы
        int length = 0;
        for (T[] arr : values) {
            System.arraycopy(arr, 0, result, length, arr.length);
            length += arr.length;
        }

        return result;
    }


}