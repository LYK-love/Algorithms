import java.util.ArrayList;
import java.util.List;

class Solution37 {
    static final int M = 9;
    static final int N = 9;


    public void solveSudoku(char[][] board) {
        char[][] resBoard = new char[M][N];
//        List<char[M][N]> res = new ArrayList<>();

        backtrack(board,0,0,resBoard);
        ArrayUtils.two_dimensions_array_deep_copy(resBoard,0,board,0,M,N);
    }

    /**
     * 使用回溯算法进行穷举：
     * 对每一个空着的格子穷举 1 到 9，如果遇到不合法的数字（在同一行或同一列或同一个 3×3 的区域中存在相同的数字）则跳过，如果找到一个合法的数字，则继续穷举下一个空格子
     * @param board 棋盘。 可以保证每次回溯开始前的棋盘是valid的
     * @param i 准备填入新数字的格子的行号
     * @param j 准备填入新数字的格子的列号
     * @param resBoard 在回溯过程中， 如果遇到终止条件， 则将结果放入resBoard
     */
    private void backtrack(char[][] board, int i, int j, char[][] resBoard)
    {
        //已经填满一行的N列， 换一行
        if( j == N)
        {
            backtrack(board,i+1,0,resBoard);
            return;
        }

        // 已经填满了M行, 此时的棋盘的结果就是正确结果。
        // 回溯算法终止, 将结果放入resBoard (如果有多个解, 那么就会将每个解放入解集中。 但是这道数独问题只有一个正确解， 因此resBoard不需要保存多个board)
        if( i == M)
        {

            ArrayUtils.two_dimensions_array_deep_copy(board,0,resBoard,0,M,N);
            return;
        }

        //如果该格子有预设数字，不用我们穷举
        if( board[i][j] != '.') {
            backtrack(board, i,j+1,resBoard);
            return;
        }
        else
        {
            //ch: 准备填入格子board[i][j]的新数字
            for( char ch = '1'; ch <= '9'; ch++ )
            {
                // 如果准备放到该格子的数字不合法，就跳过， 换个新数字
                if(!isValid(board,i,j,ch))
                    continue;

                //接下来向该格填入的数字ch都是合法的

                board[i][j] = ch; //尝试填入该数字. 由于该数字已经是valid的了. 因此这里可以保证了下一步回溯开始前的棋盘是valid的
                backtrack(board,i,j+1,resBoard);//
                board[i][j] = '.'; //撤销尝试
            }
        }
        return;
    }

    /**
     * 判断 board[i][j] 是否可以填入 n
     * @param board
     * @param row
     * @param col
     * @param ch
     * @return
     */
    private boolean isValid(char[][] board, int row, int col,  char ch)
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

    public static void main(String[] args)
    {
        Solution37 s = new Solution37();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        s.solveSudoku(board);
        Board resBoard = new Board(board);

        System.out.print(resBoard);


    }
}
