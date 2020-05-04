package Utils;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilConcat {

    @Test
    public void returnAgglutinateArrays (){
        Double[] arr1 = {0.1,0.2,0.3,0.4};
        Double[] arr2 = {.5,.6,.7,.8};

        Double[] result = ArrayUtil.concat(arr1, arr2);

        assertNotNull(result);

        assertEquals(arr1.length + arr2.length, result.length);
    }

    @Test
    public void canHandlersStringsArray(){
        String[] arr1 = {"0.1","0.2","0.3","0.4"};
        String[] arr2 = {".5",".6",".7",".8"};

        String[] result = ArrayUtil.concat(arr1, arr2);

        assertNotNull(result);

        assertEquals(arr1.length + arr2.length,result.length);
    }

    @Test
    public void canHandlersMap(){
        String[] arr1 = {"0.1","0.2","0.3","0.4"};
        String[] arr2 = {".5",".6",".7",".8"};
        String[] arr3 = {".9",".10",".11",".12"};
        String[] arr4 = {".13",".14",".15",".16"};

        Map<Integer, String[]> map = new HashMap<>();
        map.put(1,arr1);
        map.put(2,arr2);
        map.put(3,arr3);
        map.put(4,arr4);

        int sumLength = 0;
        for (String[] value : map.values()) {
            sumLength+=value.length;
        }

        String[] result = ArrayUtil.concat(map);

        assertNotNull(result);

        assertEquals(sumLength,result.length);
    }
}
