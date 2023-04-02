import io.vavr.Tuple2;

/**
 *
 */
public class Matrix{
    private int[][] m; //M * N matrix
    private int M;// number of lines
    private int N;// number of cols

    public Matrix(int[][] m)
    {
        this.m = m;
        M = m.length;
        N = m[0].length;
    }

    public int[][] get_m()
    {
        return m;
    }

    /**
     * transpose matrix
     */
    public void transpose()
    {
        for( int j = 0; j < N; j++ ) //col num
        {
            int cnt = j;
            assert cnt == j;
            for( int i = 0; i < cnt; i++ )//line num
            {
                //swap m[i][j] and m[j][i]
                int a = m[i][j];
                int b = m[j][i];
                Tuple2<Integer,Integer> tmp = ApiUtils.swap(a,b);
                a = tmp._1;
                b = tmp._2;
                m[i][j] = a;
                m[j][i] = b;
            }
        }
    }

    /**
     * Not using Tuple API
     */
    private void _transpose()
    {
        for( int j = 0; j < N; j++ ) //col num
        {
            int cnt = j;
            assert cnt == j;
            for( int i = 0; i < cnt; i++ )//line num
            {
                //swap m[i][j] and m[j][i]
                int a = m[i][j];
                int b = m[j][i];
                int tmp = a;
                a = b;
                b = tmp;

                m[i][j] = a;
                m[j][i] = b;
            }
        }
    }

    /**
     * reverse matrix by the perpendicular line
     */
    public void reverse_by_perpendicular()
    {

        for( int i = 0; i < M; i++ )
        {
            for( int j = 0; j < N/2; j++ )
            {
                int a = m[i][j];
                int b = m[i][N-1-j];
                int tmp = a;
                a = b;
                b = tmp;

                m[i][j] = a;
                m[i][N-1-j] = b;
            }
        }
    }

    private void _reverse_by_perpendicular()
    {

        for( int i = 0; i < M; i++ )
        {
            for( int j = 0; j < N/2; j++ )
            {
                int a = m[i][j];
                int b = m[i][N-1-j];
                int tmp = a;
                a = b;
                b = tmp;

                m[i][j] = a;
                m[i][N-1-j] = b;
            }
        }
    }

    /**
     * Print matrix.
     * E.g
     * Input: [[1,2,3],[4,5,6],[7,8,9]]
     * Output:
     * 1 2 3
     * 4 5 6
     * 7 8 9
     *
     * @return
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < M; i++ )
        {
            for( int j = 0; j < N; j++ )
            {
                if( j == N - 1 )
                    sb.append(m[i][j]).append('\n');
                else
                    sb.append(m[i][j]).append(" ");
            }
        }
        return sb.toString();
    }

}
