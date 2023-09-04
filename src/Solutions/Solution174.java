package Solutions;

/**
 * 174. Dungeon Game
 */
public class Solution174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n=dungeon[0].length;
        Integer[][] memo = new Integer[m][n];
        dp(0,0, dungeon, memo);
        int minimumHP = memo[0][0];
        return minimumHP;
    }

    /**
     * 对memo[row][col]进行赋值. memo[row][col] = the knight's minimum initial health so that he can rescue the princess, which was in the bottom-right corner.
     *
     */
    private void dp(int row, int col, int[][] dungeon, Integer[][] memo)
    {
        int m = dungeon.length, n=dungeon[0].length;

        if(memo[row][col] != null)  return;

        //The minimum HP
        int minimumHP;
        int currentRoomValue = dungeon[row][col];
        if(row == m-1 && col == n-1) // the bottom-right corner
        {
            // minimumHP + currentRoomValue == 1
            // So minimumHP == 1 - currentRoomValue
            minimumHP = 1 - currentRoomValue;
        }
        else
        {
            //minimum HP (进入当前房间所需的血量 ) + currentRoomValue (当前房间具有的加/减血)== minimum HP for next room( 进入下一个房间所需的血量)
            // So: minimum HP = minimum HP for next room - currentRoomValue
            // Note: the knight has an initial health point represented by a positive integer. So we must have: minimum HP >= 1.

            // From current room, we have two choices: go downward or go rightward),
            // So: minimum HP for next room = min(minimum HP for rightward room, minimum HP for downward room)

            if(row+1 == m) // Can't go downward
            {
                //Since the bottom-right corner has been dealt with, there's no need to check this condition.
                dp(row, col+1, dungeon, memo);
                minimumHP = memo[row][col+1] - currentRoomValue;
            } else if (col+1 == n) { // Can't go rightward
                dp(row+1, col, dungeon, memo);
                minimumHP = memo[row+1][col] - currentRoomValue;
            }
            else
            {

                dp(row, col+1, dungeon, memo);
                dp(row+1, col, dungeon, memo);

                int minimumHPIfGoRightward = memo[row][col+1] - currentRoomValue;
                int minimumHPIfGoDownward = memo[row+1][col] - currentRoomValue;
                minimumHP = Math.min(minimumHPIfGoRightward, minimumHPIfGoDownward);
            }
        }
        memo[row][col] = minimumHP > 0 ? minimumHP : 1;//The knight has an initial health point represented by a positive integer.
    }
}
