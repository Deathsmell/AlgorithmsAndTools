package Utils;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArrayUtils {
    @Test
    public void test() {
        Double[] arr = Stream
                .generate(Math::random)
//                .map(Double::intValue)
                .limit(20)
                .toArray(Double[]::new);

        Map<Integer, Double[]> separation = ArrayUtil.separation(arr);
        assertEquals(2, separation.size());
        Double[] concat = ArrayUtil.concat(separation);
        assertNotNull(concat);
    }
}
