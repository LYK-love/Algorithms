package Solutions;

public class Solution130 {

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        // 棋盘有m*n个点, 再给 dummy 留一个额外位置, 并查集总大小为m*n+1
        UF uf = new UF(m*n+1);
        int dummy = m*n;

        // 将首列和末列的 'O' 与 dummy 连通
        for(int i = 0; i < m; i++)
        {
            if( isO(i,0,board) )
                uf.union(dummy, linearMap(i,0,m,n));

            if( isO(i,n-1,board) )
                uf.union(dummy, linearMap(i,n-1,m,n));
        }

        // 将首行和末行的 'O' 与 dummy 连通
        for(int j = 0; j < n; j++)
        {
            if( isO(0,j,board) )
                uf.union(dummy, linearMap(0,j,m,n));
            if( isO(m-1,j,board) )
                uf.union(dummy, linearMap(m-1,j,m,n));
        }

        DirectionMatrix help = new DirectionMatrix();
        for(int i=1; i < m-1; i++)
            for(int j=1; j < n-1; j++)
            {
                if( !isO(i,j,board) )
                    continue;

                int[] left = help.moveLeft(i,j);
                int[] right = help.moveRight(i,j);
                int[] down = help.moveDown(i,j);
                int[] up = help.moveUp(i,j);

                // 将此 'O' 与上下左右的 'O' 连通
                int thisO = linearMap(i,j, m, n);
                int leftPoint = linearMap(left[0],left[1], m, n);
                int rightPoint = linearMap(right[0],right[1], m, n);
                int downPoint = linearMap(down[0],down[1], m, n);
                int upPoint = linearMap(up[0],up[1], m, n);

                if( isO(left[0],left[1], board))
                    uf.union(thisO, leftPoint);
                if( isO(right[0],right[1], board))
                    uf.union(thisO, rightPoint);
                if( isO(down[0],down[1], board))
                    uf.union(thisO, downPoint);
                if( isO(up[0],up[1], board))
                    uf.union(thisO, upPoint);
            }

        for(int i=0; i < m; i++)
            for(int j=0; j < n; j++)
            {
                // 所有不与 dummy 连通的 'O' 都要被替换
                if( isO(i,j,board) && !uf.connected(dummy, linearMap(i,j, m, n)) )
                    flipO(i,j,board);
            }
    }

    /**
     * For a 2-D coordinate (x,y), 0 <= x < M, 0 <= y < N.
     * Map (x,y) to t. 0 <= t < M*N;
     * t = x * N + y;
     *
     * if:
     * x1 * N + y1 = x2 * N + y2
     * ( x1 - x2 ) * N = y2 - y1
     * N = (y2 - y1) / ( x1 - x2 )
     *
     * [0, N-1]
     * ---      < N
     * [1,M-1]
     *
     * N < N contradicts!
     * so: f is an injective function.
     *
     * Proof: f(x,y) = t is a bijective function( or one-to-one correspondence).
     *  1.  max(t) = max(x) * N + max(y) = (M-1) * N + N-1 = M*N - 1
     *      min(t) = 0
     *      So the mod of f(x,y) is M*N - 1.
     *  2. f is an injective function.
     *  3. So f is a bijective function.
     *
     *
     *
     *
     * @param x
     * @param y
     * @param N
     * @return
     */
    private int linearMap(int x, int y, int M, int N)
    {
        int t = x * N + y;
        return t;
    }

    private boolean isO(int x, int y, char[][] board)
    {
        return board[x][y] == 'O';
    }

    private void flipO(int x, int y, char[][] board)
    {
        board[x][y] = 'X';
    }
}

/**
 * Move point (x,y) on a two-dimensional plane.
 */
class DirectionMatrix{
    private int[] left = new int[]{-1,0};
    private int[] right = new int[]{1,0};
    private int[] down = new int[]{0,-1};
    private int[] up = new int[]{0,1};

    private int[][] directions = { left, right, down, up };

    public int[] moveLeft(int x, int y)
    {
        x += left[0];
        y += left[1];
        return new int[]{ x, y };
    }


    public int[] moveRight(int x, int y)
    {
        x += right[0];
        y += right[1];
        return new int[]{ x, y };
    }
    public int[] moveDown(int x, int y)
    {
        x += down[0];
        y += down[1];
        return new int[]{ x, y };
    }
    public int[] moveUp(int x, int y)
    {
        x += up[0];
        y += up[1];
        return new int[]{ x, y };
    }

}

class UF {
    // 记录等价类个数.
    private int count;

    // 节点 x 的父节点是 parent[x]
    private int[] parent;

    public UF(int n)
    {
        this.count = n;

        parent = new int[n];
        for( int i=0; i < n; i++)
        {
            parent[i] = i;
        }
    }

    /**
     * connect p and q. The new root will be p's root.
     */
    public void union(int p, int q)
    {
        int rootP = find(p);
        int rootQ = find(q);

        if( rootP == rootQ )
            return;
        else
        {
            // 将两棵树合并为一棵
            parent[rootQ] = rootP;
            count--;// 两个等价类合而为一
        }
    }
    /* 判断 p 和 q 是否connected, 即IS操作. connected关系是一个等价关系 */
    public boolean connected(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);

        return rootP==rootQ;
    }
    /* 返回图中有多少个连通分量 */
    public int count(){
        return count;
    }

    /* 返回某个节点 x 的根节点, 即x所在等价类的代表元 */
    private int commonFind(int x)
    {
        // 根节点root具有的特性: parent[root] == root
        while(x != parent[x])
        {
            x = parent[x];
        }
        return x;
    }

    private int find(int x)
    {
        if(parent[x] != x)
        {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}

