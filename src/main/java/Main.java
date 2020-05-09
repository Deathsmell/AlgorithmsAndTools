import java.util.stream.Stream;

public class Main {



    public static void main(String[] args) {

        Double[] arr = Stream
                .generate(Math::random)
//                .map(Double::intValue)
                .limit(20)
                .toArray(Double[]::new);

        // Сортировка вставкой
//        Double[] result = InsertionSort.sort(arr);

//        Arrays.stream(result)
//                .forEach(System.out::println);
    }


}
