package Solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution55Test {

    Solution55 s = new Solution55();
    @Test
    public void testCanJump() {
        int[] nums1 = {3,2,1,0,4};
        int[] nums2 = {2,3,1,1,4};

        assertAll(
                () -> Assertions.assertEquals(false, s.canJump(nums1)),
                () -> Assertions.assertEquals(true, s.canJump(nums2))
        );
    }
}