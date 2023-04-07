package Solutions;



/**
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */
class Solution64 {
    /**
     * grid形如:
     * 1 4 4 6 7
     * 1 4 1 2 3
     * 1 4 4 5 6
     *
     * 使用二维的dp数组, dp[i][j] = 以坐标(i,j)为起点, grid右下角为终点的路径的最短路径和. 由于每一步要么往下, 要么往右, 因此取这二种情况的最小值即可.
     *
     * 对于坐标(i,j), dp[i][j] = grid[i][j] + min（ 以坐标(i,j)右边的格子为起点的路径的最短路径和 , 以坐标(i,j)下边的格子为起点的路径的最短路径和 ）
     * 即: memo[x][y] = grid[x][y] + Math.min( memo[x+1][y], memo[x][y+1]);
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Integer[][] memo = new Integer[m][n];
        dp(grid, memo, new int[]{0,0});
        return memo[0][0];

    }

    private void dp(int[][] grid, Integer[][] memo, int[] coordinate)
    {
        int m = grid.length;
        int n = grid[0].length;

        int x = coordinate[0];
        int y = coordinate[1];

        //最右下角
        if(x == m-1 && y == n-1)
        {
            memo[x][y] = grid[m-1][n-1];
            return;
        }
        else
        {

            if( x+1 < m && memo[x+1][y] == null)
                dp(grid, memo, new int[]{x+1,y});
            if( y+1 < n && memo[x][y+1] == null)
                dp(grid,memo, new int[]{x,y+1});

            if( x == m-1)//最后一行
            {
                memo[x][y] = grid[x][y] + memo[x][y+1];
                return;
            }
            if(y == n-1)//最后一列
            {
                memo[x][y] = grid[x][y] + memo[x+1][y];
                return;
            }
            else
            {
                memo[x][y] = grid[x][y] + Math.min( memo[x+1][y], memo[x][y+1]);
                return;
            }
        }

    }
}