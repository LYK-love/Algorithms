//import java.util.ArrayList;
//import java.util.List;
//import java.util.Arrays;
//
//
//
//class ArrayUtils {
//
//    public static void two_dimensions_array_deep_copy(char[][] src,  int  srcPos,
//                                                      char[][] dest, int destPos,
//                                                      int M, int N)
//    {
//        for( int k = 0; k < M; k++)
//            System.arraycopy(src[k],0, dest[k],0, N);
//    }
//
//    public static int get_index_of_the_first_occurrence_of_max_element(int[] nums)
//    {
//        if(nums == null || nums.length == 0)
//            return -1;
//
//        int max_val = nums[0];
//        int idx_of_max_val = 0;
//        for(int i = 1; i < nums.length; i++)
//        {
//            if( max_val < nums[i])
//            {
//                max_val = nums[i];
//                idx_of_max_val = i;
//            }
//        }
//        return idx_of_max_val;
//    }
//
//    /**
//     *
//     * @param nums
//     * @return
//     */
//    public static int get_index_of_the_last_occurrence_of_max_element(int[] nums)
//    {
//        int idx_of_the_first_occurrence_of_max_element = get_index_of_the_first_occurrence_of_max_element(nums);
//        int p = idx_of_the_first_occurrence_of_max_element;//得到要找到的元素的最左边界, 然后指针不断右移
//        while( p + 1 < nums.length && nums[p+1] == nums[p])
//            p++;
//        return p;
//    }
//    public static int get_max( int[] nums )
//    {
//        int max = Arrays.stream(nums).max().getAsInt();
//        return max;
//    }
//
//    public static int get_min( int[] nums )
//    {
//        int min = Arrays.stream(nums).min().getAsInt();
//        return min;
//    }
//
//    /**
//     * Create an array copy of nums, this copy removes the first occurrence of the specified element from this array.
//     * @param nums
//     * @param element
//     * @return
//     */
//    public static int[] remove(int[] nums, int element)
//    {
//        int[] new_arr = new int[nums.length-1];
//        for(int i = 0, j = 0; i < new_arr.length; j++)
//        {
//            if(nums[j] == element)
//            {
//                continue;
//            }
//
//            new_arr[i] = nums[j];
//            i++;
//        }
//        return new_arr;
//    }
//
//    /**
//     * Create an array copy of nums, this copy removes the element of  given index
//     * @param nums
//     * @param index
//     * @return
//     */
//    public static int[] remove_with_index(int[] nums, int index)
//    {
//        int[] new_arr = new int[nums.length-1];
//        for(int i = 0, j = 0; i < new_arr.length; j++)
//        {
//            if(j == index)
//            {
//                continue;
//            }
//
//            new_arr[i] = nums[j];
//            i++;
//        }
//        return new_arr;
//    }
//
//    /**
//     * Create an array copy of nums, this copy inserts the specified element at the specified position in this list.
//     * @param nums
//     * @param index
//     * @param element
//     * @return
//     */
//    public static int[] add(int[] nums, int index, int element)
//    {
//        int origin_len = nums.length;
//        int[] new_arr = new int[origin_len+1];
//        for(int i = 0, j=0; i < new_arr.length; i++)
//        {
//            if( i == index )
//            {
//                new_arr[i] = element;
//                continue;
//            }
//
//            new_arr[i] = nums[j];
//            j++;
//        }
//        return new_arr;
//    }
//
//    /**
//     * compare two 2-d arrays
//     * @param a
//     * @param a2
//     * @return
//     */
//    public static boolean equals(int[] a, int[] a2) {
//        if (a==a2)
//            return true;   //1.如果名字相同，返回true
//        if (a==null || a2==null)
//            return false;  //2.如果其中一个为空，返回false
//
//        int length = a.length;
//        if (a2.length != length)
//            return false;  //3.如果两个数组长度不同，返回false
//
//        for (int i=0; i<length; i++)
//            if (a[i] != a2[i])
//                return false;  //4.每一个元素进行对比，如果有一个不同，返回false
//
//        return true;       //5.走到这一步就说明数组中每个元素都相等，返回true
//    }
//
//}
//
///**
// * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
// *  皇后可以攻击同一行、同一列、左上左下右上右下四个方向的任意单位。
// * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
// *
// * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
// */
//class Solution51 {
//    public List<List<String>> solveNQueens(int N) {
//        ChessBoard board = new ChessBoard(N);
//        List<Board> solutions = new ArrayList<>();
//
//        List<List<String>> res = new ArrayList<>();
////        res.add(new ArrayList<>())
//        for(int col = 0; col <= N-1; col++)
//        {
//            backtrack(N,0,0,col,board,solutions);
//        }
//
//        for( Board valid_board: solutions )
//        {
//            res.add( valid_board.to_String_List());
//        }
//        return res;
//
//    }
//
//    public List<Board> _solveNQueens(int N) {
//        ChessBoard board = new ChessBoard(N);
//        List<Board> solutions = new ArrayList<>();
////        res.add(new ArrayList<>())
//        for(int col = 0; col <= N-1; col++)
//        {
//            backtrack(N,0,0,col,board,solutions);
//        }
//
//        return solutions;
//
//    }
//
//    private void backtrack(int N, int cnt, int row, int col, ChessBoard board, List<Board> solutions)
//    {
////        if( !board_safe(track,row,col) )
////            return;
//
//        if(cnt == N)
//        {
//            solutions.add(new ChessBoard(board));
//            return;
//        }
//
//        if( row == N )// cnt < N && row == N, it fails
//            return;
//
//
//
////        if(col == N-1 )
////        {
////            col = 0;
////            row++;
////            if( row == N )
////            {
////                return;
////            }
////        }
//
//        if( !board.queens_not_attack(row,col) )
//            return;
//
//
//        board.set_queen(row,col);
//
//        if( row == N-1)
//        {
//            backtrack(N,cnt+1,row+1,0,board,solutions);
//        }
//        else
//        {
//            for(int i = 0; i <= N-1; i++)
//                backtrack(N,cnt+1,row+1,i,board,solutions);
//        }
//
//
//        board.remove_queen(row,col);
//
//    }
//
//
//
//}
//
//class ChessBoard extends Board{
//
//
//    char default_chess = '.';
//    char queen = 'Q';
//
//
//    public ChessBoard(int N) {
//        super(N);
//    }
//
//    public ChessBoard(ChessBoard ori_board)
//    {
//        super(ori_board);
//    }
//
//
//    /**
//     * 判断在给定坐标是皇后棋子的情况下, 棋盘是否valid. 棋盘valid, 当且仅当皇后之间不互相攻击.
//     * 皇后可以攻击同一行、同一列、左上左下右上右下四个方向的任意单位。
//     * 该方法假设棋盘在没有放置该棋子的情况下已经是valid的.
//     * @param row
//     * @param col
//     * @return
//     */
//    public boolean queens_not_attack(int row, int col)
//    {
//        for(int i = 0; i < N; i++)
//        {
//            if(board[row][i] == queen) return false; // 判断行是否存在重复
//            if(board[i][col] == queen) return false; // 判断列是否存在重复
//            int a = (row/3) * 3 + i/3;
//            int b = (col/3) * 3 + i%3;
////            if( a == N || b == N)
////                System.out.println("dada");
//        }
//        if( cooridinate_is_valid(row-1,col-1) && board[row-1][col-1] == queen ||
//                cooridinate_is_valid(row-1,col+1) && board[row-1][col+1] == queen ||
//                cooridinate_is_valid(row+1,col-1) && board[row+1][col-1] == queen ||
//                cooridinate_is_valid(row+1,col+1) && board[row+1][col+1] == queen )
//            return false;
//
//        return true;
//    }
//
//    public void set_queen(int row, int col)
//    {
//
//        set_chess(row,col,queen);
//    }
//
//    public void remove_queen(int row, int col)
//    {
//        remove_chess(row,col);
//    }
//
//}
//
//
///**
// * 棋盘类
// */
//class Board{
//    char[][] board;
//
//    //行数
//    int M;
//
//    //列数
//    int N;
//
//    char default_chess = '.';
//    char queen = 'Q';
//
//
//    public Board(char[][] board)
//    {
//        this.M = board.length;
//        this.N = board[0].length;
//        this.board = new char[M][N];
//        ArrayUtils.two_dimensions_array_deep_copy(board,0,this.board,0,M,N);
//
//    }
//
//    public Board(int M, int N)
//    {
//        this.board = new char[M][N];
//        this.M = M;
//        this.N = N;
//        init_board();
//    }
//
//    public Board(Board ori_board)
//    {
//        this(ori_board.board);
//    }
//
//    /**
//     * 初始化一个N * N的正方形棋盘
//     * @param N
//     */
//    public Board(int N)
//    {
//        this(N,N);
//    }
//
//    /**
//     * 将棋盘的所有位置赋值为'.'
//     */
//    private void init_board()
//    {
//        for(int i = 0; i < M; i++)
//            for(int j = 0; j < N; j++)
//                board[i][j] = default_chess;
//    }
//
//
//    @Override
//    public String toString()
//    {
//        StringBuilder res_sb = new StringBuilder();
//
//        for(int i = 0; i < M; i++ )
//        {
//            for(int j = 0; j < N; j++)
//            {
//                res_sb.append(board[i][j]);
//
//                if(j!= N-1)
//                    res_sb.append(" ");
//                else
//                    res_sb.append('\n');
////                else
////                {
////                    if(i != M-1) //最后一行后面没有换行符
////                        res_sb.append('\n');
////                }
//
//            }
//        }
//        String res = res_sb.toString();
//        return res;
//    }
//
//    /**
//     * Transfer board from char[][] to List<String>
//     * @return
//     */
//    public List<String> to_String_List()
//    {
//        List<String> res = new ArrayList<>();
//        for( int row = 0; row < M; row++ )
//        {
//            res.add( String.valueOf(get_row_of_board(row)));
//        }
//        return res;
//    }
//
//    public char get_chess(int row, int col)
//    {
//        return board[row][col];
//    }
//
//    public char[] get_row_of_board(int row)
//    {
//        StringBuilder res_row = new StringBuilder();
//        for(int col = 0; col <= N-1; col++)
//        {
//
//            res_row.append(board[row][col]);
//        }
//        return res_row.toString().toCharArray();
//    }
//
//    public char[] get_col_of_board(int col)
//    {
//        StringBuilder res_col = new StringBuilder();
//        for(int row = 0; row <= M-1; row++)
//        {
//
//            res_col.append(board[row][col]);
//        }
//        return res_col.toString().toCharArray();
//    }
//
//    public void set_chess(int row, int col, char new_chess)
//    {
//        board[row][col] = new_chess;
//    }
//
//
//    public void remove_chess(int row, int col)
//    {
//        set_chess(row,col,default_chess);
//    }
//
//    public boolean cooridinate_is_valid(int row, int col)
//    {
//        return (row >= 0 && row <= M - 1) && (col >= 0 && col <= N - 1);
//    }
//
//    public boolean isValid(int N, char[][] board, int row, int col, int ch)
//    {
//        boolean res = true;
//
//        for(int i = 0; i < M; i++)
//        {
//            if(board[row][i] == ch) return false; // 判断行是否存在重复
//            if(board[i][col] == ch) return false; // 判断列是否存在重复
//            if( board[(row/3) * 3 + i/3 ][ (col/3) * 3 + i%3 ] == ch ) return false;// 判断 3 x 3 方框是否存在重复
//        }
//        return true;
//    }
//
//
//}
//
//public class KK {
//    public static void main(String[] args)
//    {
//        Solution51 s = new Solution51();
//        System.out.print(s.solveNQueens(4));
//
//    }
//
//}
//
//
