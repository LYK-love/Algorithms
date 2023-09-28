package Solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution583Test {
    Solution583 s = new Solution583();
    @Test
    void minDistance() {
        String s1_1 = "sea", s2_1 = "eat";
        int expect1 = 2, actual1 = s.minDistance(s1_1,s2_1);

        String s1_2 = "leetcode", s2_2 = "etco";
        int expect2 = 4, actual2 = s.minDistance(s1_2,s2_2);

        assertAll(
                ()-> Assertions.assertEquals(expect1,actual1),
                ()-> Assertions.assertEquals(expect2,actual2)
        );
    }
}