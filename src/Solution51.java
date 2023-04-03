import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *  皇后可以攻击同一行、同一列、左上左下右上右下四个方向的任意单位。
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 */
class Solution51 {

    /**
     * 回溯算法, 迭代一行的所有位置, 对每一个位置进行递归. 回溯过程中, 先判断当前位置如果放了queen, 会不会invalid. 如果是valid, 则在当前位置放queen, 然后对下一行的所有位置进行迭代.
     * (因为根据queen的攻击机制, 同一行只能有一个queen. 所以放置了一个queen后, 只能到下一行去找queen了)
     * @param N
     * @return
     */
    public List<List<String>> solveNQueens(int N) {
        ChessBoard board = new ChessBoard(N);
        List<Board> solutions = new ArrayList<>();

        List<List<String>> res = new ArrayList<>();

        //迭代一行的所有位置
        for(int col = 0; col <= N-1; col++)
        {
            backtrack(N,0,0,col,board,solutions);
        }

        for( Board valid_board: solutions )
        {
            res.add( valid_board.to_String_List());
        }
        return res;

    }

    public List<Board> _solveNQueens(int N) {
        ChessBoard board = new ChessBoard(N);
        List<Board> solutions = new ArrayList<>();
//        res.add(new ArrayList<>())
        for(int col = 0; col <= N-1; col++)
        {
            backtrack(N,0,0,col,board,solutions);
        }

        return solutions;

    }

    /**
     *
     * @param N 棋盘的长/宽, 也是达到N皇后局面时场上的queen的个数
     * @param cnt 当前回溯开始前, 已放置的queen个数
     * @param row 当前回溯试图放置的queen的横坐标
     * @param col 当前回溯试图放置的queen的纵坐标
     * @param board 迭代中的棋盘
     * @param solutions
     */
    private void backtrack(int N, int cnt, int row, int col, ChessBoard board, List<Board> solutions)
    {

        if(cnt == N)
        {
            solutions.add(new ChessBoard(board));
            return;
        }

        if( row == N )// cnt < N && row == N, it fails
            return;


        //由于棋盘一开始没有queen, 之后一行行地尝试放queen. 因此在尝试当前位置前, 当前位置不可能是queen
        assert !board.is_queen(row, col);
        if( !board.queens_not_attack(row,col) )//只有当前位置放置queen后是valid的, 才能进行放置queen的尝试
            return;


        board.set_queen(row,col);//尝试在当前位置放置queen

        //如果当前的坐标已经在最后一行, 那么没必要对下一行的所有位置做迭代, 因为下一行不存在. 只需进一次board[N][0]的递归, 然后根据base case(cnt == N)直接返回.
        if( row == N-1)
        {
            backtrack(N,cnt+1,row+1,0,board,solutions);
        }

        //当前坐标已经放置了queen, 由于下一行还存在, 那么接下来尝试在下一行放置queen.
        else
        {
            for(int i = 0; i <= N-1; i++)
                backtrack(N,cnt+1,row+1,i,board,solutions);
        }


        board.remove_queen(row,col);//取消尝试

    }

    public static void main(String[] args)
    {
        Solution51 s = new Solution51();
//        System.out.print(s.solveNQueens(5));


        List<Board> res  = s._solveNQueens(5);
        for(Board item: res)
        {
            System.out.print(item);
            System.out.print("**************\n");
        }

    }







}
