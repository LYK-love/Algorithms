package Utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {

    @Test
    void testToString() {

        int[][] arr1 = {{1,6},{8,10},{15,18}};
        int[][] arr2 = {{1,5}};
        int[][] arr3 = {{}};

        assertAll(
                () -> Assertions.assertEquals("[[1, 6], [8, 10], [15, 18]]", ArrayUtils.toString(arr1)),
                () -> Assertions.assertEquals("[[1, 5]]", ArrayUtils.toString(arr2)),
                () -> Assertions.assertEquals("[[]]", ArrayUtils.toString(arr3))
                );


    }
}