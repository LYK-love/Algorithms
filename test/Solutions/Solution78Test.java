package Solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;


class Solution778est {
    Solution78 s = new Solution78();

    @Test
    void combine() {
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{0};



        List<List<Integer>> res1 = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList(1,2),
                Arrays.asList(1,3),
                Arrays.asList(2,3),
                Arrays.asList(1,2,3)
        );

        List<List<Integer>> res2 = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(0)

        );




        assertAll(
                () -> Assertions.assertEquals(res1, s.subsets(nums1)),
                () -> Assertions.assertEquals(res2, s.subsets(nums2))
        );

    }
}