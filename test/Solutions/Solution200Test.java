package Solutions;

import Utils.WrapperValueComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static Utils.ArrayUtils.equalsFor2D;
import static org.junit.jupiter.api.Assertions.*;

class Solution200Test {
    Solution200 s = new Solution200();

    @Test
    void numIslands() {
        char[][] grid1 = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        int exp1 = 1, actual1 = s.numIslands(grid1);

        char[][] grid2 = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        int exp2 = 3, actual2 = s.numIslands(grid2);

        assertAll(
                ()-> Assertions.assertEquals(  exp1, actual1 ),
                ()-> Assertions.assertEquals(  exp2, actual2 )
        );
        
    }
}