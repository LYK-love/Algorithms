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
     * 对memo[row][col]进行赋值. memo[row][col] = 进入当前房间所需的初始生命值(the knight's minimum initial health so that he can rescue the princess, which was in the bottom-right corner.)
     */
    private void dp(int row, int col, int[][] dungeon, Integer[][] memo)
    {
        int m = dungeon.length, n=dungeon[0].length;

        if(memo[row][col] != null)  return;



        int minimumHP; //进入当前房间所需的最小初始生命值
        int minimumHPForNextRoom; //进入下一个房间所需的最小初始生命值
        int currentRoomValue = dungeon[row][col]; //当前房间的魔法具有的加/减血 效果

        // minimum HP + currentRoomValue == minimum HP for next room
        // So: minimum HP = minimum HP for next room - currentRoomValue
        // Note: the knight has an initial health point represented by a positive integer. So we must have: minimum HP >= 1.

        // From current room, we have two choices: go downward or go rightward),
        // So: minimum HP for next room = min(minimum HP for rightward room, minimum HP for downward room)

        // Here we compute the minimum HP for next room:

        // For the bottom-right corner, since we need to let the knight be alive after saving the princess, the minimum HP for next room == 1.
        if(row == m-1 && col == n-1)
        {
            // minimumHP + currentRoomValue == 1
            // So minimumHP == 1 - currentRoomValue
            minimumHPForNextRoom = 1;
        }
        else if(row+1 == m){ // Can't go downward
            //The next room must be the rightward room.
            //Since the bottom-right corner has been dealt with, the current room can't be the corner, so it always has a rightward room.
            dp(row, col+1, dungeon, memo);
            minimumHPForNextRoom = memo[row][col+1];
        }
        else if (col+1 == n) { // Can't go rightward
            //The next room must be the rightward room.
            dp(row+1, col, dungeon, memo);
            minimumHPForNextRoom = memo[row+1][col];
        }
        else
        {
            dp(row, col+1, dungeon, memo);
            dp(row+1, col, dungeon, memo);

            minimumHPForNextRoom = Math.min(memo[row][col+1], memo[row+1][col]);
        }


        minimumHP = minimumHPForNextRoom - currentRoomValue;
        memo[row][col] = minimumHP > 0 ? minimumHP : 1;//minimum HP >= 1.
    }
}
