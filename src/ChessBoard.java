/**
 * 国际象棋棋盘, 是N * N的正方形. 棋子分为默认棋子('.')和皇后('.')
 */
public class ChessBoard extends Board{


    char default_chess = '.';
    char queen = 'Q';


    public ChessBoard(int N) {
        super(N);
    }

    public ChessBoard(ChessBoard ori_board)
    {
        super(ori_board);
    }


    /**
     * 在给定坐标将要放置queen的情况下, 判断棋盘是否会valid. 棋盘valid, 当且仅当皇后之间不互相攻击.
     * 皇后可以攻击以自身为中心, 同一行、同一列、同一个正对角线, 同一个负对角线的所有单位
     * 该方法假设棋盘在没有放置该棋子的情况下已经是valid的, 且给定坐标的原棋子不是queen.
     *
     * @param row
     * @param col
     * @return false iff 在给定坐标将要放置queen的情况下, 棋盘会valid or 给定坐标原位置就是queen
     */
    public boolean queens_not_attack(int row, int col)
    {

        String primary_diagonal = String.valueOf(get_primary_diagonal(row,col));
        String secondary_diagonal = String.valueOf(get_secondary_diagonal(row,col));

        for(int i = 0; i < N; i++)
        {
            if(board[row][i] == queen) return false; // 判断行是否存在重复
            if(board[i][col] == queen) return false; // 判断列是否存在重复
        }

        if(primary_diagonal.contains(""+queen)) return false;
        if(secondary_diagonal.contains(""+queen)) return false;


        return true; //该方法假设给定坐标上的原棋子不是queen. 因为如果是的话, 该
    }

    public boolean is_queen(int row, int col)
    {
        return board[row][col] == queen;
    }
    public void set_queen(int row, int col)
    {

        set_chess(row,col,queen);
    }



    public void remove_queen(int row, int col)
    {
        remove_chess(row,col);
    }

}
