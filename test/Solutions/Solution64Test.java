package Solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution64Test {
    Solution64 s = new Solution64();
    @Test
    void minPathSum() {
        int[][] grid1 = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int res1 = s.minPathSum(grid1);

        int[][] grid2 = new int[][]{{1,2,3},{4,5,6}};
        int res2 = s.minPathSum(grid2);

        assertAll(
                () -> Assertions.assertEquals(7, res1),
                () -> Assertions.assertEquals(12, res2)

        );
    }
}