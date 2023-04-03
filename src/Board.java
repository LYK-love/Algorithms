import java.util.ArrayList;
import java.util.List;

/**
 * 棋盘类
 */
public class Board{
    char[][] board;

    //行数
    int M;

    //列数
    int N;

    char default_chess = '.';
    char queen = 'Q';


    public Board(char[][] board)
    {
        this.M = board.length;
        this.N = board[0].length;
        this.board = new char[M][N];
        ArrayUtils.two_dimensions_array_deep_copy(board,0,this.board,0,M,N);

    }

    public Board(int M, int N)
    {
        this.board = new char[M][N];
        this.M = M;
        this.N = N;
        init_board();
    }

    public Board(Board ori_board)
    {
        this(ori_board.board);
    }

    /**
     * 初始化一个N * N的正方形棋盘
     * @param N
     */
    public Board(int N)
    {
        this(N,N);
    }

    /**
     * 将棋盘的所有位置赋值为'.'
     */
    private void init_board()
    {
        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)
                board[i][j] = default_chess;
    }


    @Override
    public String toString()
    {
        StringBuilder res_sb = new StringBuilder();

        for(int i = 0; i < M; i++ )
        {
            for(int j = 0; j < N; j++)
            {
                res_sb.append(board[i][j]);

                if(j!= N-1)
                    res_sb.append(" ");
                else
                    res_sb.append('\n');
            }
        }
        String res = res_sb.toString();
        return res;
    }

    /**
     * Transfer board from char[][] to List<String>
     * @return
     */
    public List<String> to_String_List()
    {
        List<String> res = new ArrayList<>();
        for( int row = 0; row < M; row++ )
        {
            res.add( String.valueOf(get_row_of_board(row)));
        }
        return res;
    }

    public char get_chess(int row, int col)
    {
        return board[row][col];
    }

    public char[] get_row_of_board(int row)
    {
        StringBuilder res_row = new StringBuilder();
        for(int col = 0; col <= N-1; col++)
        {

            res_row.append(board[row][col]);
        }
        return res_row.toString().toCharArray();
    }

    public char[] get_col_of_board(int col)
    {
        StringBuilder res_col = new StringBuilder();
        for(int row = 0; row <= M-1; row++)
        {

            res_col.append(board[row][col]);
        }
        return res_col.toString().toCharArray();
    }

    /**
     * Given a coordinate, get all chess in the primary_diagonal centered on the coordinate
     * @param row
     * @param col
     * @return
     */
    public char[] get_primary_diagonal(int row, int col)
    {
        StringBuilder sb = new StringBuilder();

        //左上方+给定位置+右下方

        //左上方
        for (int i = row - 1, j = col - 1;
             coordinate_is_valid(i,j); i--, j--) {
            sb.append(board[i][j]);
        }

        //给定位置
        sb.append(board[row][col]);

        //右下方
        for (int i = row + 1, j = col + 1;
             coordinate_is_valid(i,j); i++, j++) {
            sb.append(board[i][j]);
        }
        return sb.toString().toCharArray();
    }

    /**
     * Given a coordinate, get all chess in the secondary_diagonal centered on the coordinate
     * @param row
     * @param col
     * @return
     */
    public char[] get_secondary_diagonal(int row, int col)
    {
        StringBuilder sb = new StringBuilder();

        //右上方+给定位置+左下方

        //右上方
        for (int i = row - 1, j = col + 1;
             coordinate_is_valid(i,j); i--, j++) {
            sb.append(board[i][j]);
        }

        //给定位置
        sb.append(board[row][col]);

        //左下方
        for (int i = row + 1, j = col - 1;
             coordinate_is_valid(i,j); i++, j--) {
            sb.append(board[i][j]);
        }

        return sb.toString().toCharArray();
    }

    public void set_chess(int row, int col, char new_chess)
    {
        board[row][col] = new_chess;
    }


    public void remove_chess(int row, int col)
    {
        set_chess(row,col,default_chess);
    }

    public boolean coordinate_is_valid(int row, int col)
    {
        return (row >= 0 && row <= M - 1) && (col >= 0 && col <= N - 1);
    }

    public boolean isValid(int N, char[][] board, int row, int col, int ch)
    {
        boolean res = true;

        for(int i = 0; i < M; i++)
        {
            if(board[row][i] == ch) return false; // 判断行是否存在重复
            if(board[i][col] == ch) return false; // 判断列是否存在重复
            if( board[(row/3) * 3 + i/3 ][ (col/3) * 3 + i%3 ] == ch ) return false;// 判断 3 x 3 方框是否存在重复
        }
        return true;
    }


}