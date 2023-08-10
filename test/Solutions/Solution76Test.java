package Solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution76Test {
    Solution76 s = new Solution76();
    @Test
    void minWindow() {
        String s_1 = "ADOBECODEBANC", t_1 = "ABC";
        String res_1 = "BANC";

        String s_2 = "a", t_2 = "aa";
        String res_2 = "";



        assertAll(
                () -> Assertions.assertEquals(res_1, s.minWindow(s_1,t_1)),
                () -> Assertions.assertEquals(res_2, s.minWindow(s_2,t_2))
        );

    }
}