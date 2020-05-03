package Algoritms;

/*
* Сортировка вставкой
* Скорость O(n^2)
* */
public abstract class InsertionSort {

    public static Double[] sort(Double[] arr){
        Double key;
        int j;
        for (int i = 1; i < arr.length; i++) { // начинаем с второго элемента
            key = arr[i]; // запоминаем второй элемент
            j = i - 1; // устанавливаем тригер на предшествуюзий элемент
            while (j > 0 && arr[j] > key) { // если предшествующий элемент меньше
                arr[j + 1] = arr[j]; // переставляем элемент дальше
                j--; // тригер уходит еще на один элемент назад
            }
            arr[j+1] = key; // если больше нету элементов то вставляем начальный элемент
        }
        return arr;
    }
}
