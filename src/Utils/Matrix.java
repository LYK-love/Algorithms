package Utils;

import io.vavr.Tuple2;

import java.util.ArrayList;
import java.util.List;

/**
 * M*N matrix
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

    public Matrix(List<List<Integer>> m)
    {
        this( ArrayUtils.mapToIntArray_2D(m));
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


    /**
     * return all elements of the matrix in spiral order( clockwise )
     * E.g:
     * matrix:
     * 1 2 3
     * 4 5 6
     * 7 8 9
     *
     * Then the spiral order:
     * 1 2 3 6 9 8 7 4 5
     *
     * @return
     */
    public List<Integer> spiral_order()
    {
        List<Integer> res = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for( int j = 0; j < N; j++ )
            res.add(m[0][j]);

        for( int i = 1; i < M; i++ )
            res.add(m[i][N-1]);

        //If the current matrix only has one row, then don't need to traverse inversely
        //e.g: matrix: 5 6 7. Then the spiral order: 5 6 7. We don;t have to traverse inversely, which results in: 5 6 7 6
        if( M == 1 )
            ;
        else
        {
            for( int j = N-2; j >= 0; j-- )
                res.add(m[M-1][j]);
        }

        //The same as former
        if( N == 1 )
            ;
        else
        {
            for( int i = M-2; i >= 1; i-- )
                res.add(m[i][0]);
        }

        if(M <= 2 || N <= 2)
            ;
        else
        {
            Matrix inner_matrix = get_inner_matrix();
            res.addAll(inner_matrix.spiral_order());
        }
        return res;

    }

    /**
     * Get a deep copy of inner matrix of current matrix. If the current matrix is too small to have an inner matrix, then return null;
     * An inner matrix has size (M-2) * (N-2).
     * E.g:
     * current matrix:
     * 1 2 3 4
     * 4 5 6 8
     * 7 8 9 10
     * 11 12 13 14
     *
     * Then the returned inner matrix:
     *  5 6
     *  7 8
     *
     * @return
     */
    private Matrix get_inner_matrix()
    {
        if(M <= 2 || N <= 2)
            return null;

        int[][] inner_m = new int[M-2][N-2];
        ArrayUtils.matrix_deep_copy(m,1,1,inner_m,0,0,M-2,N-2);
        Matrix inner_matrix = new Matrix(inner_m);
        return inner_matrix;
    }


}
