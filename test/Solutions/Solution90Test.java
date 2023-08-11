package Solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution90Test {
    Solution90 s = new Solution90();

    @Test
    void combine() {
        int[] nums1 = new int[]{1,2,2};
        int[] nums2 = new int[]{0};



        List<List<Integer>> res1 = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(1,2),
                Arrays.asList(2,2),
                Arrays.asList(1,2,2)
        );

        List<List<Integer>> res2 = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(0)

        );



        assertAll(
                () -> Assertions.assertEquals(res1, s.subsetsWithDup(nums1)),
                () -> Assertions.assertEquals(res2, s.subsetsWithDup(nums2))
        );

    }
}