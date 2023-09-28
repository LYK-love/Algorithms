package Solutions;

public class Solution200 {
    public int numIslands(char[][] grid) {
        int M = grid.length, N = grid[0].length;

        int cnt = 0;
        for(int row = 0; row < M; row++)
            for(int col = 0; col < N; col++)
            {
                if(isLand(grid[row][col]))
                {
                    cnt++;
                    dfs_and_mark(row,col, grid);
                }
            }
        return cnt;

    }

    private boolean isLand(char ch)
    {
        return ch == '1';
    }

    private void flood(int row, int col, char[][] grid)
    {
        grid[row][col] = '0';
    }

    private void dfs_and_mark(int row, int col, char[][] grid)
    {
        int M = grid.length, N = grid[0].length;

        if(isLand(grid[row][col]))
        {
            flood(row,col,grid);//Turn this land into water.

            //Then apply this method to surrounding grid. Notice the limit of grid's boundary
            if(row>=1) dfs_and_mark(row-1,col,grid);
            if(row <= M-2) dfs_and_mark(row+1,col,grid);
            if(col>=1) dfs_and_mark(row,col-1,grid);
            if(col <= N-2) dfs_and_mark(row,col+1,grid);
        }
    }
}
