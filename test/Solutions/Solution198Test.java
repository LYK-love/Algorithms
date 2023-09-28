package Solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution198Test {
    Solution198 s = new Solution198();
    @Test
    void rob() {
        int[] nums1 = new int[]{1,2,3,1};
        int expect1=4, actual1 = s.rob(nums1);

        int[] nums2 = new int[]{2,7,9,3,1};
        int expect2=12, actual2 = s.rob(nums2);


        assertAll(
                () -> Assertions.assertEquals(expect1, actual1),
                () -> Assertions.assertEquals(expect2, actual2)
        );
    }
}