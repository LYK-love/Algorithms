package Solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution77Test {
    Solution77 s = new Solution77();

    @Test
    void combine() {
        int n1 = 4, k1 = 2;
        int n2 = 1, k2 = 1;

        List<List<Integer>> res1 = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(1, 3),
                Arrays.asList(1, 4),
                Arrays.asList(2, 3),
                Arrays.asList(2, 4),
                Arrays.asList(3, 4)
        );

        List<List<Integer>> res2 = Arrays.asList(
                Arrays.asList(1)
        );




        assertAll(
                () -> Assertions.assertEquals(res1, s.combine(n1,k1)),
                () -> Assertions.assertEquals(res2, s.combine(n2,k2))
        );

    }
}