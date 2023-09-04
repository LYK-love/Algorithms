package Solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution174Test {

    Solution174 s = new Solution174();

    @Test
    void calculateMinimumHP() {
        int[][] dungeon1 = new int[][]{ {-2,-3,3}, {-5,-10,1}, {10,30,-5} };
        int exp1 = 7;
        int actual1 = s.calculateMinimumHP(dungeon1);

        int[][] dungeon2 = new int[][]{ {0} };
        int exp2 = 1;
        int actual2 = s.calculateMinimumHP(dungeon2);

        assertAll(
                ()-> Assertions.assertEquals(exp1,actual1),
                ()-> Assertions.assertEquals(exp2,actual2)
        );
    }
}